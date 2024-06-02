package com.example.buyphonesonline.models;

import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;
    private int roleId;
    private Date creationDate;

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int roleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date creationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int userId() {
        return userId;
    }

    public User(int userId, String username, String email, String password, int roleId, Date creationDate) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.creationDate = creationDate;
    }

    public User(String username, String email, String password, int roleId, Date creationDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.creationDate = creationDate;
    }

    public User(String username, String email, String password, int roleId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
