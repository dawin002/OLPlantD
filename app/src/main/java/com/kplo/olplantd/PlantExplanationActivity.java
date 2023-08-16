package com.kplo.olplantd;

import static com.kplo.olplantd.MainActivity.favList;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Activity;
import android.widget.Toast;

public class PlantExplanationActivity extends Activity {

    private TextView AppCompatTextView_Plant_Explan_Name;

    TextView TextView_sci;
    TextView TextView_spe;
    TextView TextView_gen;
    TextView TextView_fam;
    TextView TextView_ord;
    TextView TextView_cla;
    TextView TextView_phy;
    TextView TextView_bloom;
    TextView TextView_fruit;
    TextView TextView_flower_color;
    TextView TextView_tree;
    TextView TextView_stem;
    TextView TextView_leaf_nagi;
    TextView TextView_leaf_shape;

    ImageView imageView_picture;

    ImageButton btn_addFav;
    Button btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_explanation);
        PlantInit plant_show = new PlantInit();
        Intent intent = getIntent();
        String plant_name = intent.getStringExtra("plant_name");

        AppCompatTextView_Plant_Explan_Name = (TextView) findViewById(R.id.AppCompatTextView_Plant_Explan_Name);
        AppCompatTextView_Plant_Explan_Name.setText(plant_name);

        imageView_picture = (ImageView) findViewById(R.id.imageview_picture);

        TextView_sci = findViewById(R.id.TextView_sci);
        TextView_spe = findViewById(R.id.TextView_spe);
        TextView_gen = findViewById(R.id.TextView_gen);
        TextView_fam = findViewById(R.id.TextView_fam);
        TextView_ord = findViewById(R.id.TextView_ord);
        TextView_cla = findViewById(R.id.TextView_cla);
        TextView_phy = findViewById(R.id.TextView_phy);
        TextView_bloom = findViewById(R.id.TextView_bloom);
        TextView_fruit = findViewById(R.id.TextView_fruit);
        TextView_flower_color = findViewById(R.id.TextView_flower_color);
        TextView_tree = findViewById(R.id.TextView_tree);
        TextView_stem = findViewById(R.id.TextView_stem);
        TextView_leaf_nagi = findViewById(R.id.TextView_leaf_nagi);
        TextView_leaf_shape = findViewById(R.id.TextView_leaf_shape);

        for (int i = 0; i < 38; i++) {
            if (plant_name.equals(PlantInit.plantDB[i].getSciName())
                    || PlantInit.plantDB[i].getSciName().equals(plant_name+" ")) {
                TextView_sci.setText(PlantInit.plantDB[i].getSciName());
                TextView_spe.setText(PlantInit.plantDB[i].getClsSpe());
                TextView_gen.setText(PlantInit.plantDB[i].getClsGen());
                TextView_fam.setText(PlantInit.plantDB[i].getClsFam());
                TextView_ord.setText(PlantInit.plantDB[i].getClsOrd());
                TextView_cla.setText(PlantInit.plantDB[i].getClsCla());
                TextView_phy.setText(PlantInit.plantDB[i].getClsPhy());
                TextView_bloom.setText(PlantInit.plantDB[i].getBloom());
                TextView_fruit.setText(PlantInit.plantDB[i].getFruit());
                TextView_flower_color.setText(PlantInit.plantDB[i].getFlowerColor());
                TextView_tree.setText(PlantInit.plantDB[i].getTree());
                TextView_stem.setText(PlantInit.plantDB[i].getStem());
                TextView_leaf_nagi.setText(PlantInit.plantDB[i].getLeafNagi());
                TextView_leaf_shape.setText(PlantInit.plantDB[i].getLeafShape());
            }
        }
        btn_addFav = findViewById(R.id.btn_to_fav);
        btn_addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!favList.contains(plant_name))
                    favList.add(plant_name);
                Log.d("ITEM_ADDED_FAV :", plant_name);
                Toast myToast = Toast.makeText(getApplicationContext(),"즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        btn_home = findViewById(R.id.btn_to_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

