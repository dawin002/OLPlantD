package com.kplo.olplantd;

import static com.kplo.olplantd.MainActivity.lweekRankList;
import static com.kplo.olplantd.MainActivity.rankList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class PlantRankActivity extends Activity {

    private ListView lv_rankList;
    private PlantRankAdapter adapter;
    private ArrayList<PlantRankItem> plantRankItems;  // 리스트뷰 구성용
    private Button btn_to_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_rank);

        lv_rankList = (ListView) findViewById(R.id.Listview_Plant_Rank);
        plantRankItems = new ArrayList<PlantRankItem>();

        setRank();
        setList();

        adapter = new PlantRankAdapter(PlantRankActivity.this, plantRankItems);
        lv_rankList.setAdapter(adapter);

        lv_rankList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String curItem = adapter.getItem(position).getRankName();
                Intent intent = new Intent(PlantRankActivity.this, PlantExplanationActivity.class);
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

    private static void setRank() {
        setLastWeekRank();
        Collections.sort(rankList, Collections.reverseOrder());
        for(int i=0; i<rankList.size(); i++){
            int lwRank;
            rankList.get(i).setRankNum(i+1);
            int idx = -1;
            for(int j=0; j<lweekRankList.size(); j++){
                if(rankList.get(i).getName().equals(lweekRankList.get(j).getName()))
                    idx = j;
            }
            if (idx == -1){
                lwRank = rankList.size();
            } else {
                lwRank = lweekRankList.get(idx).getRankNum();
            }
            rankList.get(i).setRankChange(lwRank-(i+1));
        }
    }

    private static void setLastWeekRank() {
        Collections.sort(lweekRankList, Collections.reverseOrder());
        for(int i=0; i<lweekRankList.size(); i++) {
            lweekRankList.get(i).setRankNum(i+1);
        }
    }

    private void setList() {
        for(DB_PRank tmp : rankList){
            String rankNum = String.valueOf(tmp.getRankNum());
            String rankChange;
            if(tmp.getRankChange()>0) rankChange = "+".concat(String.valueOf(tmp.getRankChange()));
            else if(tmp.getRankChange() == 0) rankChange = "-";
            else rankChange = String.valueOf(tmp.getRankChange());
            plantRankItems.add(new PlantRankItem(tmp.getName(), rankNum, rankChange));
        }
    }

    public static void increaseSearchNum(String name){
        addSearchNum(name, 1);
    }

    public static void addSearchNum(String name, int n){
        int idx = -1;
        for(int i=0; i<rankList.size(); i++){
            if(rankList.get(i).getName().equals(name)) idx = i;
        }
        if(idx == -1)
            rankList.add(new DB_PRank(name, n, rankList.size()));
        else {
            int num = rankList.get(idx).getSearchNum();
            rankList.get(idx).setSearchNum( num + n);
        }
    }
}