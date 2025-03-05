package com.proj.model;

public class Customer {
    private final String email;
    private final String password;

    public Customer(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
