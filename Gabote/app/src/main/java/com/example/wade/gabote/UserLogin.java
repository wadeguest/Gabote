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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        final ActiveSession userSession = new ActiveSession();
        Button b = (Button)findViewById(R.id.bLogin);
        final Activity activity=this;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText)findViewById(R.id.usernameEmailField);
                EditText pass = (EditText)findViewById(R.id.passwordField);
                FacadeController fc = new FacadeController();
                fc.checkLoginUser(activity,user.getText().toString(),pass.getText().toString(), userSession);
            }
        });

    }



}
