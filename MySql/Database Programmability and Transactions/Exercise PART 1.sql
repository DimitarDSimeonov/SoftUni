-- 1. Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
	SELECT first_name, last_name FROM employees AS e
WHERE e.salary > 35000
ORDER BY first_name, last_name, e.employee_id;
END$$

-- 2. Employees with Salary Above Number

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(target_salary DECIMAL(10,4))
BEGIN
	SELECT first_name, last_name FROM employees AS e
WHERE e.salary >= target_salary
ORDER BY first_name, last_name, e.employee_id;
END$$

-- 3. Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with (starting_str VARCHAR (10))
BEGIN
	SELECT `name` AS town_name FROM towns
	WHERE `name` LIKE CONCAT(starting_str, '%')
	ORDER BY town_name;
END$$

-- 4. Employees from Town

DELIMITER $$ 
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT first_name, last_name FROM employees AS e
	JOIN addresses AS a ON e.address_id = a.address_id
	JOIN towns AS t ON a.town_id = t.town_id
	WHERE t.name = town_name
	ORDER BY e.first_name, e.last_name, e.employee_id;
END$$

-- 5. Salary Level Function

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(10,4))
RETURNS VARCHAR(50)
DETERMINISTIC
	BEGIN
		DECLARE salary_level VARCHAR(50); 
		CASE
		WHEN salary < 30000 THEN SET salary_level = 'Low';
		WHEN salary <= 50000 THEN SET salary_level = 'Average';
		ELSE SET salary_level = 'High';
		END CASE;
	RETURN salary_level;
    END$$

-- 6. Employees by Salary Level

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
	SELECT first_name, last_name FROM employees AS e
    WHERE salary_level = 'Low' AND e.salary < 30000
    OR salary_level = 'Average' AND e.salary BETWEEN 30000 AND 50000
    OR salary_level = 'High' AND e.salary > 50000
    ORDER BY first_name DESC, last_name DESC;
END$$

-- 7. Define Function

CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
RETURN word REGEXP (CONCAT('^[', set_of_letters, ']+$'));