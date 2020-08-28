-- INSERT INTO customers (first_name, last_name, email_address) VALUES
--     ('Tina', 'Belcher', 'bobsburgers@burgers.com'),
--     ('James', 'Bond', 'bond007@shakenNotStirred.com'),
--     ('Tommy', 'Pickles', 'itsTommy@rugratsrus.com'),
--     ('Richard', 'Bachman', 'whoAmI@kingfans.com');

-- INSERT INTO orders (created_date) VALUES
--     ('01/01/2021'),
--     ('02/01/2021');

-- INSERT INTO products (product_type, cost_per_sqft, labor_cost_per_sqft) VALUES
--     ('carpet', 2.25, 2.10),
--     ('laminate', 1.75, 2.10),
--     ('tile', 3.50, 4.15),
--     ('wood', 5.15, 4.75);
--
-- ALTER TABLE orders
-- ADD (
--     tax_rate DECIMAL NOT NULL,
--     product_type VARCHAR(70) NOT NULL,
--     area DOUBLE NOT NULL,
--     cost_per_sqft DECIMAL NOT NULL,
--     labor_cost_per_sqft DECIMAL NOT NULL,
--     material_cost DECIMAL NOT NULL,
--     labor_cost DECIMAL NOT NULL,
--     tax DECIMAL NOT NULL,
--     total DECIMAL NOT NULL
-- ) AFTER `customer_id`;
-- ALTER TABLE customers
-- ADD (orders INT NULLABLE )
-- AFTER 'email_address';

SELECT * FROM customers;
SELECT * FROM orders;
SELECT * FROM products;