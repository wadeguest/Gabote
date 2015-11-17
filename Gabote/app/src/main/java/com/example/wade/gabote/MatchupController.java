package com.example.wade.gabote;

import android.app.Activity;

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
}
