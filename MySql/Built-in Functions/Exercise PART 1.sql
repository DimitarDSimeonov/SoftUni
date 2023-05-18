-- 1. Find Names of All Employees by First Name

SELECT first_name, last_name FROM employees AS e
WHERE  e.first_name LIKE 'Sa%'
ORDER BY e.employee_id;

-- 2. Find Names of All Employees by Last Name

SELECT first_name, last_name FROM employees AS e
WHERE UPPER(e.last_name) LIKE '%EI%'
ORDER BY e.employee_id;

-- 3. Find First Names of All Employees

SELECT first_name FROM employees AS e
WHERE e.department_id IN (3, 10) AND e.hire_date BETWEEN '1995-01-01' AND '2005-12-31'
ORDER BY e.employee_id;

-- 4. Find All Employees Except Engineers

SELECT first_name, last_name FROM employees AS e
WHERE e.job_title NOT LIKE '%engineer%'
ORDER BY e.employee_id;

-- 5. Find Towns with Name Length 

SELECT name FROM towns AS t
WHERE CHAR_LENGTH(t.name) IN (5,6)
ORDER BY t.name;

-- 6. Find Towns Starting With

SELECT * FROM towns AS t
WHERE UPPER(t.name) LIKE 'M%' OR UPPER(t.name) LIKE 'K%' OR UPPER(t.name) LIKE 'B%' OR UPPER(t.name) LIKE 'E%'
ORDER BY t.name;

-- 7. Find Towns Not Starting With

SELECT * FROM towns AS t
WHERE UPPER(t.name) NOT LIKE 'R%' AND UPPER(t.name) NOT LIKE 'D%' AND UPPER(t.name) NOT LIKE 'B%'
ORDER BY t.name;

-- 8. Create View Employees Hired After 2000 Year

CREATE VIEW v_employees_hired_after_2000 AS
SELECT first_name, last_name FROM employees AS e
WHERE e.hire_date > '2001-01-01';
SELECT * FROM v_employees_hired_after_2000;

-- 9. Length of Last Name

SELECT first_name, last_name FROM employees AS e 
WHERE CHAR_LENGTH(e.last_name) = 5;
