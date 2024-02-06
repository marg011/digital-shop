-- liquibase formatted sql

-- changeset Karachevtsev:1
CREATE TABLE мониторы (
    id SERIAL PRIMARY KEY,
    серийный_номер BIGINT,
    производитель VARCHAR(255),
    цена INT,
    количество INT,
    диагональ INT
);

CREATE TABLE жесткие_диски (
    id SERIAL PRIMARY KEY,
    серийный_номер BIGINT,
    производитель VARCHAR(255),
    цена INT,
    количество INT,
    память INT
);