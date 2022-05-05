package com.example.fitnessapplication.Tracker;

public class CalorieTrackerClass {

    String date, calories;

    public CalorieTrackerClass(){

    }

    public CalorieTrackerClass(String date, String calories){
        this.date = date;
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
