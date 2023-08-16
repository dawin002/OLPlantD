package com.kplo.olplantd;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TodayFlowerActivity extends Activity {

    private TextView tv_flwName;
    private TextView tv_flwWord1;
    private TextView tv_flwWord2;
    private TextView tv_flwWord3;
    private ImageView iv_flwImage;

    private String flwName;
    private String flwWord1;
    private String flwWord2;
    private String flwWord3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_flower);

        flwName = "무궁화";
        flwWord1 = "영원함";
        flwWord2 = "일편단심";
        flwWord3 = "아름다움";

        tv_flwName = (TextView) findViewById(R.id.tv_toflw_name);
        tv_flwWord1 = (TextView) findViewById(R.id.tv_toflw_word1);
        tv_flwWord2 = (TextView) findViewById(R.id.tv_toflw_word2);
        tv_flwWord3 = (TextView) findViewById(R.id.tv_toflw_word3);
        iv_flwImage = (ImageView) findViewById(R.id.tv_toflw_image);

        tv_flwName.setText(flwName);
        tv_flwWord1.setText(flwWord1);
        tv_flwWord2.setText(flwWord2);
        tv_flwWord3.setText(flwWord3);

        // iv_flwImage.setImageResource(R.drawable.~~temp~~);

        iv_flwImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TodayFlowerActivity.this, PlantExplanationActivity.class);
                intent.putExtra("plant_name", flwName);
                startActivity(intent);
                finish();
            }
        });
    }
}