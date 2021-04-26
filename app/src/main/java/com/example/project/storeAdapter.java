package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class storeAdapter extends RecyclerView.Adapter<storeAdapter.MyViewHolder> implements Serializable {
    private ArrayList<storeData> arrayList;
    private Context context;

    private OnItemClickListener mListener =null;
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener=listener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements Serializable {
        ImageView store_img;
        TextView store_name;

        public MyViewHolder(View v) {
            super(v);
            store_img = v.findViewById(R.id.store_img);
            store_name = v.findViewById(R.id.store_name);
            //store_score = v.findViewById(R.id.store_score);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    storeData storeData = arrayList.get(position);
                    tempStoreData.store_calorie=storeData.store_calorie;
                    tempStoreData.store_pick=storeData.store_pick;
                    tempStoreData.store_price=storeData.store_price;
                    tempStoreData.store_score=storeData.store_score;
                    tempStoreData.store_latitude=storeData.store_latitude;
                    tempStoreData.store_longitude=storeData.store_longitude;
                    tempStoreData.store_recommand=storeData.store_recommand;
                    tempStoreData.store_name=storeData.store_name;
                    tempStoreData.store_img=storeData.store_img;

                    if(position!=RecyclerView.NO_POSITION){
                        if(mListener!=null){
                            mListener.onItemClick(view,position);
                        }
                    }
                }
            });
        }
    }
    public storeAdapter(ArrayList<storeData> arrayList, Context context) { 
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public storeAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_one_four, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Glide.with(holder.itemView).load(arrayList.get(position).getStore_img()).into(holder.store_img);
        holder.store_name.setText(arrayList.get(position).getStore_name());
        //holder.store_score.setText(String.valueOf(arrayList.get(position).getStore_score()));
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }
}
