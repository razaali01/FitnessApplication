package com.example.fitnessapplication.Cardio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessapplication.R;
import com.example.fitnessapplication.WorkoutRecs;
import com.example.fitnessapplication.Yoga.WorkoutYogaGroup;
import com.example.fitnessapplication.Yoga.YogaAdvanced;
import com.example.fitnessapplication.Yoga.YogaBeginner;
import com.example.fitnessapplication.Yoga.YogaIntermediate;

import java.util.ArrayList;

public class WorkoutCardioGroups extends AppCompatActivity implements View.OnClickListener{

    private Button beginner, intermediate, advanced, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_cardio_groups);

        beginner = (Button) findViewById(R.id.CardioBeginner);
        beginner.setOnClickListener(this);

        intermediate = (Button) findViewById(R.id.CardioIntermedidate);
        intermediate.setOnClickListener(this);

        advanced = (Button) findViewById(R.id.CardioAdvanced);
        advanced.setOnClickListener(this);

        back = (Button) findViewById(R.id.CardioBack);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.CardioBeginner):
                startActivity(new Intent(this, CardioBeginner.class));
                break;
            case(R.id.CardioIntermedidate):
                startActivity(new Intent(this, CardioIntermediate.class));
                break;
            case(R.id.CardioAdvanced):
                startActivity(new Intent(this, CardioAdvanced.class));
                break;
            case(R.id.CardioBack):
                startActivity(new Intent(this, WorkoutRecs.class));
                break;
        }
    }
}