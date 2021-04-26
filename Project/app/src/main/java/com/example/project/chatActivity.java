package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


    public class chatActivity extends AppCompatActivity {
        // Write a message to the database
        private DatabaseReference myRef;

        private RecyclerView recyclerView;
        public RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;
        private List<chatData> chatList;
        private String nickname = "User1";

        private EditText editText;
        private Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chat);

            editText = (EditText) findViewById(R.id.EditText_chat);
            button = (Button) findViewById(R.id.Button_send);

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String message = editText.getText().toString();

                    if (message != null) {
                        chatData chat = new chatData();
                        chat.setNickname(nickname);
                        chat.setMessage(message);
                        myRef.push().setValue(chat);
                    }
                }
            });

            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            chatList = new ArrayList<>();
            mAdapter = new chatAdapter(chatList, chatActivity.this, nickname);

            recyclerView.setAdapter(mAdapter);

            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            myRef = database.getReference("message");

            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    chatData chat = snapshot.getValue(chatData.class);
                    ((chatAdapter) mAdapter).addChat(chat);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

