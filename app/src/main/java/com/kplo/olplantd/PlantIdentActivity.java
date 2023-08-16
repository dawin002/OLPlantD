package com.kplo.olplantd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlantIdentActivity extends AppCompatActivity {
    int MaxPlantNum = 39;
    TextView TextView_Plant_Ident;
    Button btn_yes;
    Button btn_no;
    Button btn_color_red, btn_color_org, btn_color_yellow, btn_color_green, btn_color_blue, btn_color_darkblue, btn_color_purple, btn_color_brown, btn_color_dark, btn_color_white;
    ConstraintLayout constraintLayout_button, constraintLayout_button_2;

    int seqnum =0;
    int seqnumMax = 11;
    int[]count = {0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0};
    public int plantresult(int [] count,int size){
        int temp;
        int index=0;
        temp = count[0];
        for (int i=0;i<size;i++){
            if (temp < count[i]){
                temp = count[i];
                index = i;
            }
        }
        return index;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_ident);
        PlantInit.initDB();
        Intent intent = new Intent(PlantIdentActivity.this, SuggestActivity.class);

        PlntQuestion[] askQues = new PlntQuestion[11];
        // intent 선언하기
        askQues[0] = new PlntQuestion("꽃이 폈습니까?","6 ");
        askQues[1] = new PlntQuestion("열매가 있습니까?","6 ");
        askQues[2] = new PlntQuestion("꽃의 색은 무엇입니까?","non ");
        askQues[3] = new PlntQuestion("나무입니까?","wood ");
        askQues[4] = new PlntQuestion("줄기에 털이 있습니까?","hair ");
        askQues[5] = new PlntQuestion("잎이 어긋나기 입니까?","auget ");
        askQues[6] = new PlntQuestion("잎의 모양이 부채모양입니까?","fan ");
        askQues[7] = new PlntQuestion("옆맥의 모양이 그물모양입니까?","net ");
        askQues[8] = new PlntQuestion("열매색은 무엇입니까?","non");
        askQues[9] = new PlntQuestion("잎가장자리는 톱니입니까?","sharp");
        askQues[10] = new PlntQuestion("잎끝은 뽀죡합니까?","sharp");
        btn_no = findViewById(R.id.btn_no);
        btn_yes = findViewById(R.id.btn_yes);
        btn_color_red = findViewById(R.id.btn_color_red);
        btn_color_org = findViewById(R.id.btn_color_org);
        btn_color_yellow = findViewById(R.id.btn_color_yellow);
        btn_color_green = findViewById(R.id.btn_color_green);
        btn_color_blue = findViewById(R.id.btn_color_blue);
        btn_color_darkblue = findViewById(R.id.btn_color_darkblue);
        btn_color_purple = findViewById(R.id.btn_color_purple);
        btn_color_brown = findViewById(R.id.btn_color_brown);
        btn_color_dark = findViewById(R.id.btn_color_dark);
        btn_color_white = findViewById(R.id.btn_color_white);

        constraintLayout_button = (ConstraintLayout) findViewById(R.id.constraintLayout_button);
        constraintLayout_button_2 = (ConstraintLayout) findViewById(R.id.constraintLayout_button_2);


        TextView_Plant_Ident = findViewById(R.id.TextView_Plant_Ident);
        TextView_Plant_Ident.setText(askQues[0].getQuLine());
//버튼 클릭시 yes no
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (seqnum){
                    case 0: for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getBloom().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 1:
                        for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getFruit().equals(askQues[seqnum].getValue())) count[i]++; }
                        constraintLayout_button.setVisibility(View.INVISIBLE);
                        constraintLayout_button_2.setVisibility(View.VISIBLE);
                        break;
                    case 2:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getFlowerColor().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 3:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getTree().equals(askQues[seqnum].getValue())) count[i]+=10; }
                        break;
                    case 4:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getStem().equals(askQues[seqnum].getValue())) count[i]+=2; }
                        break;
                    case 5:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getLeafNagi().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 6:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getLeafShape().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 7:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getLeafNerve().equals(askQues[seqnum].getValue())) count[i]++;}
                        constraintLayout_button.setVisibility(View.INVISIBLE);
                        constraintLayout_button_2.setVisibility(View.VISIBLE);
                        break;
                    case 9:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getLeafSide().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 10:for(int i=0;i<MaxPlantNum;i++){ if (PlantInit.plantDB[i].getLeafEnd().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                }

                seqnum ++;

                if (seqnum == seqnumMax){
                    intent.putExtra("plant_name", PlantInit.plantDB[plantresult(count,MaxPlantNum)].getSciName());
                    startActivity(intent); // 엑티비티이동
                    finish();
                }
                else
                    TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (seqnum){
                    case 0: for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getBloom().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 1:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getFruit().equals(askQues[seqnum].getValue())) count[i]++; }
                        constraintLayout_button.setVisibility(View.INVISIBLE);
                        constraintLayout_button_2.setVisibility(View.VISIBLE);
                        break;
                    case 2:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getFlowerColor().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 3:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getTree().equals(askQues[seqnum].getValue())) count[i] +=10; }
                        break;
                    case 4:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getStem().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 5:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getLeafNagi().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 6:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getLeafShape().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 7:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getLeafNerve().equals(askQues[seqnum].getValue())) count[i]++;}
                        constraintLayout_button.setVisibility(View.INVISIBLE);
                        constraintLayout_button_2.setVisibility(View.VISIBLE);
                        break;
                    case 9:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getLeafSide().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                    case 10:for(int i=0;i<MaxPlantNum;i++){ if (!PlantInit.plantDB[i].getLeafEnd().equals(askQues[seqnum].getValue())) count[i]++; }
                        break;
                }

                seqnum++;
                if (seqnum == seqnumMax){
                    intent.putExtra("plant_name", PlantInit.plantDB[plantresult(count,MaxPlantNum)].getSciName());
                    startActivity(intent); // 엑티비티이동
                    finish();
                }else
                    TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }

        });
        // 색버튼 클릭시
        btn_color_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("red ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("red ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_org.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("orange ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("orange ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("yellow ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("yellow ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("green ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("green ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("blue ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("blue ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_darkblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("darkblue ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("darkblue ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("purple ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("purple ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_brown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("brown ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("brown ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("dark ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("dark ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });

        btn_color_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (seqnum){
                    case 2:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFlowerColor().equals("white ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                    case 8:for(int i=0;i<MaxPlantNum;i++){if (PlantInit.plantDB[i].getFruitColor().equals("white ")) count[i]+=4;}
                        constraintLayout_button.setVisibility(View.VISIBLE);
                        constraintLayout_button_2.setVisibility(View.INVISIBLE);
                        break;
                }
                seqnum++;
                TextView_Plant_Ident.setText(askQues[seqnum].getQuLine());
            }
        });







    }
}