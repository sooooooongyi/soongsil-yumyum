package com.example.project;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter<chatAdapter.MyViewHolder> {
    private List<chatData> mDataset;
    private String myNickName;
    private static View.OnClickListener onClickListener;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView message;
        public TextView nickname;

        public MyViewHolder(View v) {
            super(v);
            message = v.findViewById(R.id.TextView_msg);
            nickname = v.findViewById(R.id.TextView_nickname);
        }
    }
    public chatAdapter(List<chatData> myDataset, Context context, String myNickName) {
        mDataset = myDataset;
        this.myNickName = myNickName;
    }

    @Override
    public chatAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        chatData chat = mDataset.get(position);
        holder.nickname.setText(chat.getNickname());
        holder.message.setText( chat.getMessage());

        if(chat.getNickname().equals(this.myNickName)) {
            holder.message.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            holder.nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
        else {
            holder.message.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            holder.nickname.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 :  mDataset.size();
    }

    public chatData getChat(int position) {
        return mDataset != null ? mDataset.get(position) : null;
    }

    public void addChat(chatData chat) {
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1);
    }
}

