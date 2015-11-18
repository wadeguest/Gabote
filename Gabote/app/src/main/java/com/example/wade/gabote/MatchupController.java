package com.example.wade.gabote;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Wade on 2015-11-10.
 */
public class MatchupController {

    public MatchupController(){
    }
    protected void getUserPlayerPoints(Activity activity, ActiveSession userSession, int week)
    {
        new GetData.getUserPoints(activity,userSession,week);
    }
    protected void MatchupToTeam(Activity activity, ActiveSession userSession) {
        Intent i = new Intent(activity.getApplicationContext(), userFantasyTeam.class);
        i.putExtra("userSession", userSession.getActiveUserId());
        activity.startActivity(i);
    }
}
