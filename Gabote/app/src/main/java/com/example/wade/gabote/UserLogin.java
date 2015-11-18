package com.example.wade.gabote;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserLogin extends AppCompatActivity {

    //ATTACH THE CONTROLLER TO THE VIEW
    FacadeController fc = new FacadeController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //BIND THE XML TO THIS JAVA FILE TO CREATE THE VIEW
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        final ActiveSession userSession = new ActiveSession();

        //GET THE BUTTONS
        Button b = (Button)findViewById(R.id.bLogin);
        Button bSignUp = (Button)findViewById(R.id.bNewAccount);

        final Activity activity=this;

        //WHEN THE CREATE NEW ACCOUNT BUTTON IS CLICKED
        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ON THIS USER GESTURE, PASS THE EVENT TO THE CONTROLLER
                fc.loginToSignUp(activity);
            }
        });

        //WHEN THE LOGIN BUTTON IS CLICKED
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET THE TEXT FIELDS
                EditText user = (EditText)findViewById(R.id.usernameEmailField);
                EditText pass = (EditText)findViewById(R.id.passwordField);

                //ON THE USER GESTURE, PASS THE EVENT TO THE CONTROLLER
                fc.checkLoginUser(activity,user.getText().toString(),pass.getText().toString(), userSession);
            }
        });

    }



}
