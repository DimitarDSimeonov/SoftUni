CREATE DATABASE universities_db;
USE universities_db;

-- SECTION 1
-- 01. Table desing

CREATE TABLE countries(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cities(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
population INT,
country_id INT NOT NULL,
CONSTRAINT fk_cities_countries
FOREIGN KEY (country_id)
REFERENCES countries (id)
);

CREATE TABLE universities(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL UNIQUE,
address VARCHAR(80) NOT NULL UNIQUE,
tuition_fee DECIMAL(19, 2) NOT NULL,
number_of_staff INT,
city_id INT,
CONSTRAINT fk_universities_cities
FOREIGN KEY (city_id)
REFERENCES cities(id)
);

CREATE TABLE students(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(40) NOT NULL,
age INT,
phone VARCHAR(20) NOT NULL UNIQUE,
email VARCHAR(255) NOT NULL UNIQUE,
is_graduated TINYINT(1) NOT NULL,
city_id INT,
CONSTRAINT fk_students_cities
FOREIGN KEY (city_id)
REFERENCES cities(id)
);

CREATE TABLE courses(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE,
duration_hours DECIMAL(19, 2),
start_date DATE,
teacher_name VARCHAR(60) NOT NULL UNIQUE,
`description` TEXT,
university_id INT,
CONSTRAINT fk_cources_universities
FOREIGN KEY (university_id)
REFERENCES universities (id)
);

CREATE TABLE students_courses(
grade DECIMAL(19, 2) NOT NULL,
student_id INT NOT NULL,
course_id INT NOT NULL,
CONSTRAINT fk_st_students
FOREIGN KEY (student_id)
REFERENCES students (id),
CONSTRAINT fk_sc_courses
FOREIGN KEY (course_id)
REFERENCES courses (id)
);


-- SECTIN 2
-- 2.Insert

INSERT INTO courses (name, duration_hours, start_date, teacher_name, description, university_id)
SELECT CONCAT(c.teacher_name, ' ', 'course'),
		CHAR_LENGTH(c.name)/10,
        DATE_ADD(c.start_date, INTERVAL 5 DAY),
        REVERSE(c.teacher_name),
        CONCAT('Course ', c.teacher_name, REVERSE(c.description)),
        DAY(c.start_date) FROM courses AS c
        WHERE c.id <= 5;
        
-- 3.Update

UPDATE universities 
SET tuition_fee = tuition_fee + 300
WHERE id BETWEEN 5 AND 12;

-- 4.Delete

DELETE u FROM universities AS u
WHERE number_of_staff IS NULL;

-- SECTION 3 
-- 05.Cities

SELECT * FROM cities
ORDER BY population DESC;

-- 06.Students age

SELECT first_name, last_name, age, phone, email FROM students
WHERE age >= 21
ORDER BY first_name DESC, email, id
LIMIT 10;

-- 07. New students

SELECT CONCAT_WS(' ', first_name, last_name) AS full_name, SUBSTR(email, 2, 10) AS username, REVERSE(phone) AS password FROM students AS s
LEFT JOIN students_courses AS sc ON sc.student_id = s.id
WHERE sc.course_id IS NULL
ORDER BY password DESC;

-- 08.Student count

SELECT COUNT(sc.student_id) AS students_count, u.name AS university_name FROM universities AS u
JOIN courses AS c ON c.university_id = u.id
JOIN students_courses AS sc ON c.id = sc.course_id
GROUP BY u.name
HAVING COUNT(sc.student_id) >= 8
ORDER BY students_count DESC, university_name DESC; 

-- 09.Price rank

SELECT u.name AS university_name, c.name AS city_name, u.address, 
		(CASE
        WHEN u.tuition_fee < 800 THEN 'cheap'
        WHEN u.tuition_fee < 1200 THEN 'normal'
        WHEN u.tuition_fee < 2500 THEN 'high'
        ELSE 'expensive'
        END) AS price_rank,
        u.tuition_fee FROM universities AS u
JOIN cities AS c ON u.city_id = c.id
ORDER BY u.tuition_fee;

-- SECTION 4
-- 10.AVerage grades

CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(19, 2)
	RETURN(
		SELECT AVG(sc.grade) FROM courses AS c
        JOIN students_courses AS sc ON c.id = sc.course_id
        JOIN students AS s ON sc.student_id = s.id
        WHERE c.name = course_name AND s.is_graduated = 1
        GROUP BY sc.course_id);
        
-- 11.Graduate students 

CREATE PROCEDURE udp_graduate_all_students_by_year(year_started INT)
UPDATE students AS s
JOIN students_courses AS sc ON sc.student_id = s.id
JOIN courses AS c ON sc.course_id = c.id
SET s.is_graduated = 1
WHERE YEAR(c.start_date) = year_started;
        