package com.kplo.olplantd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlantRankAdapter extends BaseAdapter {
    private Context context;
    private List<PlantRankItem> listItem;

    private TextView tv_rankName;
    private TextView tv_rankNum;
    private TextView tv_rankMove;

    public PlantRankAdapter(Context context, ArrayList<PlantRankItem> listItem){
        this.context = context;
        this.listItem = listItem;
    }

    public void setListItem(ArrayList<PlantRankItem> listItem){
        this.listItem.clear();
        this.listItem = listItem;
    }
    public void addItem(PlantRankItem item){
        this.listItem.add(item);
    }
    public int getCount() {
        return this.listItem.size();
    }
    public PlantRankItem getItem(int i) {
        return this.listItem.get(i);
    }
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.plant_rank_listview_item, null);
            tv_rankName = (TextView) view.findViewById(R.id.tv_rankName);
            tv_rankNum = (TextView) view.findViewById(R.id.tv_rankNum);
            tv_rankMove = (TextView) view.findViewById(R.id.tv_rankMove);
        }
        tv_rankName.setText(listItem.get(position).getRankName());
        tv_rankNum.setText(listItem.get(position).getRankNum());
        tv_rankMove.setText(listItem.get(position).getRankMove());
        return view;
    }
}
