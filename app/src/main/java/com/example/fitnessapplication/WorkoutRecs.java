package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapplication.Cardio.WorkoutCardioGroups;
import com.example.fitnessapplication.StrengthTraining.WorkoutStrengthGroup;
import com.example.fitnessapplication.Yoga.WorkoutYogaGroup;

public class WorkoutRecs extends AppCompatActivity implements View.OnClickListener {

    private Button back, Strength, Yoga, Cardio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_recs);

        back = findViewById(R.id.BackWorkouts);
        back.setOnClickListener(this);

        Strength = findViewById(R.id.Weights);
        Strength.setOnClickListener(this);

        Yoga = findViewById(R.id.Yoga);
        Yoga.setOnClickListener(this);

        Cardio = findViewById(R.id.Cardio);
        Cardio.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case(R.id.BackWorkouts):
                startActivity(new Intent(this, HomePage.class));
                break;
            case(R.id.Weights):
                startActivity(new Intent(this, WorkoutStrengthGroup.class));
                break;
            case(R.id.Yoga):
                startActivity(new Intent(this, WorkoutYogaGroup.class));
                break;
            case(R.id.Cardio):
                startActivity(new Intent(this, WorkoutCardioGroups.class));
                break;
        }
    }

}