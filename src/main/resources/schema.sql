-- DROP TABLE IF EXISTS orders;
-- DROP TABLE IF EXISTS products;
-- DROP TABLE IF EXISTS customers;


CREATE TABLE IF NOT EXISTS customers (
   customer_id INT AUTO_INCREMENT PRIMARY KEY,
   first_name VARCHAR(75) NOT NULL,
   last_name VARCHAR(75) NOT NULL,
   email_address VARCHAR(75) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    created_date DATE NOT NULL,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    foreign key (customer_id) references customers(customer_id),
    foreign key (product_id) references products(product_id)
);

CREATE TABLE IF NOT EXISTS products (
  product_id INT AUTO_INCREMENT PRIMARY KEY,
  product_type VARCHAR(80) NOT NULL,
  cost_per_sqft DECIMAL NOT NULL,
  labor_cost_per_sqft DECIMAL NOT NULL
);