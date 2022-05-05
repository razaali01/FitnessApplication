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

public class TrackerWeightAdapter extends RecyclerView.Adapter<TrackerWeightAdapter.MyViewHolder> {

    Context context;
    ArrayList<WeightTrackerClass> userArrayList;

    public TrackerWeightAdapter(Context context, ArrayList<WeightTrackerClass> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public TrackerWeightAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.tracker_wieght_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackerWeightAdapter.MyViewHolder holder, int position) {

        WeightTrackerClass user = userArrayList.get(position);

        holder.date.setText(user.date);
        holder.weight.setText(user.weight);

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date, weight;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.tvDate);
            weight = itemView.findViewById(R.id.tvWeight);

        }
    }


}
