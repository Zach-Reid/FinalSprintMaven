package main.java.com.ecommerce.model;

public class Buyer extends User {
    public Buyer(int id, String username, String email, String password) {
        super(id, username, email, password, "buyer");
    }

    @Override
    public void displayMenu() {
        System.out.println("1. Browse Products");
        System.out.println("2. Search Products");
        System.out.println("3. Logout");
    }
}


