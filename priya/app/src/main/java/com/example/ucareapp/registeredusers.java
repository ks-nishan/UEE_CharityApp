package com.example.ucareapp;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class registeredusers implements Serializable {




    @Exclude
    private String key;
    private String name, age, address, phno, date;

    public registeredusers() {
    }

    public registeredusers(String name, String age, String address, String phno, String date) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phno = phno;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
