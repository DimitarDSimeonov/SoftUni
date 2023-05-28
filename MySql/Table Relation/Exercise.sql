-- 1. One-To-One Relationship

CREATE TABLE passports(
passport_id INT PRIMARY KEY,
passport_number VARCHAR(10) UNIQUE
);

CREATE TABLE people(
person_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(20),
salary DECIMAL(10,2),
passport_id INT NOT NULL,
CONSTRAINT fk_people_passport_id__passports_passport_id
FOREIGN KEY(passport_id)
REFERENCES passports(passport_id)
);

INSERT INTO passports(passport_id, passport_number)
VALUES (101, 'N34FG21B'),
	(102, 'K65LO4R7'),
    (103, 'ZE657QP2');
    
INSERT INTO people (person_id, first_name, salary, passport_id)
VALUES (1, 'Roberto', 43300.00, 102),
		(2, 'Tom', 56100.00, 103),
        (3, 'Yana', 60200.00, 101);
        
-- 2. One-To-Many Relationship

CREATE TABLE manufacturers(
manufacturer_id INT PRIMARY KEY,
`name` VARCHAR(30),
established_on DATE
);

CREATE TABLE models(
model_id INT PRIMARY KEY,
`name` VARCHAR(30),
manufacturer_id INT,
CONSTRAINT fk_models_manufacturer_id__manufacturers_manufacturer_id
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id)
);

INSERT INTO manufacturers(manufacturer_id, name, established_on)
VALUES(1, 'BMW', '1916-03-01'),
	(2, 'Tesla', '2003-01-01'),
    (3, 'Lada', '1966-05-01');
    
INSERT INTO models(model_id, name, manufacturer_id)
VALUES (101, 'X1', 1),
		(102, 'i6', 1),
        (103, 'Model S', 2),
        (104, 'Model X', 2),
        (105, 'Model 3', 2),
        (106, 'Nova', 3);
        
-- 3. Many-To-Many Relationship

CREATE TABLE students(
student_id INT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

INSERT INTO students(student_id, name)
VALUES (1, 'Mila'),
		(2, 'Toni'),
        (3, 'Ron');
        
CREATE TABLE exams(
exam_id INT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

INSERT INTO exams(exam_id, name)
VALUES(101, 'Spring MVC'),
		(102, 'Neo4j'),
        (103, 'Oracle 11g');

CREATE TABLE students_exams(
student_id INT,
exam_id INT,
CONSTRAINT PRIMARY KEY (student_id, exam_id),
CONSTRAINT fk_student_id__students_student_id
FOREIGN KEY (student_id)
REFERENCES students(student_id),
CONSTRAINT fk_exam_id__exams_exam_id
FOREIGN KEY (exam_id)
REFERENCES exams(exam_id)
);

INSERT INTO students_exams(student_id, exam_id)
VALUES (1, 101),
		(1,102),
        (2,101),
        (3,103),
        (2,102),
        (2,103);
        
-- 4. Self-Referencing

CREATE TABLE teachers (
teacher_id INT PRIMARY KEY,
`name` VARCHAR(20),
manager_id INT
);

INSERT INTO teachers(teacher_id, name, manager_id)
VALUES (101, 'John', null),
		(102, 'Maya', 106),
        (103, 'Silvia', 106),
        (104, 'Ted', 105),
        (105, 'Mark', 101),
        (106, 'Greta', 101);
        
ALTER TABLE teachers
ADD CONSTRAINT fk_manger_id_teacher_id
FOREIGN KEY (manager_id)
REFERENCES teachers(teacher_id);

-- 5.Online Store Database

CREATE DATABASE online_store;
USE online_store;

CREATE TABLE item_types(
item_type_id INT(11) PRIMARY KEY,
`name` VARCHAR(50)
);

CREATE TABLE items (
item_id INT(11) PRIMARY KEY,
`name` VARCHAR(50),
item_type_id INT(11),
CONSTRAINT fk_item_type_id__item_types_item_type_id
FOREIGN KEY (item_type_id)
REFERENCES item_types(item_type_id)
);

CREATE TABLE cities(
city_id INT(11) PRIMARY KEY,
`name` VARCHAR(50)
);

CREATE TABLE customers(
customer_id INT(11) PRIMARY KEY,
`name` VARCHAR(50),
birthday DATE,
city_id INT(11),
CONSTRAINT fk_city_id__cities_city_id
FOREIGN KEY (city_id)
REFERENCES cities(city_id)
);

CREATE TABLE orders(
order_id INT(11) PRIMARY KEY,
customer_id INT(11),
CONSTRAINT fk_customer_id__customers_customer_id
FOREIGN KEY (customer_id)
REFERENCES customers(customer_id)
);

CREATE TABLE order_items(
order_id INT,
item_id INT,
CONSTRAINT PRIMARY KEY (order_id, item_id),
CONSTRAINT fk_order_id__orders_order_id
FOREIGN KEY (order_id)
REFERENCES orders(order_id),
CONSTRAINT fk_item_id__items_item_id
FOREIGN KEY (item_id)
REFERENCES items(item_id)
);

-- 6. University Database

CREATE DATABASE university;
USE university;

CREATE TABLE subjects(
subject_id INT AUTO_INCREMENT PRIMARY KEY,
subject_name VARCHAR(50)
);

CREATE TABLE majors(
major_id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50)
);

CREATE TABLE students(
student_id INT AUTO_INCREMENT PRIMARY KEY,
student_number VARCHAR(12),
student_name VARCHAR(50),
major_id INT,
CONSTRAINT fk_mojor_id__majors_major_id
FOREIGN KEY (major_id)
REFERENCES majors(major_id)
);

CREATE TABLE payments(
payment_id INT AUTO_INCREMENT PRIMARY KEY,
payment_date DATE,
payment_amount DECIMAL(8, 2),
student_id INT,
CONSTRAINT fk_student_id__students_student_id
FOREIGN KEY (student_id)
REFERENCES students(student_id)
);

CREATE TABLE agenda(
student_id INT,
subject_id INT,
CONSTRAINT PRIMARY KEY (student_id, subject_id),
CONSTRAINT fk_agenda_student_id__students_student_id
FOREIGN KEY (student_id)
REFERENCES students(student_id),
CONSTRAINT fk_subject_id__subjects_subject_id
FOREIGN KEY (subject_id)
REFERENCES subjects(subject_id)
);

-- 9. Peaks in Rila

SELECT mountain_range, peak_name, elevation FROM mountains AS m
JOIN peaks AS p ON p.mountain_id = m.id
WHERE mountain_range = 'Rila'
ORDER BY p.elevation DESC;