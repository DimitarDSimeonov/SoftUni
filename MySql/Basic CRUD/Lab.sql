CREATE DATABASE IF NOT EXISTS `hotel`; 
USE `hotel`;

CREATE TABLE departments (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

INSERT INTO departments(name) VALUES('Front Office'), ('Support'), ('Kitchen'), ('Other');

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	job_title VARCHAR(50) NOT NULL,
	department_id INT NOT NULL,
	salary DOUBLE NOT NULL,
	CONSTRAINT `fk_department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
);

INSERT INTO `employees` (`first_name`,`last_name`, `job_title`,`department_id`,`salary`) VALUES
	('John', 'Smith', 'Manager',1, 900.00),
	('John', 'Johnson', 'Customer Service',2, 880.00),
	('Smith', 'Johnson', 'Porter', 4, 1100.00),
	('Peter', 'Petrov', 'Front Desk Clerk', 1, 1100.00),
	('Peter', 'Ivanov', 'Sales', 2, 1500.23),
	('Ivan' ,'Petrov', 'Waiter', 3, 990.00),
	('Jack', 'Jackson', 'Executive Chef', 3, 1800.00),
	('Pedro', 'Petrov', 'Front Desk Supervisor', 1, 2100.00),
	('Nikolay', 'Ivanov', 'Housekeeping', 4, 1600.00);
	

	
CREATE TABLE rooms (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`type` VARCHAR(30)
);

INSERT INTO rooms(`type`) VALUES('apartment'), ('single room');

CREATE TABLE clients (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	room_id INT NOT NULL,
    CONSTRAINT fk_clients_rooms
    FOREIGN KEY (room_id)
    REFERENCES rooms(id)
);

INSERT INTO clients(`first_name`,`last_name`,`room_id`) 
VALUES('Pesho','Petrov', 1),('Gosho','Georgiev', 2),
('Mariya','Marieva', 2), ('Katya','Katerinova', 1), ('Nikolay','Nikolaev', 2);


-- Problem 1: Select Employee Information

SELECT id, first_name, last_name, job_title FROM employees as e
ORDER BY e.id ASC;

-- Problem 2: Select Employees with Filter

SELECT id, CONCAT(first_name," ", last_name) AS full_name, job_title, salary FROM employees AS e
WHERE salary > 1000.00
ORDER BY e.id;

-- Problem 3: Update Employees Salary

UPDATE `employees` 
SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';

-- Problem 4: Top Paid Employee

CREATE VIEW top_paid_employee AS
    SELECT * FROM employees AS e
    ORDER BY e.salary DESC
    LIMIT 1;
SELECT * FROM top_paid_employee;

-- Problem 5: Select Employees by Multiple Filters
SELECT * FROM employees AS e
WHERE e.department_id = 4 AND e.salary >= 1000
ORDER BY e.id;

-- Problem 6: Delete from Table
DELETE FROM employees AS e
WHERE department_id IN (1, 2);
SELECT * FROM employees AS e
ORDER BY e.id;
