package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class one_two_Activity extends AppCompatActivity implements Serializable {
    ArrayList<storeData> arrayList;

    Button btn_all;
    Button btn_flex;
    Button btn_cost;
    Button btn_instar;
    Button btn_some;
    Button btn_alone;
    Button btn_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_two);

        //btn_all=findViewById(R.id.btn_all);
        btn_flex=findViewById(R.id.btn_flex);
        btn_cost=findViewById(R.id.btn_cost);
        btn_instar=findViewById(R.id.btn_instar);
        btn_some=findViewById(R.id.btn_some);
        btn_alone=findViewById(R.id.btn_alone);
        btn_test=findViewById(R.id.btn_test);

        Intent intent_one_two = getIntent();
        Serializable s = intent_one_two.getSerializableExtra("firebase");
        arrayList = (ArrayList<storeData>) s;

        btn_flex.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                turnPageBtn(1);
            }
        });
        btn_cost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                turnPageBtn(2);
            }
        });
        btn_instar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                turnPageBtn(3);
            }
        });
        btn_some.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                turnPageBtn(4);
            }
        });
        btn_alone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                turnPageBtn(5);
            }
        });
        btn_test.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                turnPageBtn(6);
            }
        });
    }
    public void turnPageBtn(int i){
        Intent intent_one_three =new Intent(getApplicationContext(), one_three_Activity.class);
        intent_one_three.putExtra("firebase", arrayList);
        intent_one_three.putExtra("filter", i*10);
        //intent_one_three.putExtra("firstFilter",Integer.toString(i));
        //FilterCheck.filter1=i;
        startActivity(intent_one_three);
    }
}