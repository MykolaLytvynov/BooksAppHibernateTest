CREATE DATABASE bookshibernatetest;

CREATE TABLE author
(
    id        SERIAL PRIMARY KEY,
    name      CHARACTER(10) NOT NULL,
    last_name CHARACTER(15) NOT NULL
);

CREATE TABLE books
(
    id        SERIAL PRIMARY KEY,
    name      CHARACTER(15) NOT NULL,
    author_id INTEGER       NOT NULL,
    FOREIGN KEY (author_id) REFERENCES author (id)
);

CREATE TABLE book_store
(
    id      SERIAL PRIMARY KEY,
    name    CHARACTER(15) NOT NULL,
    address CHARACTER(15) NOT NULL
);


CREATE TABLE bookseller
(
    id    SERIAL PRIMARY KEY,
    name  CHARACTER(15) NOT NULL,
    store INTEGER       NOT NULL,
    FOREIGN KEY (store) REFERENCES book_store (id)
);

