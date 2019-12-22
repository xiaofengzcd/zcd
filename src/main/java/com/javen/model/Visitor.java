package com.javen.model;

public class Visitor {
    private int id;
    private String username;
    private String password;



    public Visitor(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public Visitor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
