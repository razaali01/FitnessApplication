package com.example.fitnessapplication.Tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitnessapplication.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CalorieTrackerMain extends AppCompatActivity implements View.OnClickListener{

    private EditText DateEdt, CalorieEdt;
    private Button AddBtn, ViewBtn, BackBtn;
    private String Date, Calorie;
    private FirebaseFirestore db;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_tracker_main);

        db = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        DateEdt = findViewById(R.id.TrackerCalorieDateInput);
        CalorieEdt = findViewById(R.id.TrackerCalorieCalorieInput);

        ViewBtn = findViewById(R.id.TrackerCalorieView);
        ViewBtn.setOnClickListener(this);

        BackBtn = findViewById(R.id.TrackerCalorieBack);
        BackBtn.setOnClickListener(this);

        AddBtn = findViewById(R.id.TrackerCalorieAddWeight);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date = DateEdt.getText().toString();
                Calorie = CalorieEdt.getText().toString();

                if(TextUtils.isEmpty(Date)){
                    DateEdt.setError("Please Enter A Date");
                }
                else if(TextUtils.isEmpty(Calorie)){
                    CalorieEdt.setError("Please Enter a Weight");
                }
                else{
                    addDataToFirestore( Date, Calorie);
                }
            }
        });
    }

    private void addDataToFirestore(String Date, String Calorie){
        CollectionReference dbTrackerWeight = db.collection("Calories" + userID);

        CalorieTrackerClass CalorieTracker = new CalorieTrackerClass(Date, Calorie);

        dbTrackerWeight.add(CalorieTracker).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(CalorieTrackerMain.this, "Your entry has been added", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CalorieTrackerMain.this, "Failed to add entry \n" + e, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.TrackerCalorieView):
                startActivity(new Intent(this, TrackerCalorieView.class));
                break;
            case(R.id.TrackerCalorieBack):
                startActivity(new Intent(this, TrackerMain.class));
                break;
        }
    }
}