package com.example.fitnessapplication;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Goals extends AppCompatActivity implements View.OnClickListener{

    List<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;

    private Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        toDoList = new ArrayList<>();
        //toDoList = User.getToDoList();


        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view_layout, toDoList);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;

                if(!textView.getPaint().isStrikeThruText()){
                    textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else{
                    textView.setPaintFlags(textView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                }
            }
        });

        editText = findViewById(R.id.id_edit_text);

        Back = (Button) findViewById(R.id.GoalsBack);
        Back.setOnClickListener(this);
    }

    public void addItemToList(View view){
        toDoList.add(editText.getText().toString());
        //User.setToDoList(toDoList);
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case(R.id.GoalsBack):
                startActivity(new Intent(this, HomePage.class));
                break;
        }
    }
}