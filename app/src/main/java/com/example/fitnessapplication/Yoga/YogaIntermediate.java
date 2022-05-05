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

public class YogaIntermediate extends AppCompatActivity implements View.OnClickListener{

    TextView text;
    ArrayList<String> Workouts;
    private Button another, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_intermediate);

        final int random = new Random().nextInt(2-1) + 1; // [0, 60] + 20 => [20, 80]

        Workouts = new ArrayList<>();

        Workouts.add("Downward Dog, Baby Cobra, Tree Pose, Eagle Pose, Warrior 1, Warrior 2, Half Moon Pose, Triangle");
        Workouts.add("Tree Pose, Downward Dog, Chair Pose, Fire Log Pose, Pigeon Pose, Scale Pose, Wild Thing, Upward Bow");

        another = (Button) findViewById(R.id.YogaIntermediateAnother);
        another.setOnClickListener(this);

        back = (Button) findViewById(R.id.YogaIntermediateBack);
        back.setOnClickListener(this);

        String set = Workouts.get(random);
        text = (TextView) findViewById(R.id.YogaIntermediateSelection);
        text.setText(set);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.YogaIntermediateAnother):
                int random2 = new Random().nextInt(2-1) + 1;
                String set = Workouts.get(random2);
                text.setText(set);
                break;
            case(R.id.YogaIntermediateBack):
                startActivity(new Intent(this, WorkoutYogaGroup.class));
                break;
        }
    }
}