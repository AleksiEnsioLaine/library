CREATE DATABASE library;


CREATE TABLE library.books
(
  book_id             int            NOT NULL AUTO_INCREMENT,
  title               varchar(100)   NOT NULL,
  author              varchar(40)    NOT NULL,
  genre               varchar(40)    NOT NULL,
  price               DECIMAL(6,2)   NOT NULL,
  PRIMARY KEY         (book_id)
);