INSERT INTO product (
    name, description, sku, price, category_id, brand,
    attributes, inventory_count, is_active,
    created_at, updated_at, created_by, updated_by
) VALUES
('Red Shirt', 'Cotton red shirt', 'SKU-RED-001', 29.99, 'CAT001', 'BrandX',
 '{"size":"M","color":"Red"}', 50, true,
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),

('Blue Jeans', 'Denim jeans', 'SKU-BLUE-002', 49.99, 'CAT002', 'BrandY',
 '{"size":"32","color":"Blue"}', 100, true,
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin'),

('Sneakers', 'Running sneakers', 'SKU-SNK-003', 69.99, 'CAT003', 'BrandZ',
 '{"size":"9","color":"White"}', 25, true,
 CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'admin', 'admin');
