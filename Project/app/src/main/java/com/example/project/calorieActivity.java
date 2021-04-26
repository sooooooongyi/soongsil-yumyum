package com.example.project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calorieActivity extends AppCompatActivity {
    TextView cal;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        title=findViewById(R.id.eat_now_or_pick);
        cal=findViewById(R.id.calculateCalorie);

        int foodCal = Integer.parseInt(String.valueOf(tempStoreData.store_calorie));

        int x = 800 -foodCal; //권장 섭취 값-음식 값
        //if(IsPickedQuestion.pick==0) {
            title.setText("방금 먹은(찜한) 메뉴 칼로리");
            if (x > 0) {
                cal.setText("권장 섭취량보다 " + Math.abs(x) + "kcal 덜 드셨습니다!");
            } else if (x == 0) {
                cal.setText("권장 섭취량만틈 드셨습니다!");
            } else {
                cal.setText("권장 섭취량보다 " + Math.abs(x) + "kcal 더 드셨습니다!");
            }
        /*}else{
            title.setText("방금 찜한 메뉴 칼로리");
            if (x > 0) {
                cal.setText("방금 찜한 음식은 권장 섭취량보다 " + Math.abs(x) + "kcal 적습니다!");
            } else if (x == 0) {
                cal.setText("방금 찜한 음식은 권장 섭취량과 동일합니다!");
            } else {
                cal.setText("방금 찜한 음식은 권장 섭취량보다 " + Math.abs(x) + "kcal 많습니다!");
            }
        }*/
    }
}