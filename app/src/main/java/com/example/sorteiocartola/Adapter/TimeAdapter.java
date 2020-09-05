package com.example.sorteiocartola.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sorteiocartola.Model.TimeModel;
import com.example.sorteiocartola.R;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeHolder> {

    private final List<TimeModel> times;

    public TimeAdapter(List<TimeModel> times) {
        this.times = times;
    }

    @NonNull
    @Override
    public TimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TimeHolder holder, int position) {
        int positionAux2 = times.size()-(times.size()-position-1);
        int positionAux1 = position*2;
        if(positionAux1<times.size()) {
            float pt1 = times.get(positionAux1).getPt();
            holder.tvTime1.setText(times.get(positionAux1).getNome());
            holder.etPt1.setText(String.valueOf(pt1));

            float pt2 = times.get(positionAux2).getPt();
            holder.tvTime2.setText(times.get(positionAux2).getNome());
            holder.etPt2.setText(String.valueOf(pt2));
            if (pt1 < pt2) {
                holder.view1.setBackgroundColor(0xFFFFAB91);
                holder.view2.setBackgroundColor(0xFFA5D6A7);
            } else {
                if (pt2 < pt1) {
                    holder.view2.setBackgroundColor(0xFFFFAB91);
                    holder.view1.setBackgroundColor(0xFFA5D6A7);
                }
            }
        }/*
        if(positionAux==times.size()-1){
            position=times.size()-1;
        }*/

    }

    @Override
    public int getItemCount() {
        return times != null ? times.size() : 0;
    }
}
