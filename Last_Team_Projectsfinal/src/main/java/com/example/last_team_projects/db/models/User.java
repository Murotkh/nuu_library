package com.example.last_team_projects.db.models;

import java.util.Formatter;

public class User {
    public int id;
    public String name;
    public String username;
    public String phone;
    public String password;

    public User(int id, String name, String username, String phone, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.password = password;
    }
}
