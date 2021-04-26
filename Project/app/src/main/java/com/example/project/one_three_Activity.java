package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class one_three_Activity extends AppCompatActivity implements Serializable {
    ArrayList<storeData> arrayList;
    int filter = 0;

    Button btn_korea;
    Button btn_china;
    Button btn_japan;
    Button btn_west;
    Button btn_asia;
    Button btn_snack;
    Button btn_chicken;
    Button btn_night;
    Button btn_coffee;

    //String[] temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_three);

        /*Intent intent = getIntent();
        temp =intent.getStringArrayExtra("firstFilter");*/

        btn_korea=findViewById(R.id.btn_korea);
        btn_china=findViewById(R.id.btn_china);
        btn_japan=findViewById(R.id.btn_japan);
        btn_west=findViewById(R.id.btn_west);
        btn_asia=findViewById(R.id.btn_asia);
        btn_snack=findViewById(R.id.btn_snack);
        btn_chicken=findViewById(R.id.btn_chicken);
        btn_night=findViewById(R.id.btn_night);
        btn_coffee=findViewById(R.id.btn_coffee);

        Intent intent_one_two = getIntent();
        Serializable s = intent_one_two.getSerializableExtra("firebase");
        arrayList = (ArrayList<storeData>) s;
        filter = intent_one_two.getIntExtra("filter", 0);

        btn_korea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+1);
            }
        });
        btn_china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+2);
            }
        });
        btn_japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+3);
            }
        });
        btn_west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+4);
            }
        });
        btn_asia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+5);
            }
        });
        btn_snack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+6);
            }
        });
        btn_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+7);
            }
        });
        btn_night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+8);
            }
        });
        btn_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turnPageBtn(filter+9);
            }
        });
    }
    public void turnPageBtn(int i){
        Intent intent_one_five =new Intent(getApplicationContext(), one_four_Activity.class);
        intent_one_five.putExtra("firebase", arrayList);
        intent_one_five.putExtra("filter", i);
        //intent_one_five.putExtra("secondFilter",temp[0]+i);
        //FilterCheck.filter2=i;
        startActivity(intent_one_five);
}
}