package com.kplo.olplantd;

import static com.kplo.olplantd.MainActivity.lweekRankList;
import static com.kplo.olplantd.MainActivity.rankList;

public class DB_PRank implements Comparable<DB_PRank> {
    private String name;
    private int searchNum;
    private int rankNum;
    private int rankChange;

    public DB_PRank(String name, int searchNum, int rankNum){
        this.name = name;
        this.searchNum = searchNum;
        this.rankNum = rankNum;
        this.rankChange = 0;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSearchNum(){
        return this.searchNum;
    }
    public void setSearchNum(int searchNum){
        this.searchNum = searchNum;
    }

    public int getRankNum() {
        return this.rankNum;
    }
    public void setRankNum(int rankNum) { this.rankNum = rankNum; }

    public int getRankChange() { return rankChange; }
    public void setRankChange(int rankChange) { this.rankChange = rankChange; }


    @Override
    public int compareTo(DB_PRank plant) {
        if (this.searchNum < plant.searchNum) {
            return -1;
        } else if (this.searchNum == plant.searchNum) {
            return 0;
        } else {
            return 1;
        }
    }


    public static void setTempRank(){
        rankList.add( new DB_PRank("해바라기", 4, 4));
        rankList.add( new DB_PRank("민들레", 2, 6));
        rankList.add( new DB_PRank("소나무", 3, 5));
        rankList.add( new DB_PRank("감나무", 1, 7));
        rankList.add( new DB_PRank("상수리나무", 10, 1));
        rankList.add( new DB_PRank("고목나무", 6, 2));
        rankList.add( new DB_PRank("무궁화", 5, 3));
    }
    public static void setLastWeekRank(){
        lweekRankList.add( new DB_PRank("해바라기", 4, 4));
        lweekRankList.add( new DB_PRank("민들레", 2, 6));
        lweekRankList.add( new DB_PRank("소나무", 3, 5));
        lweekRankList.add( new DB_PRank("감나무", 1, 7));
        lweekRankList.add( new DB_PRank("상수리나무", 10, 1));
        lweekRankList.add( new DB_PRank("고목나무", 6, 2));
        lweekRankList.add( new DB_PRank("무궁화", 5, 3));
    }
}