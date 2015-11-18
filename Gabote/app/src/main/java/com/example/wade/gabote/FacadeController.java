package com.example.wade.gabote;

import android.app.Activity;
import android.content.Intent;

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
    private MatchupController mc = new MatchupController();
    private AddPlayerController ac = new AddPlayerController();
    private SignUpController suc = new SignUpController();
    private EditTeamSettingsController etsc = new EditTeamSettingsController();
    private DraftHelpController dhc = new DraftHelpController();

    public FacadeController(){
    }
    public void checkLoginUser(Activity activity,String user, String pass, ActiveSession userSession)
    {
        lc.checkLogin(activity,user,pass, userSession);
    }
    public void loginToSignUp(Activity activity) {
        lc.loginToSignup(activity);
    }
    public void getUserTeam(Activity activity, ActiveSession userSession) {
        utc.displayUserTeam(activity, userSession);
    }
    public void teamToSettings(Activity activity, ActiveSession userSession) {
        utc.teamToSettings(activity, userSession);
    }
    public void UserTeamToAddPlayer(Activity activity, ActiveSession userSession) {
        Intent i = new Intent(activity.getApplicationContext(), AddPlayer.class);
        userSession.setActiveUserId(userSession.getActiveUserId());
        i.putExtra("userSession", userSession.getActiveUserId());
        activity.startActivity(i);
    }
    public void getGameScoreWeekData(Activity activity, int week) {
        gsc.getWeekData(activity, week);
    }
    public void getScoringSettings(Activity activity, ActiveSession userSession) {
        ssc.getScoringSettings(activity,userSession);
    }
    public void setScoringSettings(Activity activity, ActiveSession userSession) {
        ssc.setScoringSettings(activity, userSession);
    }
    public void getUserPlayerPoints(Activity activity, ActiveSession userSession, int week) {
        mc.getUserPlayerPoints(activity, userSession, week);
    }
    public void MatchupToTeam(Activity activity, ActiveSession userSession) {
        mc.MatchupToTeam(activity,userSession);
    }
    public void searchPlayers(Activity activity, ActiveSession userSession, String team, String position, String pname) {
        ac.searchPlayers(activity, userSession, team, position, pname);
    }
    public void checkSignUp(Activity activity, String username, String pass, String email) {
        suc.checkSignup(activity, username, pass, email);
    }
    public void getPrevValues(Activity activity, ActiveSession userSession) {
        etsc.getPrevValues(activity, userSession);
    }
    public void setNewTeamSettings(Activity activity, ActiveSession userSession) {
        etsc.setNewValues(activity, userSession);
    }
    public void changePassword(Activity activity, ActiveSession userSession, String oldPass, String newPass, String newPassConfirm) {
        etsc.changePassword(activity,userSession,oldPass,newPass,newPassConfirm);
    }
    public void getDraftablePlayers(Activity activity,playerHolder ph,CurrPlayerList curr, String typeOfDraft, int pos) {
        dhc.getDraftablePlayers(activity,ph,curr, typeOfDraft, pos);
    }
    public void addDraftablePlayer(Activity activity,playerHolder ph,CurrPlayerList curr, String typeOfControl, int pos, int flag) {
        dhc.addDraftablePlayer(activity,ph, curr, typeOfControl, pos, flag);
    }

}
