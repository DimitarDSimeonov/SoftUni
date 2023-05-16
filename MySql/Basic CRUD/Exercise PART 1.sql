-- 1. Find All Information About Departments

SELECT * FROM departments AS d
ORDER BY d.department_id;

-- 2. Find all Department Names

SELECT `name` FROM departments;

-- 3. Find salary of Each Employee

SELECT first_name, last_name, salary FROM employees AS e
ORDER BY e.employee_id;

-- 4. Find Full Name of Each Employee

SELECT first_name, middle_name, last_name FROM employees AS e
ORDER BY e.employee_id;

-- 5. Find Email Address of Each Employee

 SELECT CONCAT(e.first_name, '.', e.last_name, '@softuni.bg') AS full_email_address FROM employees AS e;
 
 -- 6. Find All Different Employee's Salaries
 
 SELECT DISTINCT salary FROM employees;
 
 -- 7. Find all Information About Employees
 
 SELECT * FROM employees AS e
 WHERE e.job_title = 'Sales Representative'
 ORDER BY e.employee_id;
 
 -- 8. Find Names of All Employees by salary in Range
 
 SELECT first_name, last_name, job_title FROM employees AS e
 WHERE e.salary BETWEEN 20000 AND 30000
 ORDER BY e.employee_id;
 
 -- 9. Find Names of All Employees
 
 SELECT concat_ws(' ', first_name, middle_name, last_name) AS 'Full Name' FROM employees AS e
 WHERE salary = 25000 OR salary = 14000 OR salary = 12500 OR salary = 23600;
 
 -- 10. Find All Employees Without Manager
 
 SELECT first_name, last_name FROM employees AS e
 WHERE e.manager_id IS NULL;
 
 -- 11. Find All Employees with salary More Than 50000
 
 SELECT first_name, last_name, salary FROM employees AS e
 WHERE e.salary > 50000
 ORDER BY e.salary DESC;
 
 -- 12. Find 5 Best Paid Employees

SELECT first_name, last_name FROM employees AS e
ORDER BY e.salary DESC
LIMIT 5;

-- 13. Find All Employees Except Marketing

SELECT first_name, last_name FROM employees AS e
WHERE e.department_id != 4;

-- 14. Sort Employees Table

SELECT * FROM employees AS e
ORDER BY e.salary DESC,
e.first_name ASC,
e.last_name DESC,
e.middle_name ASC;

-- 15. Create View Employees with Salaries

CREATE VIEW v_employees_salaries AS
	SELECT first_name, last_name, salary FROM employees;
SELECT * FROM v_employees_salaries;
    
-- 16. Create View Employees with Job Titles

CREATE VIEW v_employees_job_titles AS
	SELECT CONCAT_WS(' ', first_name, middle_name, last_name) AS full_name, job_title FROM employees AS e;
SELECT * FROM v_employees_job_titles;

-- 17. Distinct Job Titles

SELECT DISTINCT job_title FROM employees AS e
ORDER BY e.job_title ASC;

-- 18. Find First 10 Started Projects

SELECT * FROM projects AS p
ORDER BY p.start_date,
p.name,
p.project_id
LIMIT 10;

-- 19. Last 7 Hired Employees

SELECT first_name, last_name, hire_date FROM employees AS e
ORDER BY e.hire_date DESC
LIMIT 7;

-- 20. Increase Salaries

SELECT * FROM departments;-- 1,2,4,11

UPDATE  employees
SET `salary` = `salary` * 1.12
WHERE department_id = 1 OR department_id = 2 OR department_id = 4 OR department_id = 11;
SELECT salary FROM employees;

