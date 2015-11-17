package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by Wade on 2015-11-11.
 */
public class AddPlayerController {
    protected AddPlayerController() {
    }

    protected void searchPlayers(Activity activity,ActiveSession userSession, String team, String position, String pName) {
        new GetData.addPlayerOps(activity,userSession, team, position, pName);
    }
}
