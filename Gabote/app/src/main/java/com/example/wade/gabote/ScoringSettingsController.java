package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by Wade on 2015-11-07.
 */
public class ScoringSettingsController {
    public ScoringSettingsController(){
    }
    protected void getScoringSettings(Activity activity, ActiveSession userSession)
    {
        new GetData.getUserScoringSettings(activity,userSession);
    }
}
