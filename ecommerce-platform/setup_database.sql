-- 1. Create the ecommerce_platform database
CREATE DATABASE ecommerce_platform;

-- 2. Connect to the ecommerce_platform database (This step is not needed in pgAdmin or other clients, 
-- as you can select the database before running the script)
-- If using psql, you can use `\c ecommerce_platform` to connect, but it's not needed here.

-- 3. Create users table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,  -- Storing hashed password
    role VARCHAR(20) NOT NULL,       -- 'buyer', 'seller', 'admin'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 4. Create products table
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    seller_id INT REFERENCES users(user_id) ON DELETE CASCADE,  -- Foreign key to users table
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 5. Insert sample users
-- Note: The password field contains hashed passwords using BCrypt
-- Example of a hashed password: '$2a$10$eWf3Z68pN.IhIKN4ZHxU6OHFmQI/ZW8p3X6F8a5I8/oH/2sLhKc7O'
INSERT INTO users (username, email, password, role)
VALUES
    ('john_doe', 'john.doe@example.com', '$2a$10$eWf3Z68pN.IhIKN4ZHxU6OHFmQI/ZW8p3X6F8a5I8/oH/2sLhKc7O', 'buyer'),
    ('jane_smith', 'jane.smith@example.com', '$2a$10$eWf3Z68pN.IhIKN4ZHxU6OHFmQI/ZW8p3X6F8a5I8/oH/2sLhKc7O', 'seller'),
    ('admin_user', 'admin@example.com', '$2a$10$eWf3Z68pN.IhIKN4ZHxU6OHFmQI/ZW8p3X6F8a5I8/oH/2sLhKc7O', 'admin');

-- 6. Insert sample products for the seller (seller_id should correspond to the seller user_id)
-- Note: The seller with username 'jane_smith' has user_id = 2
INSERT INTO products (name, description, price, quantity, seller_id)
VALUES
    ('Laptop', 'A high-end gaming laptop', 1500.00, 10, 2),
    ('Smartphone', 'A latest model smartphone', 800.00, 20, 2);

-- 7. Optional: Create indexes on frequently queried columns for performance improvement
-- Index on users' username (useful for login and searching users by username)
CREATE INDEX idx_users_username ON users(username);

-- Index on products' name (useful for searching products by name)
CREATE INDEX idx_products_name ON products(name);


