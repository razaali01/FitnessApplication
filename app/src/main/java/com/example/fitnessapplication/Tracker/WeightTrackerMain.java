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

public class WeightTrackerMain extends AppCompatActivity implements View.OnClickListener{

    private EditText DateEdt, WeightEdt;
    private Button AddBtn, ViewBtn, BackBtn;
    private String Date, Weight;
    private FirebaseFirestore db;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker_main);

        db = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        DateEdt = findViewById(R.id.TrackerWeightDateInput);
        WeightEdt = findViewById(R.id.TrackerWeightWeightInput);

        ViewBtn = findViewById(R.id.TrackerWeightView);
        ViewBtn.setOnClickListener(this);

        BackBtn = findViewById(R.id.TrackerWeightBack);
        BackBtn.setOnClickListener(this);

        AddBtn = findViewById(R.id.TrackerAddWeight);
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date = DateEdt.getText().toString();
                Weight = WeightEdt.getText().toString();

                if(TextUtils.isEmpty(Date)){
                    DateEdt.setError("Please Enter A Date");
                }
                else if(TextUtils.isEmpty(Weight)){
                    WeightEdt.setError("Please Enter a Weight");
                }
                else{
                    addDataToFirestore( Date, Weight);
                }
            }
        });
    }

    private void addDataToFirestore(String Date, String Weight){
        CollectionReference dbTrackerWeight = db.collection("Weight" + userID);

        WeightTrackerClass WeightTracker = new WeightTrackerClass(Date, Weight);

        dbTrackerWeight.add(WeightTracker).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(WeightTrackerMain.this, "Your entry has been added", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(WeightTrackerMain.this, "Failed to add entry \n" + e, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.TrackerWeightView):
                startActivity(new Intent(this, TrackerWeightView.class));
                break;
            case(R.id.TrackerWeightBack):
                startActivity(new Intent(new Intent(this, TrackerMain.class)));
                break;
        }
    }
}