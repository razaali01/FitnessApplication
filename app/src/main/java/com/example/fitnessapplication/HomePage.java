package com.example.fitnessapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingTextView = (TextView) findViewById(R.id.Welcome);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile =snapshot.getValue(User.class);

                if(userProfile != null)
                {
                    String fullName = userProfile.fullName;

                    greetingTextView.setText("Welcome, " + fullName + "!!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomePage.this, "Something wrong happened", Toast.LENGTH_LONG).show();
            }
        });
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