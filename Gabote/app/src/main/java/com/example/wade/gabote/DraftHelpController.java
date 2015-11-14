package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by chris on 11/8/2015.
 */
public class DraftHelpController {

    protected void getDraftablePlayers(Activity activity,playerHolder ph, CurrPlayerList curr, String typeOfDraft, int pos){
        new GetData.DraftHelpPlayers(activity,ph, curr, typeOfDraft, pos);
    }
    protected void addDraftablePlayer(Activity activity,playerHolder ph,CurrPlayerList curr, String typeOfControl, int pos, int flag){
        new GetData.DraftHelpPlayers(activity,ph,curr, typeOfControl, pos, flag);
    }
}
