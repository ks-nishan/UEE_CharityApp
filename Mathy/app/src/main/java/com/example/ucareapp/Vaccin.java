package com.example.ucareapp;

public class Vaccin {
    String name,phone,email,address,school,qualification;
    public Vaccin(){}

    public Vaccin(String name, String phone, String email, String address, String school, String qualification) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.school = school;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getSchool() {
        return school;
    }

    public String getQualification() {
        return qualification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
