-- 1. Managers 

SELECT employee_id, CONCAT(first_name, ' ', last_name) AS full_name, d.department_id, d.name AS department_name FROM employees AS e
JOIN departments AS d ON d.manager_id = e.employee_id
ORDER BY employee_id
LIMIT 5;

-- 2. Towns Addresses 

SELECT t.town_id, t.name AS town_name, address_text FROM towns AS t
JOIN addresses AS a ON a.town_id = t.town_id
WHERE t.name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id, a.address_id;

-- 3. Employees Without Managers

SELECT employee_id, first_name, last_name, department_id, salary FROM employees AS e
WHERE e.manager_id IS NULL;

-- 4. Higher Salary

SELECT COUNT(*) AS 'count' FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);