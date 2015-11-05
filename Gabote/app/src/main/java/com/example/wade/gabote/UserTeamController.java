package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by Wade on 2015-11-01.
 */
public class UserTeamController {
    protected void displayUserTeam(Activity activity,ActiveSession userSession)
    {
        new GetData.UserTeam(activity,userSession);
    }
}
