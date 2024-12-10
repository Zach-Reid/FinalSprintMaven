package main.java.com.ecommerce.model;

public class Seller extends User {
    public Seller(int id, String username, String email, String password) {
        super(id, username, email, password, "seller");
    }

    @Override
    public void displayMenu() {
        System.out.println("1. List Products");
        System.out.println("2. Add Product");
        System.out.println("3. Edit Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Logout");
    }
}


