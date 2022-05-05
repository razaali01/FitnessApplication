package com.example.fitnessapplication.StrengthTraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.fitnessapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class MuscleGroupChest extends AppCompatActivity implements View.OnClickListener {

    TextView text;
    ArrayList<String> Workouts;
    Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_chest);

        final int random = new Random().nextInt(10-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();
        Workouts.add("Barbell Bench Press");
        Workouts.add("Dumbell Chest Press");
        Workouts.add("Flat Dumbbell Flyes");
        Workouts.add("Seated Chest Press Machine");
        Workouts.add("Pec Deck");
        Workouts.add("Inclined Barbell Bench Press");
        Workouts.add("Inclined Dumbell Chest Press");
        Workouts.add("Inclined Dumbell Flyes");
        Workouts.add("Cable Flyes");
        Workouts.add("Decline Barebell Bench Press");


        another = (Button) findViewById(R.id.AnotherChestWorkout);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.ChestWorkoutBack);
        back.setOnClickListener(this);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.SelectedChestWorkout);
        text.setText(set);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.AnotherChestWorkout):
                int random2 = new Random().nextInt(10-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.ChestWorkoutBack):
                startActivity(new Intent(this, WorkoutStrengthGroup.class));
                break;
        }
    }
}