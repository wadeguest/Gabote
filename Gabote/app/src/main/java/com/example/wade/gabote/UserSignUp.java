package com.example.wade.gabote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class UserSignUp extends AppCompatActivity implements ResultListener{

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
    private boolean checkUser()
    {
        EditText user = (EditText)findViewById(R.id.editText3);
        EditText pass = (EditText)findViewById(R.id.editText4);
        EditText email= (EditText)findViewById(R.id.editText5);
        GetData.checkUserSignUp exists = new GetData.checkUserSignUp(this,
                user.getText().toString(),
                pass.getText().toString(),
                email.getText().toString());

        return false;
    }

    @Override
    public void onResultSuccess(ArrayList<String[]> result) {
        if (result.get(0)[0]=="test"){

        }
    }
}
