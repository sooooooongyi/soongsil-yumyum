package com.example.project;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

public class pickActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    //private RecyclerView recyclerView;
    //private RecyclerView.Adapter mAdapter;
    //private RecyclerView.LayoutManager layoutManager;
   // MenuDatabaseManger databaseManager;
    //private String[] myDataset=new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);
        TextView one = findViewById(R.id.nameInPick);
        TextView two = findViewById(R.id.menuInPick);
        TextView three = findViewById(R.id.expect_calorieInPick);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapInPick);
        mapFragment.getMapAsync(this);

        one.setText(tempStoreData.store_name);
        two.setText(tempStoreData.store_recommand);
        three.setText(Integer.toString(tempStoreData.store_calorie)+"kcal");

        //recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
    //    databaseManager = MenuDatabaseManger.getInstance(this);
     //   getPickList();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //layoutManager = new LinearLayoutManager(this);
       // recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        //mAdapter = new PickAdapter(myDataset);
        //recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        LatLng location = new LatLng(Float.parseFloat(String.valueOf(tempStoreData.store_latitude)),
                Float.parseFloat(String.valueOf(tempStoreData.store_longitude)));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(location);

        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));
    }
/*
    public void getPickList(){
        String[] columns = new String[]{"_id", "title", "recommendMenu", "price", "calorie", "latitude",
                "longitude", "filter1", "filter2", "pick"};
        int i=0;
      Cursor cursor = databaseManager.query(columns, null, null, null, null, null);
     if (cursor != null) {
         while (cursor.moveToNext()) {
        myDataset[i++]=cursor.getString(1);
                    if(i==10)
                        i=0;
                }
            }
   }
    }*/
}
