package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PickAdapter extends RecyclerView.Adapter<PickAdapter.MyViewHolder> {
    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView menu;
        public TextView menu_detail;

        public MyViewHolder(View v) {
            super(v);
            menu=v.findViewById(R.id.menu);
            menu_detail=v.findViewById(R.id.menu_detail);
            //menu_picture=v.findFocus(R.id.menu_picture);
        }
    }

    public PickAdapter(String[] myDataset) {

        mDataset = myDataset;
    }

    @Override
    public PickAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pick, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.menu.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
