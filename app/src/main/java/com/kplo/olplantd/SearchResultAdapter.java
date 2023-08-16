package com.kplo.olplantd;

import static com.kplo.olplantd.MainActivity.favList;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultAdapter extends BaseAdapter {
    private Context context;
    private List<SearchResultItem> listItem;

    private TextView tv_itemName;
    private ImageButton btn_addFav;

    public SearchResultAdapter(Context context, ArrayList<SearchResultItem> listItem){
        this.context = context;
        this.listItem = listItem;
    }

    public void setListItem(ArrayList<SearchResultItem> listItem){
        this.listItem.clear();
        this.listItem = listItem;
    }
    public void addItem(SearchResultItem item){
        this.listItem.add(item);
    }
    public int getCount() {
        return this.listItem.size();
    }
    public SearchResultItem getItem(int i) {
        return this.listItem.get(i);
    }
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_search_list, null);
            tv_itemName = (TextView) view.findViewById(R.id.TextView_ResultListItem);
        }

        tv_itemName.setText(listItem.get(position).getItemName());

        btn_addFav = (ImageButton) view.findViewById(R.id.ImageButton_Fav_Plant);
        btn_addFav.requestFocus();
        btn_addFav.setFocusable(false);
        btn_addFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 즐겨찾기 지정
                if(!favList.contains(listItem.get(position).getItemName()))
                    favList.add(listItem.get(position).getItemName());
                Log.d("ITEM_ADDED_FAV :", listItem.get(position).getItemName());
                Toast myToast = Toast.makeText(context.getApplicationContext(),"즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });


        return view;
    }
}

