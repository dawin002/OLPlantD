package com.kplo.olplantd;


class PlntData {
    private String sciName; //학명
    private String clsSpe;  //종명
    private String clsGen;  //속명
    private String clsFam;  //과명
    private String clsOrd;  //목명
    private String clsCla;  //강명
    private String clsPhy;  //문명
    private String bloom;    //개화기
    private String fruit;    //열매유뮤
    private String flowerColor;// 꽃색
    private String tree;  //목본초본
    private String stem;  //줄기
    private String leafNagi;  //잎나는 형태
    private String leafShape;  // 잎모양
    private String leafNerve;  //옆맥
    private String fruitColor; //열매색
    private String leafSide; //잎가장자리
    private String leafEnd; //잎끝

    // 생성자로 객체 초기화
    public PlntData(String sciName, String clsSpe, String clsGen, String clsFam, String clsOrd, String clsCla, String clsPhy, String bloom, String fruit, String flowerColor, String tree, String stem, String leafNagi, String leafShape,String leafNerve,String fruitColor,String leafSide,String leafEnd){
        this.sciName = sciName;
        this.clsSpe = clsSpe;
        this.clsGen = clsGen;
        this.clsFam = clsFam;
        this.clsOrd = clsOrd;
        this.clsCla = clsCla;
        this.clsPhy = clsPhy;
        this.bloom = bloom;
        this.fruit =fruit;
        this.flowerColor = flowerColor;
        this.tree = tree;
        this.stem = stem;
        this.leafNagi = leafNagi;
        this.leafShape = leafShape;
        this.leafNerve = leafNerve;
        this.fruitColor = fruitColor;
        this.leafSide = leafSide;
        this.leafEnd = leafEnd;
    }

    public String getSciName(){
        return sciName;
    }
    public String getClsSpe(){
        return clsSpe;
    }
    public String getClsGen(){
        return clsGen;
    }
    public String getClsFam(){
        return clsFam;
    }
    public String getClsOrd(){
        return clsOrd;
    }
    public String getClsCla(){
        return clsCla;
    }
    public String getClsPhy(){
        return clsPhy;
    }
    public String getBloom(){
        return bloom;
    }
    public String getFruit(){
        return fruit;
    }
    public String getFlowerColor(){
        return flowerColor;
    }
    public String getStem(){
        return stem;
    }
    public String getTree(){
        return tree;
    }
    public String getLeafNagi(){
        return leafNagi;
    }
    public String getLeafShape(){
        return leafShape;
    }
    public String getLeafNerve() {return leafNerve;}
    public String getFruitColor() {return fruitColor;}
    public String getLeafSide() {return leafSide;}
    public String getLeafEnd() {return leafEnd;}



}