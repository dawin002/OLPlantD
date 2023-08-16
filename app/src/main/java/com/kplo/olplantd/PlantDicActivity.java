package com.kplo.olplantd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import android.app.Activity;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlantDicActivity extends Activity {

    private TextView btn_to_searchPlant;
    private TextView tv_listTitle;
    private ListView lv_pDic;
    private Button btn_dicTop;
    private Button btn_dicUp;
    private Button btn_to_home;

    private List<String> list_pDic;
    ArrayAdapter<String> adapter_pDic;

    private List<DB_PDList> linkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_dic);

        // 도감 데이터 세팅
        DB_PDList db_pdl = new DB_PDList("식물도감");
        FilePDList fp = new FilePDList();
        db_pdl.makeTree(fp);


        btn_to_searchPlant = (TextView) findViewById(R.id.AppCompatTextView_SearchPlant);
        btn_to_searchPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlantDicActivity.this, SearchPlantActivity.class);
                startActivity(intent);
            }
        });


        tv_listTitle = (TextView) findViewById(R.id.AppCompatTextView_Plant_Dic_Name);

        // 리스트뷰 기본 세팅
        lv_pDic = (ListView) findViewById(R.id.Listview_Plant_Dic);
        list_pDic = new ArrayList<>();
        adapter_pDic = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list_pDic);
        lv_pDic.setAdapter(adapter_pDic);

        setList(db_pdl);
        linkList.add(db_pdl);
        adapter_pDic.notifyDataSetChanged();

        // 리스트뷰 아이템 클릭시 이벤트
        lv_pDic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // 종을 선택할 경우
                if(linkList.size()==6){
                    String itemName = list_pDic.get(position);
                    // 인텐트 목적지 다시
                    Intent intent = new Intent(PlantDicActivity.this, PlantExplanationActivity.class);
                    intent.putExtra("plant_name", itemName);
                    startActivity(intent);
                }
                else {
                    int nowIdx = linkList.size() - 1;
                    String itemName = list_pDic.get(position);
                    setList(linkList.get(nowIdx).getChild(itemName));
                    linkList.add(linkList.get(nowIdx).getChild(itemName));
                    adapter_pDic.notifyDataSetChanged();
                }
            }
        });

        // 맨위로 가기 버튼
        btn_dicTop = (Button) findViewById(R.id.btn_dicTop);
        btn_dicTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkList.clear();
                setList(db_pdl);
                linkList.add(db_pdl);
                adapter_pDic.notifyDataSetChanged();
            }
        });

        // 뒤로가기 버튼
        btn_dicUp = (Button) findViewById(R.id.btn_dicUp);
        btn_dicUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nowIdx = linkList.size()-1;
                if(nowIdx == 0){ return;}
                else {
                    linkList.remove(nowIdx);
                    setList(linkList.get(nowIdx - 1));
                    adapter_pDic.notifyDataSetChanged();
                }
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

    private void setList(DB_PDList db_tmp) {
        list_pDic.clear();
        for(int i=0; i<db_tmp.getSize(); i++) {
            list_pDic.add(db_tmp.getChildName(i));
        }
        Collections.sort(list_pDic, myComparator);
        tv_listTitle.setText(db_tmp.listName);
    }

    private final static Comparator myComparator= new Comparator() {
        private final Collator collator = Collator.getInstance();
        @Override
        public int compare(Object object1, Object object2) {
            return collator.compare(object1.toString(), object2.toString());
        }
    };

}