package com.example.fitnessapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener{

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;
    private Button Back, Logout, Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        Logout = (Button) findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfilePage.this, MainActivity.class));
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingTextView = findViewById(R.id.greeting);
        final TextView fullNameTextView =  findViewById(R.id.fullName);
        final TextView emailAddressTextView = findViewById(R.id.emailAddress);
        final TextView passwordTextView = findViewById(R.id.password);
        final TextView genderTextView = findViewById(R.id.gender);
        final TextView heightTextView =  findViewById(R.id.height);
        final TextView ageTextView = findViewById(R.id.age);
        final TextView numTextView = findViewById(R.id.num);
        final TextView addressTextView = findViewById(R.id.address);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null) {
                    String fullName = userProfile.fullName;
                    String email = userProfile.email;
                    String age = userProfile.age;
                    String password = userProfile.password;
                    String gender = userProfile.gender;
                    String address = userProfile.address;
                    String height = userProfile.height;
                    String number = userProfile.number;

                    greetingTextView.setText("Welcome, " + fullName + "!");
                    fullNameTextView.setText(fullName);
                    emailAddressTextView.setText(email);
                    passwordTextView.setText(password);
                    genderTextView.setText(gender);
                    heightTextView.setText(height);
                    ageTextView.setText(age);
                    numTextView.setText(number);
                    addressTextView.setText(address);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfilePage.this, "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });

        Back = (Button) findViewById(R.id.BackProfile);
        Back.setOnClickListener(this);

        Edit = (Button) findViewById(R.id.edit);
        Edit.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case(R.id.BackProfile):
                startActivity(new Intent(this, HomePage.class));
                break;
            case(R.id.edit):
                startActivity(new Intent(this, EditProfile.class));
                break;
        }
    }
}