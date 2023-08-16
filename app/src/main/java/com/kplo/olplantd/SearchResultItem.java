package com.kplo.olplantd;

public class SearchResultItem {
    private String itemName;

    public SearchResultItem(String text){
        itemName = text;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName(){
        return itemName;
    }
}
