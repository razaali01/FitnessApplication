package com.example.fitnessapplication;

public class User {

    public String fullName, age, email, password, gender, address;

    public User()
    {

    }

    public User(String fullName, String age, String email, String password, String gender, String address)
    {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
    }
}
