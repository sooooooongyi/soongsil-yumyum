package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends TabActivity implements Serializable {
    private ArrayList<storeData> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBtn=findViewById(R.id.startBtn);

        arrayList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("store");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    storeData store = snapshot.getValue(storeData.class);
                    arrayList.add(store);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("one_four_activity", String.valueOf(databaseError.toException()));
            }
        });


        Intent intent_chat=new Intent(getApplicationContext(),chatActivity.class);
        Intent intent_cal=new Intent(getApplicationContext(),calorieActivity.class);
        Intent intent_pick=new Intent(getApplicationContext(),pickActivity.class/*showPickOnlyOne.class*/);
        TabHost tabHost=getTabHost();

        TabHost.TabSpec tabSpecHome = tabHost.newTabSpec("Home").setIndicator("홈");
        tabSpecHome.setContent(R.id.tabHome);
        tabHost.addTab(tabSpecHome);

        TabHost.TabSpec tabSpecCalorie = tabHost.newTabSpec("Calorie").setIndicator("칼로리");
        tabSpecCalorie.setContent(intent_cal);
        //tabSpecCalorie.setContent(R.id.tabCalorie);
        tabHost.addTab(tabSpecCalorie);


        TabHost.TabSpec tabSpecChat=tabHost.newTabSpec("Chat").setIndicator("채팅");
        tabSpecChat.setContent(intent_chat);
        //tabSpecChat.setContent(R.id.tabChat);
        tabHost.addTab(tabSpecChat);

        TabHost.TabSpec tabSpecPick=tabHost.newTabSpec("Pick").setIndicator("찜");
        tabSpecPick.setContent(intent_pick);
        //tabSpecPick.setContent(R.id.tabPick);
        tabHost.addTab(tabSpecPick);
        tabHost.setCurrentTab(0);

        startBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent_one_two =new Intent(getApplicationContext(), one_two_Activity.class);
                intent_one_two.putExtra("firebase", arrayList);
                startActivity(intent_one_two);
            }
        });

        /*if(isFirst.flag!=0) {
            Intent intent = getIntent();
            Double sum = intent.getExtras().getDouble("sum", 0);
            sum = (sum + tempStoreData.store_score) / 2;
            Map<String, Object> update = new HashMap<String, Object>();
            update.put("store_score",sum);
            db.collection(String.valueOf(databaseReference)).document(tempStoreData.store_name).update(update);
        }*/
            /*private FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("store")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
// 데이터를 가져오는 작업이 잘 동작했을 떄
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if(document.getString("store_name").equals(tempStoreData.store_name)) {
                                        int temp = tempStoreData.store_score;
                                        temp+=Integer.parseInt(document.getString("store_score"));
                                        temp=temp/2;
                                        Map<String,Object> taskMap=new HashMap<String,Object>();
                                        taskMap.put("store_score",Integer.toString(temp));
                                        db.collection("store").document(tempStoreData.store_name)
                                                .update(taskMap);
                                        //tv2.setText(document.getString("score"));
                                        //tv1.setText(document.getString("name"));
                                    }
                                    // Log.d("TAG", document.getId() + " => " + document.getString("name"));
                                }
                            }
                        }
                    });*/
    }
}