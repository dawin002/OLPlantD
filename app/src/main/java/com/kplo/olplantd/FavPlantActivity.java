package com.kplo.olplantd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FavPlantActivity extends Activity {

    private ListView lv_favList;
    private FavPlantAdapter adapter;
    private ArrayList<FavPlantItem> favPlantItems;  // 리스트뷰 구성용
    private Button btn_to_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_plant);

        lv_favList = (ListView) findViewById(R.id.Listview_Plant_Rank);
        favPlantItems = new ArrayList<FavPlantItem>();

        setList();

        adapter = new FavPlantAdapter(FavPlantActivity.this, favPlantItems);

        lv_favList.setAdapter(adapter);
        lv_favList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String curItem = adapter.getItem(position).getItemName();
                Intent intent = new Intent(FavPlantActivity.this, PlantExplanationActivity.class);
                intent.putExtra("plant_name", curItem);
                startActivity(intent);
                finish();
            }
        });

        btn_to_home = (Button) findViewById(R.id.btn_to_home);
        btn_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setList() {
        for(String tmp : MainActivity.favList ){
            favPlantItems.add(new FavPlantItem(tmp));
        }
    }
}