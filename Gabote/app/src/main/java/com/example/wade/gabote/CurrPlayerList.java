package com.example.wade.gabote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 11/12/2015.
 */
public class CurrPlayerList {
private List<String> playerList;
    private int currRound;
    public CurrPlayerList(){
        currRound = 0;
    }
    public void setList(List<String> toBeCopied){
        this.playerList = new ArrayList<String>();
        this.playerList.addAll(toBeCopied);
    }
    public void updateList(){
        this.playerList.remove(0);
        currRound += 1;
    }
    public List<String> getList(){return this.playerList;}
    public void clearList(){
        playerList.clear();
    }
    public void setCurrRound(int i){
        this.currRound = i;
    }
    public int returnRound() {return this.currRound;}
}

