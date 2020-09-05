package com.example.sorteiocartola.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sorteiocartola.R;

public class TimeHolder extends RecyclerView.ViewHolder {

    public TextView tvId1;
    public TextView tvId2;
    public TextView tvTime1;
    public TextView tvTime2;
    public EditText etPt1;
    public EditText etPt2;
    public View view1;
    public View view2;

    public TimeHolder(@NonNull View itemView) {
        super(itemView);
        tvId1 = itemView.findViewById(R.id.tv_id1);
        tvId2 = itemView.findViewById(R.id.tv_id2);
        tvTime1 = itemView.findViewById(R.id.tv_chave_time1);
        tvTime2 = itemView.findViewById(R.id.tv_chave_time2);
        etPt1 = itemView.findViewById(R.id.et_pt_time1);
        etPt2 = itemView.findViewById(R.id.et_pt_time2);
        view1 = itemView.findViewById(R.id.view_time1);
        view2 = itemView.findViewById(R.id.view_time2);

    }
}
