package main.java.com.ecommerce.dao;

import com.ecommerce.model.Product;
import com.ecommerce.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Create a new product
    public static void createProduct(Product product) throws SQLException {
        String query = "INSERT INTO products (name, description, price, quantity, seller_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getSellerId());
            stmt.executeUpdate();
        }
    }

    // Read a product by its ID
    public static Product getProductById(int productId) throws SQLException {
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getInt("quantity"),
                    rs.getInt("seller_id"),
                    rs.getTimestamp("created_at").toLocalDateTime()
                );
            }
        }
        return null;  // Return null if no product found
    }

    // Update product details (e.g., price, quantity)
    public static void updateProduct(Product product) throws SQLException {
        String query = "UPDATE products SET name = ?, description = ?, price = ?, quantity = ? WHERE product_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setBigDecimal(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getProductId());
            stmt.executeUpdate();
        }
    }

    // Delete a product by product_id
    public static void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
        }
    }

    // Get all products for a specific seller (Seller functionality)
    public static List<Product> getProductsBySeller(int sellerId) throws SQLException {
        String query = "SELECT * FROM products WHERE seller_id = ?";
        List<Product> products = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sellerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getInt("quantity"),
                    rs.getInt("seller_id"),
                    rs.getTimestamp("created_at").toLocalDateTime()
                ));
            }
        }
        return products;
    }
}


