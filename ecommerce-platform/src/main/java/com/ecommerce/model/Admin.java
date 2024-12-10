package main.java.com.ecommerce.model;

public class Admin extends User {
    public Admin(int id, String username, String email, String password) {
        super(id, username, email, password, "admin");
    }

    @Override
    public void displayMenu() {
        System.out.println("1. View All Users");
        System.out.println("2. View All Products");
        System.out.println("3. Logout");
    }
}


