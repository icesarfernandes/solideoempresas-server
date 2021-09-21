package com.solideotech.solideoempresas.api.entity;

public class AuthRequest {

    private String username;
    private String password;

    public AuthRequest(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public AuthRequest() { }

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
