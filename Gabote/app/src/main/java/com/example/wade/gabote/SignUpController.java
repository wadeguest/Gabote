package com.example.wade.gabote;

import android.app.Activity;

/**
 * Created by Wade on 2015-11-13.
 */
public class SignUpController {
        public SignUpController(){
        }
        protected void checkSignup(Activity activity, String username, String pass, String email)
        {
            new GetData.checkUserSignUp(activity,username,pass,email);
        }
}
