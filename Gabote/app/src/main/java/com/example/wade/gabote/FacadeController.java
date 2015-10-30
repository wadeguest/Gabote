package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by Wade on 2015-10-29.
 */
public class FacadeController {

    private Activity activity;
    private LoginController lc = new LoginController();
    public FacadeController(){
    }
    public void checkLoginUser(Activity activity,String user, String pass)
    {
        lc.checkLogin(activity,user,pass);
    }

}
