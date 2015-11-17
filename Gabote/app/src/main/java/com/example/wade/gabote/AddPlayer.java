package com.example.wade.gabote;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Bundle b = getIntent().getExtras();
        final Activity activity = this;
        final ActiveSession userSesssion = new ActiveSession();
        userSesssion.setActiveUserId(b.getInt("userSession"));

        DrawerListController dlc = new DrawerListController(this, userSesssion);

        final Spinner pos = (Spinner)findViewById(R.id.spinnerPositions);
        final Spinner teams = (Spinner)findViewById(R.id.spinnerTeams);
        ArrayAdapter<CharSequence> AA_spinnerTeam = ArrayAdapter.createFromResource(this,R.array.spinnerTeamAbbr,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> AA_spinnerPos = ArrayAdapter.createFromResource(this,R.array.spinnerPositions,android.R.layout.simple_spinner_item);
        pos.setAdapter(AA_spinnerPos);
        teams.setAdapter(AA_spinnerTeam);
        Button btnSearchPlayer = (Button)findViewById(R.id.btnSearch);
        btnSearchPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pname = (EditText)findViewById(R.id.et_player_name);
                FacadeController fc = new FacadeController();
                fc.searchPlayers(activity,userSesssion,teams.getSelectedItem().toString(),pos.getSelectedItem().toString(),pname.getText().toString());
            }
        });
    }
}
