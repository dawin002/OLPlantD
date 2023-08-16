package com.kplo.olplantd;

import static com.kplo.olplantd.DB_PRank.setLastWeekRank;
import static com.kplo.olplantd.DB_PRank.setTempRank;
import static com.kplo.olplantd.PlantRankActivity.addSearchNum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import android.app.Activity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private TextView tv_to_searchPlant;
    private TextView tv_to_plantRank;
    private Button btn_to_plantIdent;
    private ImageButton btn_to_todayFlower;
    private ImageButton btn_to_favPlant;
    private Button btn_to_plantDic;
    private FloatingActionButton btn_to_AI;

    public static List<DB_PRank> rankList;  // 이번주 순위
    public static List<DB_PRank> lweekRankList; // 지난주 순위
    public static ArrayList<String> favList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_to_searchPlant = (TextView) findViewById(R.id.AppCompatTextView_SearchPlant);
        tv_to_searchPlant.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SearchPlantActivity.class);
            startActivity(intent);
        });

        tv_to_plantRank = (TextView) findViewById(R.id.AppCompatTextView_Plant_Ranking);
        tv_to_plantRank.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlantRankActivity.class);
            startActivity(intent);
        });

        btn_to_plantIdent = (Button) findViewById(R.id.AppCompatButton_plant_Identi);
        btn_to_plantIdent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlantIdentActivity.class);
                startActivity(intent);
            }
        });

        btn_to_todayFlower = (ImageButton) findViewById(R.id.AppCompatImageButton_today_Flower);
        btn_to_todayFlower.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TodayFlowerActivity.class);
            startActivity(intent);
        });

        btn_to_favPlant = (ImageButton) findViewById(R.id.AppCompatImageButton_plant_Fav);
        btn_to_favPlant.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavPlantActivity.class);
            startActivity(intent);
        });

        btn_to_plantDic = (Button) findViewById(R.id.AppCompatButton_plant_Dic);
        btn_to_plantDic.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlantDicActivity.class);
            startActivity(intent);
        });

        btn_to_AI = (FloatingActionButton) findViewById(R.id.floating_action_button_AI);
        btn_to_AI.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AIActivity.class);
            startActivity(intent);
        });

        rankList = new ArrayList<DB_PRank>();
        lweekRankList = new ArrayList<DB_PRank>();

        favList = new ArrayList<String>();
        favList = SharedPreference.getStringArrayPref(MainActivity.this, "favPlantList");

//        favList.add("해바라기");
//        favList.add("소나무");
//        favList.add("포도");
//        favList.add("은행나무");
//        favList.add("강아지풀");

        setTempRank();
        setLastWeekRank();

        PlantInit plntinit = new PlantInit();
        plntinit.initDB();

        addSearchNum("해바라기", 10);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreference.setStringArrayPref(MainActivity.this, "favPlantList", favList);
    }
}