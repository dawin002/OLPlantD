package com.kplo.olplantd;

import static com.kplo.olplantd.PlantRankActivity.increaseSearchNum;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchPlantActivity extends Activity {

    private EditText et_searchBox;
    private Button btn_search;
    private Button btn_to_home;
    private Chip c_recog1;
    private Chip c_recog2;
    private Chip c_recog3;
    private Chip c_recog4;
    private Chip c_recog5;
    private Chip c_recog6;

    private List<String> recogList = new ArrayList<>();
    private String searchWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_plant);

        et_searchBox = (EditText) findViewById(R.id.et_searchBox);
        btn_search = (Button) findViewById(R.id.Button_SearchBtn);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWord = et_searchBox.getText().toString();
                clickButton(searchWord);
            }
        });

        recogList.add("민들레");
        recogList.add("소나무");
        recogList.add("강아지풀");
        recogList.add("해바라기");
        recogList.add("샤스타 데이지");
        recogList.add("우엉");

        c_recog1 = (Chip) findViewById(R.id.chip1);
        c_recog2 = (Chip) findViewById(R.id.chip2);
        c_recog3 = (Chip) findViewById(R.id.chip3);
        c_recog4 = (Chip) findViewById(R.id.chip4);
        c_recog5 = (Chip) findViewById(R.id.chip5);
        c_recog6 = (Chip) findViewById(R.id.chip6);

        c_recog1.setText(recogList.get(0));
        c_recog2.setText(recogList.get(1));
        c_recog3.setText(recogList.get(2));
        c_recog4.setText(recogList.get(3));
        c_recog5.setText(recogList.get(4));
        c_recog6.setText(recogList.get(5));

        c_recog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton(recogList.get(0)); }
        });
        c_recog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton(recogList.get(1)); }
        });
        c_recog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton(recogList.get(2)); }
        });
        c_recog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton(recogList.get(3)); }
        });
        c_recog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton(recogList.get(4)); }
        });
        c_recog6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clickButton(recogList.get(5)); }
        });

        btn_to_home = (Button) findViewById(R.id.btn_to_home);
        btn_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void clickButton(String searchWord) {
        Intent intent = new Intent(SearchPlantActivity.this, SearchResultActivity.class);
        intent.putExtra("searchWord", searchWord);
        increaseSearchNum(searchWord);
        startActivity(intent);
        finish();
    }
}

