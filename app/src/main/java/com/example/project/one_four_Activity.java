package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class one_four_Activity extends Activity implements Serializable {
    private ArrayList<storeData> arrayList;
    ArrayList<storeData> filterArray; // 필터링 후 결과 arrayList
    int filter;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_four);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent_one_two = getIntent();
        Serializable s = intent_one_two.getSerializableExtra("firebase");
        arrayList = (ArrayList<storeData>) s;
        filter = intent_one_two.getIntExtra("filter", 0);

        // filter 함수 (filter: 10의자리 - 첫필터 1의자리 - 두번째필터)
        ssu_filter(arrayList, filter);

        // specify an adapter (see also next example)
        mAdapter = new storeAdapter(filterArray, this); // 아직 없음 데이터셋!
        ((storeAdapter)mAdapter).setOnItemClickListener(new storeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent_one_five =new Intent(getApplicationContext(), one_five_Activity.class);
                Log.d("dddd",tempStoreData.store_name);
                startActivity(intent_one_five);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    public void ssu_filter(ArrayList<storeData> arrayList, int filter) {
        int i;
        filterArray = new ArrayList<>();

        for(i = 0; i < arrayList.size(); i++)
        {
            if(filter == arrayList.get(i).store_filter1*10 + arrayList.get(i).store_filter2)
                filterArray.add(arrayList.get(i));
        }
    }
}