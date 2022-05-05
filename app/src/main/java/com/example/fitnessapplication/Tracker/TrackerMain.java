package com.example.fitnessapplication.Tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitnessapplication.HomePage;
import com.example.fitnessapplication.R;

public class TrackerMain extends AppCompatActivity implements View.OnClickListener{

    private Button WeightTracker, CalorieTracker, Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker_main);

        WeightTracker = findViewById(R.id.TrackerWeight);
        WeightTracker.setOnClickListener(this);

        CalorieTracker = findViewById(R.id.TrackerCalorie);
        CalorieTracker.setOnClickListener(this);

        Back = findViewById(R.id.TrackerBack);
        Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.TrackerWeight):
                startActivity(new Intent(this, WeightTrackerMain.class));
                break;
            case(R.id.TrackerCalorie):
                startActivity(new Intent(this, CalorieTrackerMain.class));
                break;
            case(R.id.TrackerBack):
                startActivity(new Intent(this, HomePage.class));
                break;
        }
    }
}