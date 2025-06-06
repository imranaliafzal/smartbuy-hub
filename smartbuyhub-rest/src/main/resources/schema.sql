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
