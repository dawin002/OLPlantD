package com.kplo.olplantd;

public class PlntQuestion {
    private String quLine;
    private String value;

    public PlntQuestion(String quLine, String value){
        this.quLine = quLine;
        this.value = value;
    }
    public String getQuLine(){
        return quLine;
    }
    public String getValue(){
        return  value;
    }
}
