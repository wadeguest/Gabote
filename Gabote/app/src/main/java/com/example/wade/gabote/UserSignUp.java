package com.example.wade.gabote;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class UserSignUp extends AppCompatActivity{

    FacadeController fc = new FacadeController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUser();
            }
        });


    }
    private void checkUser()
    {
        EditText user = (EditText)findViewById(R.id.et_username);
        EditText pass = (EditText)findViewById(R.id.et_userpass);
        EditText email= (EditText)findViewById(R.id.et_useremail);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog;
        if(user.getText().toString().equals("")) {
            builder.setTitle("Username Error")
                    .setMessage("Please Enter a Username")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            dialog = builder.create();
            dialog.show();
        } else if(email.getText().toString().equals("")) {
            builder.setTitle("Email error")
                    .setMessage("Please Enter a Email")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            dialog = builder.create();
            dialog.show();
        } else {
            fc.checkSignUp(this,user.getText().toString(),pass.getText().toString(),email.getText().toString());
        }
    }
}
