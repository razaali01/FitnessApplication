package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class HomePage extends AppCompatActivity implements View.OnClickListener{

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    private Button Goals, WorkoutRecs, Tracker, ProfilePage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Goals = (Button) findViewById(R.id.Goals);
        Goals.setOnClickListener(this);

        WorkoutRecs = (Button) findViewById(R.id.WorkoutRecs);
        WorkoutRecs.setOnClickListener(this);

        Tracker = (Button) findViewById(R.id.Tracker);
        Tracker.setOnClickListener(this);

        ProfilePage = (Button) findViewById(R.id.ProfilePage);
        ProfilePage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case(R.id.Goals):
                startActivity(new Intent(this, Goals.class));
                break;
            case(R.id.WorkoutRecs):
                startActivity(new Intent(this, WorkoutRecs.class));
                break;
            case(R.id.Tracker):
                startActivity(new Intent(this, Tracker.class));
                break;
            case(R.id.ProfilePage):
                startActivity(new Intent(this, ProfilePage.class));
                break;
        }
    }
}