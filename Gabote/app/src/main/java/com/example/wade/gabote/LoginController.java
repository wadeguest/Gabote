package com.example.wade.gabote;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Wade on 2015-10-29.
 */
public class LoginController {

    //USE AN EMPTY CONSTRUCTOR AS NO PARAMETERS ARE NEEDED
    public LoginController(){
    }

    //HANDLES THE LOGIN EVENT AND PASSES THE EVENT TO THE MODEL
    protected void checkLogin(Activity activity, String username, String pass, ActiveSession userSession)
    {
        new GetData.checkUserLogin(activity,username,pass, userSession);
    }

    //CREATE NEW ACCOUNT REQUIRES THE VIEW TO BE CHANGED TO THE UserSignUp ACTIVITY. THIS IS HANDLED BY THE CONTROLLER
    protected  void loginToSignup(Activity activity) {
        Intent i = new Intent(activity.getApplicationContext(), UserSignUp.class);
        activity.startActivity(i);
    }
}
