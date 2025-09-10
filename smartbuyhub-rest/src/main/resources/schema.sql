CREATE TABLE product (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    sku VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    category_id VARCHAR(100),
    brand VARCHAR(100),
    attributes TEXT,
    inventory_count INT,
    is_active BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

-- Users table
-- DROP TABLE IF EXISTS user_roles;
-- DROP TABLE IF EXISTS users;
-- DROP TABLE IF EXISTS roles;

-- CREATE TABLE roles (
--     id INT PRIMARY KEY,
--     name VARCHAR(20) NOT NULL
-- );

-- CREATE TABLE users (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(20) NOT NULL UNIQUE,
--     email VARCHAR(50) NOT NULL UNIQUE,
--     password VARCHAR(120) NOT NULL
-- );
--
-- CREATE TABLE user_roles (
--     user_id BIGINT NOT NULL,
--     role_id INT NOT NULL,
--     PRIMARY KEY (user_id, role_id),
--     FOREIGN KEY (user_id) REFERENCES users(id),
--     FOREIGN KEY (role_id) REFERENCES roles(id)
-- );
