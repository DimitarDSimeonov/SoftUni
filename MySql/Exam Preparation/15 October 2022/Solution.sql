CREATE DATABASE resturant_db;
USE resturant_db;
DROP DATABASE resturant_db;

-- SECTION 1 
-- 01. Table design

CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL UNIQUE,
`type` VARCHAR(30) NOT NULL,
price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE clients (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
birthdate DATE NOT NULL,
card VARCHAR(50),
review TEXT
);

CREATE TABLE tables(
id INT PRIMARY KEY AUTO_INCREMENT,
floor INT NOT NULL,
reserved TINYINT(1),
capacity INT NOT NULL
);

CREATE TABLE waiters(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NUll,
email VARCHAR(50) NOT NULL,
phone VARCHAR(50),
salary DECIMAL(10, 2)
);

CREATE TABLE orders (
id INT PRIMARY KEY AUTO_INCREMENT,
table_id INT NOT NULL,
waiter_id INT NOT NULL,
order_time TIME NOT NULL,
payed_status TINYINT(1),
CONSTRAINT fk_orders_tables
FOREIGN KEY (table_id)
REFERENCES tables(id),
CONSTRAINT fk_orders_waiters
FOREIGN KEY (waiter_id)
REFERENCES waiters(id)
);

CREATE TABLE orders_clients (
order_id INT,
client_id INT,
CONSTRAINT fk_oc_orders
FOREIGN KEY (order_id)
REFERENCES orders(id),
CONSTRAINT fk_oc_clients
FOREIGN KEY (client_id)
REFERENCES clients(id)
);

CREATE TABLE orders_products (
order_id INT,
product_id INT,
CONSTRAINT fk_op_orders
FOREIGN KEY (order_id)
REFERENCES orders(id),
CONSTRAINT fk_op_products
FOREIGN KEY (product_id)
REFERENCES products(id)
);

-- SECTION 2
-- 02.Insert

INSERT INTO products (name, type, price)
SELECT CONCAT(w.last_name,' ', 'specialty'),
		'Cocktail',
        CEIL(w.salary * 0.01) FROM waiters AS w
        WHERE w.id > 6;
        
-- 03.Update

UPDATE orders
SET table_id = table_id - 1
WHERE id BETWEEN 12 AND 23;

-- 04.Delete

DELETE w FROM waiters AS w
LEFT JOIN orders AS o ON o.waiter_id = w.id
WHERE o.waiter_id IS NULL;

-- SECTION 3
-- 05.Clients

SELECT * FROM clients
ORDER BY birthdate DESC, id DESC;

-- 06. Birthdate

SELECT first_name, last_name, birthdate, review FROM clients AS c
WHERE c.card IS NULL AND YEAR(birthdate) BETWEEN 1978 AND 1993
ORDER BY c.last_name DESC, id
LIMIT 5;

-- 07. Accounts

SELECT CONCAT(last_name, first_name, CHAR_LENGTH(first_name), 'Restaurant') AS username,
		REVERSE(SUBSTR(email, 2, 12)) AS 'password' FROM waiters AS w
WHERE w.salary IS NOT NULL
ORDER BY `password` DESC;

-- 08. Top of menu

SELECT id, name, COUNT(op.product_id) AS count FROM products AS p
JOIN orders_products AS op ON op.product_id = p.id
GROUP BY p.id
HAVING count >= 5
ORDER BY count DESC, p.name;

-- 09. Aviability

SELECT t.id, t.capacity, COUNT(oc.client_id) AS count_clients, IF(
	t.capacity > COUNT(oc.client_id), 'Free seats', 
    IF(t.capacity = COUNT(oc.client_id), 'Full', 'Extra seats')) AS availability FROM orders_clients AS oc
JOIN orders AS o ON o.id = oc.order_id
JOIN tables AS t ON t.id = o.table_id
WHERE t.floor = 1
GROUP BY t.id
ORDER BY t.id DESC;

-- SECTION 4
-- 10. Extract bill

CREATE FUNCTION udf_client_bill(full_name VARCHAR(50)) 
RETURNS DECIMAL(10, 2)
	RETURN (SELECT SUM(p.price) FROM products AS p
			JOIN orders_products AS op ON op.product_id = p.id
			JOIN orders AS o ON o.id = op.order_id
			JOIN orders_clients AS oc ON oc.order_id = o.id
			JOIN clients AS c ON c.id = oc.client_id
			WHERE c.first_name = SUBSTR(full_name, 1, LOCATE(' ', full_name) - 1) 
            AND c.last_name = SUBSTR(full_name,  LOCATE(' ', full_name) + 1));

-- 11.Happy hour

CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))
	UPDATE products AS p
    SET p.price = p.price * 0.8
    WHERE p.price >= 10 AND p.type = type;