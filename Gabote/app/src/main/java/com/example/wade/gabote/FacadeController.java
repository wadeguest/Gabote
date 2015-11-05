package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by Wade on 2015-10-29.
 */
public class FacadeController {

    private Activity activity;
    private LoginController lc = new LoginController();
    private UserTeamController utc = new UserTeamController();
    private GameScoreController gsc = new GameScoreController();
    private DrawerListController dlc = new DrawerListController();
    public FacadeController(){
    }
    public void checkLoginUser(Activity activity,String user, String pass, ActiveSession userSession)
    {
        lc.checkLogin(activity,user,pass, userSession);
    }
    public void getUserTeam(Activity activity, ActiveSession userSession) {
        utc.displayUserTeam(activity, userSession);
    }
    public void getGameScoreWeekData(Activity activity, int week) {
        gsc.getWeekData(activity, week);
    }
    public void getDrawerList(Activity activity) {
        dlc = new DrawerListController(activity);
    }
}
