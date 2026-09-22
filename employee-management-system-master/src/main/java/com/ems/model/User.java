package com.ems.model;

public class User {

    private int userId;
    private String username;
    private int roleId;

    public User() {}

    public User(int userId, String username, int roleId) {
        this.userId = userId;
        this.username = username;
        this.roleId = roleId;
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public int getRoleId() { return roleId; }
}
