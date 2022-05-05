package com.example.fitnessapplication.Tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapplication.R;

import java.util.ArrayList;


public class TrackerCalorieAdapter extends RecyclerView.Adapter<TrackerCalorieAdapter.MyViewHolder1> {

    Context context;
    ArrayList<CalorieTrackerClass> userArrayList;

    public TrackerCalorieAdapter(Context context, ArrayList<CalorieTrackerClass> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public TrackerCalorieAdapter.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.tracker_calorie_item, parent, false);
        return new MyViewHolder1(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {

        CalorieTrackerClass user = userArrayList.get(position);

        holder.date.setText(user.date);
        holder.calories.setText(user.calories);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder{

        TextView date, calories;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.tvCalDate);
            calories = itemView.findViewById(R.id.tvCalories);
        }
    }
}
