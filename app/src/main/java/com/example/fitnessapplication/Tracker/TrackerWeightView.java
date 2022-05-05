package com.example.fitnessapplication.Tracker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.fitnessapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class TrackerWeightView extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    ArrayList<WeightTrackerClass> userArrayList;
    TrackerWeightAdapter myAdapter;
    FirebaseFirestore db;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    private Button BackBtn;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tracker_weight_view);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data....");
        progressDialog.show();


        recyclerView = findViewById(R.id.TrackerRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        userArrayList = new ArrayList<WeightTrackerClass>();
        myAdapter = new TrackerWeightAdapter(TrackerWeightView.this, userArrayList);

        recyclerView.setAdapter(myAdapter);

        BackBtn = findViewById(R.id.TrackerWeightViewBack);
        BackBtn.setOnClickListener(this);

        EventChangeListner();

    }

    private void EventChangeListner() {

        db.collection("Weight" + userID).orderBy("date", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null){

                      if(progressDialog.isShowing()){
                          progressDialog.dismiss();
                      }

                      Log.e("Firestore error", error.getMessage());
                      return;
                }
                for(DocumentChange dc : value.getDocumentChanges()){
                    if(dc.getType() == DocumentChange.Type.ADDED){
                        userArrayList.add(dc.getDocument().toObject(WeightTrackerClass.class));
                    }

                    myAdapter.notifyDataSetChanged();
                    if(progressDialog.isShowing()){
                        progressDialog.dismiss();
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.TrackerWeightViewBack):
                startActivity(new Intent(this, WeightTrackerMain.class));
                break;
        }
    }
}