CREATE DATABASE sgd;
USE sgd;
DROP DATABASE sgd;

-- SECTION 1
-- 01. Table design

CREATE TABLE addresses (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE categories (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE offices (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`workspace_capacity` INT NOT NULL,
`website` VARCHAR(50),
`address_id` INT NOT NULL,
CONSTRAINT fk_offices_addresses
FOREIGN KEY (address_id)
REFERENCES addresses (id)
);

CREATE TABLE employees (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`salary` DECIMAL(10, 2) NOT NULL,
`job_title` VARCHAR(20) NOT NULL,
`happiness_level` CHAR(1)
);

CREATE TABLE teams (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`office_id` INT NOT NULL,
`leader_id`INT NOT NULL UNIQUE,
CONSTRAINT fk_teams_offices
FOREIGN KEY (office_id)
REFERENCES offices (id),
CONSTRAINT fk_teams_employees
FOREIGN KEY (leader_id)
REFERENCES employees (id)
);

CREATE TABLE games (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)  NOT NULL UNIQUE,
`description` TEXT,
`rating` FLOAT DEFAULT 5.5 NOT NULL,
`budget` DECIMAL(10, 2) NOT NULL,
`release_date` DATE,
`team_id` INT NOT NULL,
CONSTRAINT fk_games_teams
FOREIGN KEY (team_id)
REFERENCES teams (id)
);

CREATE TABLE games_categories (
`game_id` INT NOT NULL,
`category_id` INT NOT NULL,
CONSTRAINT PRIMARY KEY(game_id, category_id),
CONSTRAINT fk_gc_games
FOREIGN KEY  (game_id)
REFERENCES games (id),
CONSTRAINT fk_gc_categories
FOREIGN KEY (category_id)
REFERENCES categories (id)
);

-- SECTION 2 
-- 02.Insert

INSERT INTO games (`name`, `rating`, `budget`, `team_id`)
SELECT LOWER(REVERSE(SUBSTR(t.`name`, 2))), t.id, t.leader_id * 1000, t.id FROM teams AS t
WHERE t.id BETWEEN 1 AND 9;

-- 03.Update

UPDATE employees AS e
JOIN teams AS t ON t.leader_id = e.id
SET `salary` = `salary` + 1000
WHERE e.age < 40 AND e.salary < 5000;

-- 04.Delete

DELETE g FROM games AS g
LEFT JOIN games_categories AS gc ON gc.game_id = g.id
WHERE gc.category_id IS NULL AND g.release_date IS NULL;

-- 05.EMployees

SELECT first_name,
last_name,
age,
salary,
happiness_level
 FROM employees
ORDER BY salary, id;

-- 06.Address of the teams

SELECT t.`name`  AS team_name, a.`name` AS address_name, CHAR_LENGTH(a.name) AS count_of_characters FROM teams AS t
JOIN offices AS o ON t.office_id = o.id
JOIN addresses AS a ON o.address_id = a.id
WHERE o.website IS NOT NULL
ORDER BY team_name, address_name;

-- 07.Categoties info
-- Now, we need a more detailed information about categories – count of game, average budget and max rating.
-- Select all categories names, count of the games from each category, the average budget (rounded to the second digit after the decimal point) of all games from the current category and the max rating of games from a category.
-- Order the result by count of games in descending order, then by the name of the category alphabetically. 
-- Skip categories with max r	ating lower than 9.5(exclusive).


SELECT c.name, COUNT(gc.game_id) AS games_count, ROUND(AVG(g.budget), 2) AS avg_budget, MAX(g.rating) AS max_rating FROM categories AS c
JOIN games_categories AS gc ON gc.category_id = c.id
JOIN games AS g ON gc.game_id = g.id
GROUP BY c.id
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.name;

-- 08.Games of 2022

SELECT g.`name`, g.release_date, CONCAT(SUBSTR(g.description , 1, 10), '...') AS summary,
		(CASE
        WHEN MONTH(release_date) IN (1, 2, 3) THEN 'Q1'
        WHEN MONTH(release_date) IN (4, 5, 6) THEN 'Q2'
        WHEN MONTH(release_date) IN (7, 8, 9) THEN 'Q3'
        ELSE 'Q4'
        END) AS 'quarter',
        t.name AS team_name FROM games AS g
JOIN teams AS t ON g.team_id = t.id
WHERE g.`name` LIKE '%2'
AND MONTH(g.release_date) MOD 2 = 0
AND YEAR(release_date) = 2022
ORDER BY `quarter`;

-- 09 Full info for games

SELECT g.name, IF(g.budget < 50000, 'Normal budget', 'Insufficient budget') AS budget_level, t.name AS team_name, a.name AS address_name FROM games AS g
JOIN teams AS t ON t.id = g.team_id
JOIN offices AS o ON t.office_id = o.id
JOIN addresses AS a ON o.address_id = a.id 
LEFT JOIN games_categories AS gc ON gc.game_id = g.id
WHERE g.release_date IS NULL 
AND gc.category_id IS NULL
ORDER BY g.name;

-- SECTION 4
-- 10.Find all basic information for a game

CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS VARCHAR(255)
		RETURN(
			SELECT concat('The ',g.name, ' is developed by a ',t.name, ' in an office with an address ',a.name) AS info FROM games AS g
			JOIN teams AS t ON g.team_id = t.id
            JOIN offices AS o ON t.office_id = o.id
            JOIN addresses AS a ON o.address_id = a.id
            WHERE g.name = game_name);
            
-- 11.Update budget of the games 

CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)
	UPDATE games AS g
	LEFT JOIN games_categories AS gc ON gc.game_id = g.id
    SET g.release_date = DATE_ADD(g.release_date, INTERVAL 1 YEAR), g.budget = g.budget + 100000 
    WHERE g.release_date IS NOT NULL 
    AND rating > min_game_rating;
    