package com.example.project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;

public class one_five_Activity extends AppCompatActivity implements OnMapReadyCallback, Serializable,View.OnClickListener {
    private GoogleMap mMap;
    Button btn_pick;
    Button btn_eat_here;
    TextView title;
    TextView menu;
    TextView calorie;

    //MenuDatabaseManger databaseManager;
    //MenuDataItem currentData = new MenuDataItem();

    String[] temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_five);
        setTitle("숭실냠냠");

        Intent intent = getIntent();
        temp=intent.getStringArrayExtra("secondFilter");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //databaseManager = MenuDatabaseManger.getInstance(this);

        //getMenuData();

        title=findViewById(R.id.name);
        title.setText(tempStoreData.store_name);
        menu=findViewById(R.id.menu);
        menu.setText(tempStoreData.store_recommand);
        calorie=findViewById(R.id.expect_calorie);
        calorie.setText(tempStoreData.store_calorie+"Kcal");

        btn_pick=findViewById(R.id.btn_pick);
        btn_eat_here=findViewById(R.id.btn_eat_here);

        //btn_pick.setOnClickListener(this);

        btn_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues updateRowValue = new ContentValues();
                updateRowValue.put("pick","1");
               // databaseManager.update(updateRowValue,null,null);
               // IsPickedQuestion.pick=1;

                Intent intent_main =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_main);
            }
        });


        btn_eat_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues updateRowValue = new ContentValues();
                updateRowValue.put("pick","0");
              //  databaseManager.update(updateRowValue,null,null);
              //  IsPickedQuestion.pick=0;
                Intent intent_one_six =new Intent(getApplicationContext(), one_six_Activity.class);
                startActivity(intent_one_six);
            }
        });
    }
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        LatLng location = new LatLng(Float.parseFloat(String.valueOf(tempStoreData.store_latitude)),
                Float.parseFloat(String.valueOf(tempStoreData.store_longitude)));
        //LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(location);
        //markerOptions.title(currentData.title);
        //markerOptions.title("서울");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));
    }

    public void getMenuData() {
        String[] columns = new String[]{"_id", "title", "recommendMenu", "price", "calorie", "latitude",
                "longitude", "filter1", "filter2", "pick"};
      //  Cursor cursor = databaseManager.query(columns, null, null, null, null, null);
        //if (cursor != null) {
          //  while (cursor.moveToNext()) {
                /*if((temp[0].charAt(0)+"").equals(cursor.getString(7))&&
                        (temp[0].charAt(1)+"").equals(cursor.getString(8))) {*/
                /*if(FilterCheck.filter1==Integer.parseInt(cursor.getString(7))&&
                FilterCheck.filter2==Integer.parseInt(cursor.getString(8))) {
                    currentData.setId(cursor.getInt(0));
                    currentData.setTitle(cursor.getString(1));
                    currentData.setRecommendMenu(cursor.getString(2));
                    currentData.setPrice(cursor.getString(3));
                    currentData.setCalorie(cursor.getString(4));
                    currentData.setLatitude(cursor.getString(5));
                    currentData.setLongitude(cursor.getString(6));
                    currentData.setFilter1(cursor.getString(7));
                    currentData.setFilter2(cursor.getString(8));
                    currentData.setPick(cursor.getString(9));
                }
            }
        }*/
    }

    @Override
    public void onClick (View view){

        //ContentValues updateRowValue = new ContentValues();
        //updateRowValue.put("pick","1");

        /*String store_name = tempStoreData.store_name;
        String store_menu = tempStoreData.store_recommand;
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_memo(store_name, store_menu) values (?,?)",new String[]{store_name,store_menu});
        db.close();*/
        /*DBHelper helper1 = new DBHelper(this);
        SQLiteDatabase db1 = helper1.getWritableDatabase();
        Cursor cursor = db.rawQuery("select store_name, store_menu from tb_memo order by _id_desc limit 1",null);
        while(cursor.moveToNext()){
            Log.d("tttt",cursor.getString(0));
            Log.d("tttttttt",cursor.getString(1));
        }
        db1.close();*/
        Intent intent_main =new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent_main);
    }

}