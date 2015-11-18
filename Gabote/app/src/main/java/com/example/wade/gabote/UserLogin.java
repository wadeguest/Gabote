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

    FacadeController fc = new FacadeController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        final ActiveSession userSession = new ActiveSession();
        Button b = (Button)findViewById(R.id.bLogin);
        Button bSignUp = (Button)findViewById(R.id.bNewAccount);
        final Activity activity=this;
        bSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.loginToSignUp(activity);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText)findViewById(R.id.usernameEmailField);
                EditText pass = (EditText)findViewById(R.id.passwordField);

                fc.checkLoginUser(activity,user.getText().toString(),pass.getText().toString(), userSession);
            }
        });

    }



}
