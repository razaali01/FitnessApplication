package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutRecs extends AppCompatActivity implements View.OnClickListener {

    private Button Back;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_recs);

        Back = (Button) findViewById(R.id.BackWorkouts);
        Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case(R.id.BackWorkouts):
                startActivity(new Intent(this, HomePage.class));
                break;
        }
    }
}