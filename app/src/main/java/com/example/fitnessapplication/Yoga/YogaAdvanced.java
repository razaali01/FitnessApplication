package com.example.fitnessapplication.Yoga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessapplication.R;

import java.util.ArrayList;
import java.util.Random;


public class YogaAdvanced extends AppCompatActivity implements View.OnClickListener{

    TextView text;
    ArrayList<String> Workouts;
    private Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_advanced);

        final int random = new Random().nextInt(2-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();

        Workouts.add("Warrior 1, Triangle, Downward Dog, Baby Cobra, Chair Pose, Fire Log Pose, Pigeon Pose, Noose Pose, Mountain Pose, Monkey Pose");
        Workouts.add("Childs Pose, Extended Side Angle, Warrior 2, Urdhva Hastasana, Locust Pose, Hero Pose, Half Frog Pose, Gate Pose, Firefly Pose, Fish Pose");

        another = (Button) findViewById(R.id.YogaAdvancedAnother);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.YogaAdvancedBack);
        back.setOnClickListener(this);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.YogaAdvancedSelection);
        text.setText(set);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.YogaAdvancedAnother):
                int random2 = new Random().nextInt(2-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.YogaAdvancedBack):
                startActivity(new Intent(this, WorkoutYogaGroup.class));
                break;
        }
    }
}