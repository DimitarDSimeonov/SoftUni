-- 1. Employee Address

SELECT employee_id, job_title, e.address_id, address_text FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
ORDER BY e.address_id
LIMIT 5;

-- 2. Addresses with Towns

SELECT first_name, last_name, t.name AS 'town', address_text FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
JOIN towns AS t ON a.town_id = t.town_id
ORDER BY first_name, last_name;

-- 3. Sales Employee

SELECT employee_id, first_name, last_name, d.name AS department_name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;

-- 4. Employee Departments

SELECT employee_id, first_name, salary, d.name AS department_name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC;

-- 5. Employees Without Project

SELECT e.employee_id, first_name FROM employees AS e
LEFT JOIN employees_projects AS ep ON ep.employee_id = e.employee_id
WHERE ep.employee_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

-- 6. Employees Hired After

SELECT first_name, last_name, hire_date, d.name AS dept_name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE e.hire_date > '1999-01-01' AND d.name IN ('Sales', 'Finance')
ORDER BY e.hire_date;

-- 7. Employees with Project

SELECT e.employee_id, first_name, p.name AS 'project_name' FROM employees AS e
JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
JOIN projects AS p ON ep.project_id = p.project_id 
WHERE p.end_date IS NULL AND p.start_date > '2002-08-13'
ORDER BY first_name, p.name
LIMIT 5;

-- 8. Employee 24

SELECT e.employee_id, first_name, IF(p.start_date >= '2005-01-01', NULL, p.name) AS 'project_name' FROM employees AS e
JOIN employees_projects AS ep 
JOIN projects AS p ON ep.project_id = p.project_id AND e.employee_id = ep.employee_id
WHERE e.employee_id = 24
ORDER BY `project_name`;

-- 9. Employee Manager

SELECT e.employee_id, e.first_name, e.manager_id, e2.first_name AS manager_name FROM employees AS e
JOIN employees AS e2 ON e.manager_id = e2.employee_id
WHERE e.manager_id IN (3,7)
ORDER BY e.first_name;

-- 10. Employee Summary

SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS employee_name, CONCAT(e2.first_name, ' ', e2.last_name) AS manager_name, d.name AS department_name FROM employees AS e
JOIN employees AS e2 ON e.manager_id = e2.employee_id
JOIN departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;

-- 11. Min Average Salary

SELECT AVG(salary) AS 'min_average_salary' FROM employees
GROUP BY department_id
ORDER BY `min_average_salary`
LIMIT 1;
