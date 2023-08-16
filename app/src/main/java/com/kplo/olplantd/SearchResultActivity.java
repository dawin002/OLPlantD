package com.kplo.olplantd;

import static com.kplo.olplantd.PlantRankActivity.increaseSearchNum;

import android.content.Intent;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import android.app.Activity;
import java.util.ArrayList;

public class SearchResultActivity extends Activity {

    private EditText et_searchBox;
    private ListView lv_resultList;
    private Button btn_searchBtn;
    private Button btn_to_home;

    private String searchWord;
    private SearchResultAdapter adapter;
    private ArrayList<SearchResultItem> searchResultItems;
    private DB_PlantList db_pl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        db_pl = new DB_PlantList();
        db_pl.setup();

        Intent arrivedIntent = getIntent();
        searchWord = (String) arrivedIntent.getStringExtra("searchWord");

        et_searchBox = (EditText) findViewById(R.id.et_searchBox2);
        et_searchBox.setText(searchWord);

        lv_resultList = (ListView) findViewById(R.id.ListView_Search_Result);

        searchResultItems = new ArrayList<SearchResultItem>();

        if (searchWord.equals("all") || searchWord == null)
            setListAll(db_pl);
        else
            setList(db_pl, searchWord);

        adapter = new SearchResultAdapter(SearchResultActivity.this, searchResultItems);

        lv_resultList.setAdapter(adapter);

        btn_searchBtn = (Button) findViewById(R.id.Button_SearchBtn2);
        btn_searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWord = et_searchBox.getText().toString();
                Intent intent = new Intent(SearchResultActivity.this, SearchResultActivity.class);
                intent.putExtra("searchWord", searchWord);
                increaseSearchNum(searchWord);
                startActivity(intent);
                finish();
            }
        });

        lv_resultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String curItem = adapter.getItem(position).getItemName();
                Intent intent = new Intent(SearchResultActivity.this, PlantExplanationActivity.class);
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

    private void setList(DB_PlantList db_pl, String searchWord){
        searchResultItems.clear();
        for(Plant tmp : db_pl.pList ){
            if(tmp.getName().contains(searchWord))
                searchResultItems.add(new SearchResultItem(tmp.getName()));
        }
    }

    private void setListAll(DB_PlantList db_pl){
        searchResultItems.clear();
        for(Plant tmp : db_pl.pList ){
            searchResultItems.add(new SearchResultItem(tmp.getName()));
        }
    }
}