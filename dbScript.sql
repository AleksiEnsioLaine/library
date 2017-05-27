DROP DATABASE IF EXISTS library;
CREATE DATABASE library;

CREATE TABLE books (
book_id int				NOT NULL AUTO_INCREMENT,
title	varchar(255),
author  varchar(255),
genre	varchar(255),
pages	int,
PRIMARY KEY (book_id)
);

CREATE TABLE customers
(
customer_id int NOT NULL AUTO_INCREMENT,
firstname 	varchar(255),
lastname	varchar(255),
PRIMARY KEY (customer_id)
);

INSERT INTO books (title, author, genre, pages) VALUES ("The book", "Some Wise Guy", "Shitty", 666);

INSERT INTO customers (firstname, lastname) VALUES ("John", "Doe");