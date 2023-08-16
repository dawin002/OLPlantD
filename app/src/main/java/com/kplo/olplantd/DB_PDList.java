package com.kplo.olplantd;

import java.util.ArrayList;
import java.util.List;

class DB_PDChild {
    private String nameKor;
    //    private String nameEng;
    public DB_PDList link;

    public DB_PDChild(){
        this.nameKor = null;
//        this.nameEng = null;
        this.link = null;
    }

    public DB_PDChild(String nameKor, /*String nameEng, */DB_PDList link){
        this.nameKor = nameKor;
//        this.nameEng = nameEng;
        this.link = link;
    }

    public String getName() {
        return this.nameKor;
    }
}

class DB_PDList {
    String listName;
    private List<DB_PDChild> children;

    public DB_PDList(String childName){
        children = new ArrayList<>();
        this.listName = childName;
    }

    public DB_PDList addChild(String childName/*, */){
        DB_PDList newChildList = new DB_PDList(childName);
        DB_PDChild newChild = new DB_PDChild(newChildList.listName, newChildList);
        this.children.add(newChild);
        return this;
    }


    public void makeTree(FilePDList file){
        while (file.fpdl_parent.contains(this.listName)) {
            int idx = file.fpdl_parent.indexOf(this.listName);
            if(idx != -1) {
                this.addChild(file.fpdl_child.get(idx));
                file.fpdl_parent.remove(idx);
                file.fpdl_child.remove(idx);

                this.getChild(this.children.size()-1).makeTree(file);
            }
        }
        return;
    }

    public DB_PDList getChild(int index){
        return this.children.get(index).link;
    }

    public DB_PDList getChild(String childName){
        for(int i=0; i<this.children.size(); i++){
            if(childName == this.getChildName(i)){
                return this.children.get(i).link;
            }
        }
        return null;
    }

    public int getSize(){
        return this.children.size();
    }

    public String getChildName(int index){
        return this.children.get(index).getName();
    }

}
