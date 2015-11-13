package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by chris on 11/8/2015.
 */
public class DraftHelpController {

    protected void getDraftablePlayers(Activity activity, String typeOfDraft, int pos){
        new GetData.DraftHelpPlayers(activity, typeOfDraft, pos);
    }
}
