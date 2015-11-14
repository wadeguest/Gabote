package com.example.wade.gabote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/13/2015.
 */
public class playerHolder {
    private List<String> copyList = new ArrayList<String>();
    public playerHolder(){
    }
    public void setList(List<String> toBeCopied){
        this.copyList = new ArrayList<String>();
        this.copyList.addAll(toBeCopied);
    }
    public List<String> getList(){return this.copyList;}
    public void clearList(){
        copyList.clear();
    }
}