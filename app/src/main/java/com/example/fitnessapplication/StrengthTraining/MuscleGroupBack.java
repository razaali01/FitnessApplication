package com.example.fitnessapplication.StrengthTraining;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class MuscleGroupBack extends AppCompatActivity implements View.OnClickListener {

    TextView text;
    ArrayList<String> Workouts;
    private Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_back);
        final int random = new Random().nextInt(10-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();

        Workouts.add("Deadlift");
        Workouts.add("Bent-Over Row");
        Workouts.add("Pull-Ups");
        Workouts.add("T-Bar Row");
        Workouts.add("Seated Row");
        Workouts.add("Single-Arm Smith Machine Row");
        Workouts.add("Lat Pull-Down");
        Workouts.add("Single-Arm Dumbbell Row");
        Workouts.add("Dumbbell Pull-Over");
        Workouts.add("Chest-Supported Row");


        another = (Button) findViewById(R.id.AnotherBackWorkout);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.BackWorkoutBack);
        back.setOnClickListener(this);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.SelectedBackWorkout);
        text.setText(set);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.AnotherBackWorkout):
                int random2 = new Random().nextInt(10-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.BackWorkoutBack):
                startActivity(new Intent(this, WorkoutStrengthGroup.class));
                break;
        }
    }
}