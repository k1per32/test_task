-- liquibase formatted sql
-- changeset k1per32:1
CREATE SCHEMA if not exists test_task_schema;

CREATE TABLE if not exists test_task_schema.clients
(
    client_id serial PRIMARY KEY,
    name      VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists test_task_schema.phone_number
(
    phone_number_id serial,
    client_id       serial,
    phone_number    VARCHAR(50),

    PRIMARY KEY (phone_number_id),
    FOREIGN KEY (client_id) REFERENCES test_task_schema.clients (client_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE if not exists test_task_schema.email_address
(
    email_address_id serial PRIMARY KEY,
    client_id        serial,
    email_address    VARCHAR(255),
    FOREIGN KEY (client_id) REFERENCES test_task_schema.clients (client_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
