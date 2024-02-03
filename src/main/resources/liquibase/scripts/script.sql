-- liquibase formatted sql

-- changeset Karachevtsev:1
CREATE TABLE мониторы (
    id SERIAL PRIMARY KEY,
    серийный_номер INTEGER,
    производитель VARCHAR(255),
    цена DECIMAL(10, 2),
    количество INT,
    диагональ INT
);

CREATE TABLE жесткие_диски (
    id SERIAL PRIMARY KEY,
    серийный_номер INTEGER,
    производитель VARCHAR(255),
    цена DECIMAL(10, 2),
    количество INT,
    память INT
);