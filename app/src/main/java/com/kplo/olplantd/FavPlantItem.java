package com.kplo.olplantd;

public class FavPlantItem {
    private String itemName;

    public FavPlantItem(String text){
        itemName = text;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemName(){
        return itemName;
    }
}
