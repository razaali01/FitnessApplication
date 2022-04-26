package com.example.fitnessapplication.StrengthTraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitnessapplication.R;

public class WorkoutStrengthGroup extends AppCompatActivity implements View.OnClickListener {

    private Button Chest, Back, Shoulder, Arms, Legs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_strength_group);

        Chest = (Button) findViewById(R.id.Chest);
        Chest.setOnClickListener(this);

        Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(this);

        Shoulder = (Button) findViewById(R.id.Shoulder);
        Shoulder.setOnClickListener(this);

        Arms = (Button) findViewById(R.id.Arms);
        Arms.setOnClickListener(this);

        Legs = (Button) findViewById(R.id.Legs);
        Legs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.Chest):
                startActivity(new Intent(this,MuscleGroupChest.class));
                break;
            case(R.id.Back):
                startActivity(new Intent(this,MuscleGroupBack.class));
                break;
            case(R.id.Shoulder):
                startActivity(new Intent(this,MuscleGroupShoulder.class));
                break;
            case(R.id.Arms):
                startActivity(new Intent(this,MuscleGroupArms.class));
                break;
            case(R.id.Legs):
                startActivity(new Intent(this,MuscleGroupLegs.class));
                break;
        }
    }
}