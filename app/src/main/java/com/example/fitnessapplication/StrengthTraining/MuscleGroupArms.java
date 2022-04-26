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

public class MuscleGroupArms extends AppCompatActivity implements View.OnClickListener{

    TextView text;
    ArrayList<String> Workouts;
    Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_arms);
        final int random = new Random().nextInt(10-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();

        Workouts.add("EZ Bar Curl");
        Workouts.add("Concentartion Curls");
        Workouts.add("Hammer Curls");
        Workouts.add("Bicep Cabel Curl");
        Workouts.add("Chin-up");
        Workouts.add("Dumbell Skull Crusher");
        Workouts.add("JM Press");
        Workouts.add("Tricep Pushdown");
        Workouts.add("Tricep Kickback");
        Workouts.add("Dips");

        another = (Button) findViewById(R.id.AnotherArmWorkout);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.ArmsWorkoutBack);
        back.setOnClickListener(this);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.SelectedArmWorkout);
        text.setText(set);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.AnotherArmWorkout):
                int random2 = new Random().nextInt(10-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.ArmsWorkoutBack):
                startActivity(new Intent(this, WorkoutStrengthGroup.class));
                break;
        }
    }
}