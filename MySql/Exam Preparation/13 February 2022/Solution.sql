CREATE DATABASE online_store;
USE online_store;
DROP DATABASE online_store;

-- SECTION 1

CREATE TABLE brands (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE reviews (
id INT PRIMARY KEY AUTO_INCREMENT,
content TEXT,
rating DECIMAL(10,2) NOT NULL,
picture_url VARCHAR(80) NOT NULL,
published_at DATETIME NOT NULL
);

CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
price DECIMAL(19,2) NOT NULL,
quantity_in_stock INT,
`description` TEXT,
brand_id INT NOT NULL,
category_id INT NOT NULL,
review_id INT,
CONSTRAINT fk_products_brands
FOREIGN KEY (brand_id)
REFERENCES brands(id),
CONSTRAINT fk_products_categories
FOREIGN KEY (category_id)
REFERENCES categories (id),
CONSTRAINT fk_products_reviews
FOREIGN KEY (review_id)
REFERENCES reviews (id)
);

CREATE TABLE customers (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone VARCHAR(30) NOT NULL UNIQUE,
address VARCHAR(60) NOT NULL,
discount_card BIT(1) NOT NULL DEFAULT 0
);

CREATE TABLE orders(
id INT PRIMARY KEY AUTO_INCREMENT,
order_datetime DATETIME NOT NULL,
customer_id INT NOT NULL,
CONSTRAINT fk_orders_customers
FOREIGN KEY (customer_id)
REFERENCES customers(id)
);

CREATE TABLE orders_products (
order_id INT,
product_id INT,
CONSTRAINT fk_op_orders
FOREIGN KEY (order_id)
REFERENCES orders(id),
CONSTRAINT fk_op_products
FOREIGN KEY (product_id)
REFERENCES products (id)
);

-- SECTION 2
-- 02.Insert

INSERT INTO reviews (content, picture_url, published_at, rating)
SELECT SUBSTR(p.description, 1, 15), REVERSE(p.`name`), '2010-10-10', p.price/8 FROM products AS p
WHERE p.id >= 5;

-- 03. Update

UPDATE products 
SET quantity_in_stock = quantity_in_stock - 5
WHERE quantity_in_stock BETWEEN 60 AND 70;

-- 04. Delete

DELETE c FROM customers AS c
LEFT JOIN orders AS o ON c.id = o.customer_id
WHERE o.customer_id IS NULL;

-- SECTION 3
-- 05.Categories

SELECT * FROM categories
ORDER BY `name` DESC;

-- 06.Quantity

SELECT id, brand_id, `name`, quantity_in_stock FROM products
WHERE price > 1000 AND quantity_in_stock < 30
ORDER BY quantity_in_stock, id;

-- 07. Review

SELECT id, content, rating, picture_url, published_at FROM reviews
WHERE content LIKE 'MY%' AND CHAR_LENGTH(content) > 61
ORDER BY rating DESC;

-- 08.First customers

SELECT CONCAT(first_name, ' ', last_name) AS full_name, address, order_datetime AS order_date FROM customers AS c
JOIN orders AS o ON o.customer_id = c.id
WHERE YEAR(order_datetime) <= 2018
ORDER BY full_name DESC;

-- 09.Best categories

SELECT COUNT(p.category_id) AS items_count, c.`name`, SUM(p.quantity_in_stock) AS total_quantity FROM products AS p
JOIN categories AS c ON c.id = p.category_id
GROUP BY p.category_id
ORDER BY items_count DESC, total_quantity
LIMIT 5;

-- SECTION 4
-- 10.Extract client cards count

CREATE FUNCTION  udf_customer_products_count(name VARCHAR(30)) 
RETURNS INT 
	RETURN (SELECT COUNT(op.product_id) FROM customers AS c
			JOIN orders AS o ON o.customer_id = c.id
            JOIN orders_products AS op ON op.order_id = o.id
            WHERE c.first_name = name);

-- 11.Reduce price

CREATE PROCEDURE udp_reduce_price (category_name VARCHAR(50))
UPDATE products AS p
SET price = price * 0.7
WHERE (SELECT rating FROM reviews AS r WHERE p.review_id = r.id) < 4 
AND (SELECT c.name FROM categories AS c WHERE p.category_id = c.id) = category_name;
	