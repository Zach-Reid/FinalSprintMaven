package main.java.com.ecommerce.model;

public abstract class User {
    protected int id;
    protected String username;
    protected String email;
    protected String password;
    protected String role;

    // Constructor
    public User(int id, String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Abstract method to display different menus for different roles
    public abstract void displayMenu();

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}


