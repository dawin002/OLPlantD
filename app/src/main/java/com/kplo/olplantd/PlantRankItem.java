package com.kplo.olplantd;

public class PlantRankItem {
    private String rankName;
    private String rankNum;
    private String rankMove;

    public PlantRankItem(String rankName, String rankNum, String rankMove){
        this.rankName = rankName;
        this.rankNum = rankNum;
        this.rankMove = rankMove;
    }

    public void setRankName(String itemName) {
        this.rankName = itemName;
    }
    public String getRankName(){
        return this.rankName;
    }
    public void setRankNum(String rankNum) {
        this.rankNum = rankNum;
    }
    public String getRankNum(){
        return this.rankNum;
    }
    public void setRankMove(String rankMove) {
        this.rankMove = rankMove;
    }
    public String getRankMove(){
        return this.rankMove;
    }
}
