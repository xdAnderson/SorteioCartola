package com.example.sorteiocartola.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sorteiocartola.Controller.SorteioController;
import com.example.sorteiocartola.Model.TimeModel;
import com.example.sorteiocartola.R;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeHolder> {
    Context context;
    SorteioController sorteioController;
    TimeModel timeModel;
    int positionAux1;
    int positionAux2;
    private final List<TimeModel> times;

    public TimeAdapter(List<TimeModel> times, Context context) {
        this.times = times;
        this.context = context;
    }

    @NonNull
    @Override
    public TimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final TimeHolder holder, int position) {
        positionAux1 = position*2;
        positionAux2 = positionAux1+1;
        sorteioController = new SorteioController(context);
        timeModel = new TimeModel();


        if(positionAux1<times.size()) {
            holder.tvTime1.setText(times.get(positionAux1).getNome());
            holder.etPt1.setText(times.get(positionAux1).getPt()+"");
            holder.tvId1.setText(times.get(positionAux1).getId());
//            if (Float.parseFloat(holder.etPt1.getText().toString()) < Float.parseFloat(holder.etPt2.getText().toString())) {
//                holder.view1.setBackgroundColor(0xFFFFAB91);
//                holder.view2.setBackgroundColor(0xFFA5D6A7);
//            } else {
//                if (Float.parseFloat(holder.etPt2.getText().toString()) < Float.parseFloat(holder.etPt1.getText().toString())) {
//                    holder.view2.setBackgroundColor(0xFFFFAB91);
//                    holder.view1.setBackgroundColor(0xFFA5D6A7);
//                }
//            }

            holder.etPt1.setFocusable(true);
            holder.etPt1.setFocusableInTouchMode(true);
            holder.etPt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        timeModel.setNome(holder.tvTime1.getText().toString());
                        timeModel.setId(holder.tvId1.getText().toString());
                        timeModel.setPt(Float.parseFloat(holder.etPt1.getText().toString()));
                        sorteioController.alterar(timeModel);

                        if (Float.parseFloat(holder.etPt1.getText().toString()) < Float.parseFloat(holder.etPt2.getText().toString())) {
                            holder.view1.setBackgroundColor(0xFFFFAB91);
                            holder.view2.setBackgroundColor(0xFFA5D6A7);
                        } else {
                            if (Float.parseFloat(holder.etPt2.getText().toString()) < Float.parseFloat(holder.etPt1.getText().toString())) {
                                holder.view2.setBackgroundColor(0xFFFFAB91);
                                holder.view1.setBackgroundColor(0xFFA5D6A7);
                            }
                        }

                    }
                }
            });

            holder.tvId2.setText(times.get(positionAux2).getId());
            holder.tvTime2.setText(times.get(positionAux2).getNome());
            holder.etPt2.setText(times.get(positionAux2).getPt()+"");
//            if (Float.parseFloat(holder.etPt1.getText().toString()) < Float.parseFloat(holder.etPt2.getText().toString())) {
//                holder.view1.setBackgroundColor(0xFFFFAB91);
//                holder.view2.setBackgroundColor(0xFFA5D6A7);
//            } else {
//                if (Float.parseFloat(holder.etPt2.getText().toString()) < Float.parseFloat(holder.etPt1.getText().toString())) {
//                    holder.view2.setBackgroundColor(0xFFFFAB91);
//                    holder.view1.setBackgroundColor(0xFFA5D6A7);
//                }
//            }
            holder.etPt2.setFocusable(true);
            holder.etPt2.setFocusableInTouchMode(true);
            holder.etPt2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        timeModel.setNome(holder.tvTime2.getText().toString());
                        timeModel.setId(holder.tvId2.getText().toString());
                        timeModel.setPt(Float.parseFloat(holder.etPt2.getText().toString()));
                        sorteioController.alterar(timeModel);
                        if (Float.parseFloat(holder.etPt1.getText().toString()) < Float.parseFloat(holder.etPt2.getText().toString())) {
                            holder.view1.setBackgroundColor(0xFFFFAB91);
                            holder.view2.setBackgroundColor(0xFFA5D6A7);
                        } else {
                            if (Float.parseFloat(holder.etPt2.getText().toString()) < Float.parseFloat(holder.etPt1.getText().toString())) {
                                holder.view2.setBackgroundColor(0xFFFFAB91);
                                holder.view1.setBackgroundColor(0xFFA5D6A7);
                            }
                        }

                    }
                }
            });



            if (Float.parseFloat(holder.etPt1.getText().toString()) < Float.parseFloat(holder.etPt2.getText().toString())) {
                holder.view1.setBackgroundColor(0xFFFFAB91);
                holder.view2.setBackgroundColor(0xFFA5D6A7);
            } else {
                if (Float.parseFloat(holder.etPt2.getText().toString()) < Float.parseFloat(holder.etPt1.getText().toString())) {
                    holder.view2.setBackgroundColor(0xFFFFAB91);
                    holder.view1.setBackgroundColor(0xFFA5D6A7);
                }
            }

        }
    }

    @Override
    public int getItemCount() {
        return times != null ? times.size()/2 : 0;
    }


}
