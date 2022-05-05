package com.example.fitnessapplication.Cardio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessapplication.R;
import com.example.fitnessapplication.Yoga.WorkoutYogaGroup;

import java.util.ArrayList;
import java.util.Random;

public class CardioBeginner extends AppCompatActivity implements View.OnClickListener {

    TextView text, text1;
    ArrayList<String> Workouts;
    private Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_beginner);

        final int random = new Random().nextInt(5-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();

        Workouts.add("Jumping Jacks, Mountain Climbers, Jump Squat, High Knees, Burpees Repeat 2X");
        Workouts.add("Wall Sits, Planks, Jumping Jacks, Treadmill Sprint, Burpees Repeat 2X");
        Workouts.add("Front Kicks, Quick Feet, Situps, Box Jumps, Bike Sprint Repeat 2X");
        Workouts.add("Treadmill Sprint, StairMaster, Stationary Cycle, SitUps Repeat 2X");
        Workouts.add("Jumping Jacks, Treadmill Sprint, Situps, Wall sits, Mountain Climber Repeat 2X");


        another = (Button) findViewById(R.id.CardioBeginnerAnother);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.CardioBeginnerBack);
        back.setOnClickListener(this);

        String set1 = "20 sec per exercise - 40 sec rest";
        text1 = (TextView) findViewById(R.id.CardioBeginnerTiming);
        text1.setText(set1);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.CardioBeginnerSelection);
        text.setText(set);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.CardioBeginnerAnother):
                int random2 = new Random().nextInt(5-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.CardioBeginnerBack):
                startActivity(new Intent(this, WorkoutYogaGroup.class));
                break;
        }
    }
}