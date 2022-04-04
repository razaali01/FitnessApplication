package com.example.fitnessapplication;

import java.util.ArrayList;
import java.util.List;

public class User {


    private List<String> toDoList;
    private String fullName, age, email;
    private String gender, address;



    public User() {
    }



    public User(String fullName, String age, String email)
    {
        this.fullName = fullName;
        this.age = age;
        this.email = email;

        gender = "";
        address = "";

        toDoList = new ArrayList<>();
    }

    public  List<String> getToDoList() {
        return toDoList;
    }

    public  void setToDoList(List<String> ToDoList) {
        toDoList = ToDoList;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
