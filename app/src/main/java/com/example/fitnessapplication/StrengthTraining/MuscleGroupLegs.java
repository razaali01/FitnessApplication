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

public class MuscleGroupLegs extends AppCompatActivity implements View.OnClickListener{

    TextView text;
    ArrayList<String> Workouts;
    Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_legs);
        final int random = new Random().nextInt(10-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();

        Workouts.add("Seated Calf Raise");
        Workouts.add("Goblet Squat");
        Workouts.add("Leg Press");
        Workouts.add("Lying Leg Curl");
        Workouts.add("Barbell Hip Thrust");
        Workouts.add("Walking Lunge");
        Workouts.add("Front Squat");
        Workouts.add("Glute Ham Raise (GHR)");
        Workouts.add("Deadlift");
        Workouts.add("Barbell Squat");

        another = (Button) findViewById(R.id.AnotherLegWorkout);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.LegWorkoutBack);
        back.setOnClickListener(this);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.SelectedLegWorkout);
        text.setText(set);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.AnotherLegWorkout):
                int random2 = new Random().nextInt(10-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.LegWorkoutBack):
                startActivity(new Intent(this, WorkoutStrengthGroup.class));
                break;
        }
    }
}