package com.example.wade.gabote;

/**
 * Created by Wade on 2015-10-29.
 */
public class ActiveSession {
    private int activeUserId;
    public ActiveSession(){activeUserId=0;}
    public void setActiveUserId(int id){
        activeUserId=id;
    }
    public int getActiveUserId(){return activeUserId;}
}
