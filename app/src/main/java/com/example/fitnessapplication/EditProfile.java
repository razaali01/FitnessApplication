package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class EditProfile extends AppCompatActivity implements View.OnClickListener{

    private EditText editAddress, editAge, editEmail, editfullName, editGender, editHeight, editPhone, editPassword;
    private Button saveBtn, returnBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        String userID = user.getUid();

        editAddress = findViewById(R.id.EditAddress);
        editEmail = findViewById(R.id.EditEmail);
        editGender = findViewById(R.id.EditGender);
        editHeight = findViewById(R.id.EditHeight);
        editPassword = findViewById(R.id.EditPassword);
        editfullName = findViewById(R.id.EditName);
        editPhone = findViewById(R.id.EditNumber);
        editAge = findViewById(R.id.EditAge);



        returnBtn = findViewById(R.id.EditReturn);
        returnBtn.setOnClickListener(this);

        saveBtn = findViewById(R.id.EditSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address, age, email, fullName, gender, height, phone, password;

                address = editAddress.getText().toString().trim();
                age = editAge.getText().toString().trim();
                email = editEmail.getText().toString().trim();
                fullName = editfullName.getText().toString().trim();
                gender = editGender.getText().toString().trim();
                height = editHeight.getText().toString().trim();
                phone = editPhone.getText().toString().trim();
                password = editPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(address)){
                    reference.child(userID).child("address").setValue(address);
                }
                if(!TextUtils.isEmpty(email)){
                    reference.child(userID).child("email").setValue(email);
                }
                if(!TextUtils.isEmpty(gender)){
                    reference.child(userID).child("gender").setValue(gender);
                }
                if(!TextUtils.isEmpty(height)){
                    reference.child(userID).child("height").setValue(height);
                }
                if(!TextUtils.isEmpty(password)){
                    reference.child(userID).child("password").setValue(password);
                }
                if(!TextUtils.isEmpty(fullName)) {
                    reference.child(userID).child("fullName").setValue(fullName);
                }

                if(!TextUtils.isEmpty(phone)) {
                    reference.child(userID).child("number").setValue(phone);
                }
                if(!TextUtils.isEmpty(age)) {
                    reference.child(userID).child("age").setValue(age);
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case(R.id.EditReturn):
                startActivity(new Intent(this, ProfilePage.class));
                break;
        }
    }

}