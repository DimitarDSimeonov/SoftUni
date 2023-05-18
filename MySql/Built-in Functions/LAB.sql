-- 1. Find Book Titles

SELECT title FROM books AS b
WHERE SUBSTRING(b.title, 1, 3) = 'The'
ORDER BY b.id;

-- 2. Replace Titles

SELECT REPLACE(b.title, 'The', '***') AS title FROM books AS b
WHERE SUBSTRING(b.title, 1, 3) = 'The'
ORDER BY b.id;

-- 3. Sum Cost of All Books

SELECT ROUND(SUM(cost), 2) FROM books;

-- 4. Days Lived

SELECT CONCAT(first_name, ' ', last_name) AS 'Full Name', TIMESTAMPDIFF(DAY, born, died) AS 'Days Lived' FROM authors;

-- 5. Harry Potter Books

SELECT title FROM books AS b
WHERE b.title LIKE 'Harry Potte%';