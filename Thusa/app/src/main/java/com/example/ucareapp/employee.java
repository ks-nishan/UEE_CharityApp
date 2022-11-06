package com.example.ucareapp;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class employee implements Serializable {
    @Exclude
            private String key;
            private String name;
            private String nic;
            private String age;
            private String address;
            private String mobile;
            private String date;
            private String time;
    public employee(){}
    public employee(String name, String nic, String age, String address, String mobile, String date, String time) {
       this.name = name;
        this.nic = nic;
        this.age = age;
        this.address = address;
        this.mobile = mobile;
        this.date = date;
        this.time = time;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
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
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }


}
