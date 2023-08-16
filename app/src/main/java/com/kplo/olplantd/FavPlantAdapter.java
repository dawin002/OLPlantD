package com.kplo.olplantd;

import static com.kplo.olplantd.MainActivity.favList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FavPlantAdapter extends BaseAdapter {
    private Context context;
    private List<FavPlantItem> listItem;

    private TextView tv_favPlant;
    private ImageButton btn_delItem;

    public FavPlantAdapter(Context context, ArrayList<FavPlantItem> listItem){
        this.context = context;
        this.listItem = listItem;
    }

    public void setListItem(ArrayList<FavPlantItem> listItem){
        this.listItem.clear();
        this.listItem = listItem;
    }
    public void addItem(FavPlantItem item){
        this.listItem.add(item);
    }
    public int getCount() {
        return this.listItem.size();
    }
    public FavPlantItem getItem(int i) {
        return this.listItem.get(i);
    }
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_search_list, null);
            tv_favPlant = (TextView) view.findViewById(R.id.TextView_ResultListItem);
        }
        tv_favPlant.setText(listItem.get(position).getItemName());

        btn_delItem = (ImageButton) view.findViewById(R.id.ImageButton_Fav_Plant);
        btn_delItem.requestFocus();
        btn_delItem.setFocusable(false);
        btn_delItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 즐겨찾기 관리
                while(favList.contains(listItem.get(position).getItemName()))
                    favList.remove(listItem.get(position).getItemName());
                Log.d("ITEM_REMOVED_FAV :", listItem.get(position).getItemName());
                Toast myToast = Toast.makeText(context.getApplicationContext(),
                        "즐겨찾기에서 삭제되었습니다.", Toast.LENGTH_SHORT);
                myToast.show();
                Intent intent = ((Activity)context).getIntent();
                ((Activity)context).finish(); //현재 액티비티 종료 실시
                ((Activity)context).startActivity(intent); //현재 액티비티 재실행 실시
            }
        });

        return view;
    }
}
