CREATE DATABASE softuni_imdb;
USE softuni_imdb;
DROP DATABASE softuni_imdb;

-- SECTION 1
-- 01.Table design

CREATE TABLE countries (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE,
continent VARCHAR(30) NOT NULL,
currency VARCHAR(5) NOT NULL
);

CREATE TABLE genres (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE actors (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
birthdate DATE NOT NULL,
height INT,
awards INT,
country_id INT NOT NULL,
CONSTRAINT fk_actors_countries
FOREIGN KEY (country_id)
REFERENCES countries(id)
);

CREATE TABLE movies_additional_info (
id INT PRIMARY KEY AUTO_INCREMENT,
rating DECIMAL(10, 2) NOT NULL,
runtime INT NOT NULL,
picture_url VARCHAR(80) NOT NULL,
budget DECIMAL(10, 2),
release_date DATE NOT NULL,
has_subtitles TINYINT(1),
description TEXT
);

CREATE TABLE movies (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(70) NOT NULL UNIQUE,
country_id INT NOT NULL,
movie_info_id INT NOT NULL UNIQUE,
CONSTRAINT fk_movies_movies_info
FOREIGN KEY (movie_info_id)
REFERENCES movies_additional_info (id),
CONSTRAINT fk_movies_countries
FOREIGN KEY (country_id)
REFERENCES countries(id)
);

CREATE TABLE movies_actors (
movie_id INT,
actor_id INT,
CONSTRAINT fk_ma_movies
FOREIGN KEY (movie_id)
REFERENCES movies(id),
CONSTRAINT fk_ma_actors
FOREIGN KEY (actor_id)
REFERENCES actors(id)
);

CREATE TABLE genres_movies (
genre_id INT,
movie_id INT,
CONSTRAINT fk_gm_genre
FOREIGN KEY (genre_id)
REFERENCES genres(id),
CONSTRAINT fk_gm_movie
FOREIGN KEY (movie_id)
REFERENCES movies(id)
);

-- SECTION 2
-- 02.Insert

INSERT INTO actors(first_name, last_name, birthdate, height, awards, country_id)
SELECT REVERSE(first_name), REVERSE(last_name), DATE_ADD(birthdate, INTERVAL -2 DAY), height + 10, country_id, (SELECT id FROM countries WHERE name = 'Armenia') FROM actors
WHERE id <= 10;

-- 03.Update

UPDATE movies_additional_info AS m 
SET m.runtime = m.runtime - 10 
WHERE m.id BETWEEN 15 AND 25;

-- 04.Delete

DELETE c FROM countries AS c
LEFT JOIN movies AS m ON m.country_id = c.id
WHERE m.country_id IS NULL;

-- SECTION 3
-- 05.Countries

SELECT * FROM countries
ORDER BY currency DESC, id;

-- 06.Old movies

SELECT m.id, m.title, mi.runtime, mi.budget, mi.release_date FROM movies AS m
JOIN movies_additional_info AS mi ON m.movie_info_id = mi.id
WHERE YEAR(mi.release_date) BETWEEN 1996 AND 1999
ORDER BY mi.runtime, m.id
LIMIT 20;

-- 07.Movie casting

SELECT CONCAT(first_name, ' ', last_name) AS full_name,
		CONCAT(REVERSE(last_name), CHAR_LENGTH(last_name), '@cast.com') AS email,
        2022 - YEAR(birthdate) AS age,
        height FROM actors AS a
LEFT JOIN movies_actors AS ma ON ma.actor_id = a.id
WHERE ma.movie_id IS NULL
ORDER BY a.height;

-- 08.International festival

SELECT c.name, COUNT(m.id) FROM countries AS c
JOIN movies AS m ON m.country_id = c.id
GROUP BY c.name
HAVING COUNT(m.id) >= 7
ORDER BY c.name DESC;

-- 09.Rating system

SELECT m.title,
	IF(mi.rating <= 4, 'poor',
    IF(mi.rating <= 7, 'good', 'excellent')) AS rating,
    IF(mi.has_subtitles = 0, '-', 'english') AS subtitles,
    mi.budget AS budget FROM movies AS m
JOIN movies_additional_info AS mi ON m.movie_info_id = mi.id
ORDER BY budget DESC;

-- SECTION 4
-- 10.History movies

CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
	RETURN(
		SELECT COUNT(ma.movie_id) FROM actors AS a
        JOIN movies_actors AS ma ON ma.actor_id = a.id
        JOIN movies AS m ON ma.movie_id = m.id
        JOIN genres_movies AS gm ON m.id = gm.movie_id
        JOIN genres AS g ON gm.genre_id = g.id
        WHERE a.first_name = SUBSTR(full_name, 1 ,LOCATE(' ', full_name) - 1)
        AND a.last_name = SUBSTR(full_name, LOCATE(' ', full_name) + 1) 
        AND g.name = 'History');
		
-- 11.Movie awards

CREATE PROCEDURE udp_award_movie (movie_title VARCHAR(50))
UPDATE actors AS a
JOIN movies_actors AS ma ON ma.actor_id = a.id
JOIN movies AS m ON ma.movie_id = m.id
SET awards = awards + 1
WHERE m.title = movie_title;