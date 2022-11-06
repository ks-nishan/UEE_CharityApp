package com.example.ucareapp;

public class RUsers {
    String name,email,pass,copass;

    public RUsers(String name, String email) {
    }

    public RUsers(String name, String email, String pass, String copass) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.copass = copass;
    }
}
