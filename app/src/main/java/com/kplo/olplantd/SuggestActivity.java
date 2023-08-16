package com.kplo.olplantd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class SuggestActivity extends Activity {

    TextView set_text;
    Button btn_yesp;
    Button btn_nop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        Intent intentgo = new Intent(SuggestActivity.this, PlantExplanationActivity.class);
        Intent intentback = new Intent(SuggestActivity.this, PlantIdentActivity.class);
        btn_yesp = findViewById(R.id.btn_yesp);
        btn_nop = findViewById(R.id.btn_nop);

        Intent intent = getIntent();
        String plant_name = intent.getStringExtra("plant_name");
        set_text = findViewById(R.id.set_text);
        set_text.setText(plant_name);

        btn_yesp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentgo.putExtra("plant_name",plant_name);
                startActivity(intentgo);
                finish();
            }
        });
        btn_nop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentback);
                finish();
            }
        });
    }
}