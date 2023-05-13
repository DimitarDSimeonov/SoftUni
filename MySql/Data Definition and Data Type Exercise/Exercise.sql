CREATE DATABASE minions;

USE minions;

-- 1.Create tables
CREATE TABLE minions (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT 
);

CREATE TABLE towns (
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

-- 2. Alter minions table

ALTER TABLE towns
RENAME COLUMN `town_id` TO `id`;

ALTER TABLE minions
ADD COLUMN `town_id` INT;

ALTER TABLE minions
ADD CONSTRAINT fk_minion FOREIGN KEY (town_id)
REFERENCES towns (id);

-- 3. Inser records in both tables

INSERT INTO towns (`name`)
VALUES ('Sofia'),
('Plovdiv'),
('Varna');

INSERT INTO minions (name, age, town_id)
VALUES ('Kevin', 22, 1),
('Bob', 15, 3),
('Steward', NULL, 2);

-- 4. Truncate table minions

TRUNCATE  minions;

-- 5. Drop all tables

DROP TABLES minions, towns;

-- 6. Create table people

CREATE TABLE people (
`id` INT AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB(2097152),
`height` DOUBLE(3,2),
`weight` DOUBLE(5,2),
`gender` VARCHAR(1) ,
`birthdate`DATE NOT NULL,
`biography` TEXT,
PRIMARY KEY (id)
);

INSERT INTO people (`name`, `gender`, `birthdate`)
VALUES ('test1', 'f', '1999-10-31'),
('test2', 'm', '2000-12-21'),
('test3', 'f', '1990-05-02'),
('test4', 'm', '1960-03-12'),
('test5', 'f', '1990-03-12');

-- 7. Create table users

CREATE TABLE users (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profil_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN
);

INSERT INTO users (`username`, `password`)
VALUES ('user1', 'pass1'),
('user2', 'psss2'),
('user3', 'pass3'),
('user4', 'pass4'),
('user5', 'pass5');

-- 8. Change primary key --

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY (id, username);

-- 9. Set default value of a field

ALTER TABLE users
CHANGE last_login_time 
last_login_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- 10. Set unique field

ALTER TABLE users
DROP PRIMARY KEY,
ADD UNIQUE (username),
ADD CONSTRAINT pk_users PRIMARY KEY (id);

-- 11. Movies database 

CREATE DATABASE `Movies`;
USE Movies;

CREATE TABLE `directors` (
`id` INT AUTO_INCREMENT,
`director_name` VARCHAR(255) NOT NULL,
`notes` TEXT,
PRIMARY KEY (id)
);

CREATE TABLE `genres`(
`id` INT AUTO_INCREMENT,
`genre_name` VARCHAR(255) NOT NULL,
`notes` TEXT,
PRIMARY KEY (id)
);

CREATE TABLE `categories` (
`id` INT AUTO_INCREMENT,
`category_name` VARCHAR(255) NOT NULL,
`notes` TEXT,
PRIMARY KEY (id)
);

CREATE TABLE `movies` (
`id` INT AUTO_INCREMENT,
`title` VARCHAR(255) NOT NULL,
`director_id` INT,
`copyright_year` DATE,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` TEXT,
PRIMARY KEY (id)
);

INSERT INTO `directors` (`id`, `director_name`)
VALUES (1,'director1'),
(2,'director2'),
(3,'director3'),
(4,'director4'),
(5,'director5');

INSERT INTO `genres` (`id`, `genre_name`)
VALUES (1, 'genre1'),
(2, 'genre2'),
(3, 'genre3'),
(4, 'genre4'),
(5, 'genre5');

INSERT INTO `categories` (`id`, `category_name`)
VALUES (1, 'category1'),
(2, 'category2'),
(3, 'category3'),
(4, 'category4'),
(5, 'category5');

INSERT INTO `movies` (`id`, `title`)
VALUES (1, 'title1'),
(2, 'title2'),
(3, 'title3'),
(4, 'title4'),
(5, 'title5');

-- 12. Car rental database

CREATE DATABASE car_rental;

USE car_rental;

CREATE TABLE categories (
id INT AUTO_INCREMENT PRIMARY KEY,
category VARCHAR(30) NOT NULL,
daily_rate DOUBLE,
weekly_rate DOUBLE,
monthly_rate DOUBLE,
weekend_rate DOUBLE
);

CREATE TABLE cars (
id INT AUTO_INCREMENT PRIMARY KEY,
plate_number VARCHAR(10) NOT NULL,
make VARCHAR(30) NOT NULL,
model VARCHAR(30) NOT NULL,
car_year INT,
category_id INT,
doors INT,
picture BLOB,
car_condition VARCHAR(30),
available BOOLEAN
);

CREATE TABLE employees (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
title VARCHAR(30),
notes TEXT
);

CREATE TABLE customers (
id INT AUTO_INCREMENT PRIMARY KEY,
driver_licence_number VARCHAR(10) NOT NULL,
full_name VARCHAR(100) NOT NULL,
address VARCHAR(255),
city VARCHAR(30),
zip_code INT,
notes TEXT
);

CREATE TABLE rental_orders (
id INT AUTO_INCREMENT PRIMARY KEY,
employee_id INT NOT NULL,
customer_id INT NOT NULL,
car_id INT NOT NULL,
car_condition VARCHAR(30),
tank_level INT,
kilometrage_start INT,
kilometrage_end INT,
total_kilometrage INT,
start_date DATE,
end_date DATE,
total_days INT,
rate_applied DOUBLE,
tax_rate DOUBLE,
order_status VARCHAR(50),
notes TEXT
);

INSERT INTO categories (`category`)
VALUES ('category1'),
('category2'),
('category3');

INSERT INTO cars (plate_number , make, model)
VALUES ('number 1', 'make1', 'model1'),
('number 2', 'make2', 'model2'),
('number 3', 'make3', 'model3');

INSERT INTO employees (first_name, last_name)
VALUES ('name 1', 'family 1'),
('name 2', 'family 2'),
('name 3', 'family 3');

INSERT INTO customers (driver_licence_number, full_name)
VALUES ('licence 1', 'full name 1'),
('licence 2', 'full name 2'),
('licence 3', 'full name 3');

INSERT INTO rental_orders (employee_id, customer_id, car_id)
VALUES (1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- 13. Basic insert 

CREATE DATABASE soft_uni;
USE soft_uni;

CREATE table towns (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(15) NOT NULL
);

CREATE TABLE addresses (
id INT AUTO_INCREMENT PRIMARY KEY,
address_text TEXT,
town_id INT
);

CREATE TABLE departments (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL
);

CREATE TABLE employees (
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(20) NOT NULL,
middle_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
job_title VARCHAR(20),
department_id INT NOT NULL,
hire_date DATE NOT NULL,
salary DOUBLE,
address_id INT
);

ALTER TABLE addresses
ADD CONSTRAINT fk_addresses_towns 
FOREIGN KEY addresses (town_id) 
REFERENCES towns (id);

ALTER TABLE employees
ADD CONSTRAINT fk_employee_address
FOREIGN KEY employees (address_id)
REFERENCES addresses (id),
ADD CONSTRAINT fk_employee_department
FOREIGN KEY employees (department_id)
REFERENCES departments (id);

INSERT INTO towns (name)
VALUES ('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO departments (name)
VALUES ('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name,job_title, department_id, hire_date, salary)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);


-- 14. Basic Select All Fields

SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

-- 15. Basic Select All Fields and Order Them

SELECT * FROM towns as t
ORDER BY t.name ASC;
SELECT * FROM departments as d
ORDER BY d.name ASC;
SELECT * FROM employees as e 
ORDER BY e.salary DESC;

-- 16. Basic Select Some Fields

SELECT `name` FROM towns as t
ORDER BY t.name ASC;
SELECT `name` FROM departments as d
ORDER BY d.name ASC;
SELECT first_name, last_name, job_title, salary FROM employees as e
ORDER BY e.salary DESC;

-- 17. Increase Employees Salary

UPDATE employees 
SET salary = salary * 1.1;
SELECT salary FROM employees;