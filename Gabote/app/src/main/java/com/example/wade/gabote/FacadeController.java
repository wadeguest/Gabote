package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by Wade on 2015-10-29.
 */
public class FacadeController {

    private Activity activity;
    private LoginController lc = new LoginController();
    private UserTeamController utc = new UserTeamController();
    public FacadeController(){
    }
    public void checkLoginUser(Activity activity,String user, String pass, ActiveSession userSession)
    {
        lc.checkLogin(activity,user,pass, userSession);
    }
    public void getUserTeam(Activity activity, ActiveSession userSession) {
        utc.displayUserTeam(activity, userSession);
    }

}
