package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Goals extends AppCompatActivity implements View.OnClickListener{

    private Button Back;
    EditText textIn;
    Button buttonAdd;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        textIn = (EditText) findViewById(R.id.textin);
        buttonAdd = (Button) findViewById(R.id.add);
        container = (LinearLayout)findViewById(R.id.container);

        Back = (Button) findViewById(R.id.GoalsBack);
        Back.setOnClickListener(this);
        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);
                TextView textOut = (TextView)addView.findViewById(R.id.textout);
                textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button) addView.findViewById(R.id.remove);
                buttonRemove.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});

                container.addView(addView);
            }});
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case(R.id.GoalsBack):
                startActivity(new Intent(this, HomePage.class));
                break;
        }
    }
}