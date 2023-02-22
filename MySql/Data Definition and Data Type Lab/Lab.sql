CREATE DATABASE gamebar;

USE gamebar;

-- 1. CREATE TABLE--

CREATE TABLE employees (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL
);

CREATE TABLE categories (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE products (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`category_id` INT NOT NULL
);

-- 2. Insert data in tables-- 

INSERT INTO employees (`first_name` , `last_name`)
VALUES ('test1', 'test1'),
('test2', 'test2'),
('test3', 'test3');

-- 3. ALTER TABLE--

ALTER TABLE `employees`
ADD COLUMN `middle_name` VARCHAR(50);

-- 4. Adding Constraints--

ALTER TABLE `products`
ADD CONSTRAINT p_fk FOREIGN KEY (category_id)
REFERENCES categories(id);

-- 5. Modifying columns--

ALTER TABLE employees
MODIFY `middle_name` VARCHAR(100);
