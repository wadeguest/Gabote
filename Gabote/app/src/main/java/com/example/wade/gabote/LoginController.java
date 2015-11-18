package com.example.wade.gabote;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Wade on 2015-10-29.
 */
public class LoginController {

    public LoginController(){
    }
    protected void checkLogin(Activity activity, String username, String pass, ActiveSession userSession)
    {
        new GetData.checkUserLogin(activity,username,pass, userSession);
    }
    protected  void loginToSignup(Activity activity) {
        Intent i = new Intent(activity.getApplicationContext(), UserSignUp.class);
        activity.startActivity(i);
    }
}
