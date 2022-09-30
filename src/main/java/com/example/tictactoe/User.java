package com.example.tictactoe;

public class User {
    private String userName;
    private final static User INSTANCE = new User();

    private User() {
    }

    public static User getInstance() {
        return INSTANCE;
    }

    public void setUser(String u) {
        this.userName = u;
    }

    public String getUser() {
        return this.userName;
    }
}