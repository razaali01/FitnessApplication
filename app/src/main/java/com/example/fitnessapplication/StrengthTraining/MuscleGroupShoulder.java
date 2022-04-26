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

public class MuscleGroupShoulder extends AppCompatActivity implements View.OnClickListener{

    TextView text;
    ArrayList<String> Workouts;
    Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group_shoulder);
        final int random = new Random().nextInt(10-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();

        Workouts.add("Pushups");
        Workouts.add("Inclined Bench Press");
        Workouts.add("Lateral Raise");
        Workouts.add("Overhead Press");
        Workouts.add("Standing Cable Pulley Fly");
        Workouts.add("Crab Walk");
        Workouts.add("Prone T");
        Workouts.add("Dumbell Shoulder Push Press");
        Workouts.add("Cabel Face Pulls");
        Workouts.add("Straight Arm Circles");

        another = (Button) findViewById(R.id.AnotherShoulderWorkout);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.ShoulderWorkoutBack);
        back.setOnClickListener(this);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.SelectedShoulderWorkout);
        text.setText(set);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.AnotherShoulderWorkout):
                int random2 = new Random().nextInt(10-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.ShoulderWorkoutBack):
                startActivity(new Intent(this, WorkoutStrengthGroup.class));
                break;
        }
    }
}