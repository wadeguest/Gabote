package com.example.wade.gabote;

import android.app.Activity;
import android.widget.EditText;

/**
 * Created by Wade on 2015-11-15.
 */
public class EditTeamSettingsController {
    public EditTeamSettingsController() {

    }
    public void getPrevValues(Activity activity, ActiveSession userSession) {
        GetData.editTeamSettings ets = new GetData.editTeamSettings(activity,userSession);
        ets.updateValues();
    }
    public void setNewValues(Activity activity, ActiveSession userSession) {
        GetData.editTeamSettings ets = new GetData.editTeamSettings(activity,userSession);
        EditText team_name = (EditText)activity.findViewById(R.id.et_teamname);
        EditText team_email = (EditText)activity.findViewById(R.id.et_email);
        ets.setNewValues(team_email.getText().toString(), team_name.getText().toString());
    }
    public void changePassword(Activity activity, ActiveSession userSession, String oldPass, String newPass, String newPassConfirm) {
        GetData.editTeamSettings ets = new GetData.editTeamSettings(activity,userSession);
        ets.changePassword(oldPass,newPass,newPassConfirm);
    }
}
