package com.example.wade.gabote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditTeam extends AppCompatActivity {

    FacadeController fc = new FacadeController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);
        DrawerListController dlc = new DrawerListController();
        Bundle b = getIntent().getExtras();
        final ActiveSession userSession = new ActiveSession();
        userSession.setActiveUserId(b.getInt("userSession"));
        final Activity activity = this;
        fc.getPrevValues(this, userSession);

        Button btnConfirm = (Button)findViewById(R.id.btnConfirmChanges);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.setNewTeamSettings(activity,userSession);
            }
        });

        Button btnChangePassword = (Button)findViewById(R.id.btnChangePassword);
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(activity);
                View dialogView = inflater.inflate(R.layout.pass_dialog,null);

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(dialogView);
               // builder.setTitle("Reset Password");
                final EditText oldPass = (EditText) dialogView.findViewById(R.id.et_oldpass);
                final EditText newPass = (EditText) dialogView.findViewById(R.id.et_newPass);
                final EditText newPassConfirm = (EditText) dialogView.findViewById(R.id.et_confirmNewPass);
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fc.changePassword(activity,userSession,oldPass.getText().toString(),newPass.getText().toString(), newPassConfirm.getText().toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

    }
}
