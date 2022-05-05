package com.example.fitnessapplication.Yoga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fitnessapplication.R;
import com.example.fitnessapplication.WorkoutRecs;

public class WorkoutYogaGroup extends AppCompatActivity implements View.OnClickListener {

    private Button beginner, intermediate, advanced, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_yoga_group);

        beginner = (Button) findViewById(R.id.YogaBeginner);
        beginner.setOnClickListener(this);

        intermediate = (Button) findViewById(R.id.YogaIntermediate);
        intermediate.setOnClickListener(this);

        advanced = (Button) findViewById(R.id.YogaAdvanced);
        advanced.setOnClickListener(this);

        back = (Button) findViewById(R.id.YogaBack);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.YogaBeginner):
                startActivity(new Intent(this,YogaBeginner.class));
                break;
            case(R.id.YogaIntermediate):
                startActivity(new Intent(this,YogaIntermediate.class));
                break;
            case(R.id.YogaAdvanced):
                startActivity(new Intent(this, YogaAdvanced.class));
                break;
            case(R.id.YogaBack):
                startActivity(new Intent(this, WorkoutRecs.class));
                break;
        }
    }
}