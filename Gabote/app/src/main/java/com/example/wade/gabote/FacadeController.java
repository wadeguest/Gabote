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
    private ScoringSettingsController ssc = new ScoringSettingsController();
    private DraftHelpController dhc = new DraftHelpController();

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
    public void getScoringSettings(Activity activity, ActiveSession userSession) {
        ssc.getScoringSettings(activity,userSession);
    }
    public void setScoringSettings(Activity activity, ActiveSession userSession) {
        ssc.setScoringSettings(activity, userSession);
    }
    public void getDraftablePlayers(Activity activity,playerHolder ph,CurrPlayerList curr, String typeOfDraft, int pos){
        dhc.getDraftablePlayers(activity,ph,curr, typeOfDraft, pos);
    }
    public void addDraftablePlayer(Activity activity,playerHolder ph,CurrPlayerList curr, String typeOfControl, int pos, int flag){
     dhc.addDraftablePlayer(activity,ph, curr, typeOfControl, pos, flag);
    }
}
