package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Goals extends AppCompatActivity implements View.OnClickListener{

    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        Back = (Button) findViewById(R.id.BackGoals);
        Back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case(R.id.BackGoals):
                startActivity(new Intent(this, HomePage.class));
                break;
        }
    }
}