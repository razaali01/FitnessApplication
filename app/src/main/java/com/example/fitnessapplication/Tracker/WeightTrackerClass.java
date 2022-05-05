package com.example.fitnessapplication.Tracker;

public class WeightTrackerClass {
    String date, weight;

    public WeightTrackerClass(){

    }

    public WeightTrackerClass(String date, String weight){
        this.date = date;
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
