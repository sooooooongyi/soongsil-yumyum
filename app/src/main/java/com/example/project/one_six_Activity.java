package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Serializable;

public class one_six_Activity extends AppCompatActivity implements Serializable {
    Button btn_done;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_six_);
        btn_done=findViewById(R.id.btn_done);
        radioButton1 = (RadioButton)findViewById(R.id.rg_btn1);
        radioButton2 = (RadioButton)findViewById(R.id.rg_btn2);
        radioButton3 = (RadioButton)findViewById(R.id.rg_btn3);
        radioButton4 = (RadioButton)findViewById(R.id.rg_btn4);
        radioButton5 = (RadioButton)findViewById(R.id.rg_btn5);


        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double score=0;
                if(radioButton1.isChecked() == true) score =1;
                if(radioButton2.isChecked() == true) score =2;
                if(radioButton3.isChecked() == true) score =3;
                if(radioButton4.isChecked() == true) score =4;
                if(radioButton5.isChecked() == true) score =5;

                isFirst.flag++;
                Intent intent_main =new Intent(getApplicationContext(), MainActivity.class);
                intent_main.putExtra("sum",score);
                startActivity(intent_main);
            }
        });
    }
}