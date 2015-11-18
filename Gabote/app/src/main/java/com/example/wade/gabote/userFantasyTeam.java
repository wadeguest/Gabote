package com.example.wade.gabote;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class userFantasyTeam extends AppCompatActivity {

    FacadeController fc = new FacadeController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fantasy_team);
        final Activity activity =this;
        Bundle b = getIntent().getExtras();

        final ActiveSession userSession = new ActiveSession();
        userSession.setActiveUserId(b.getInt("userSession"));
        DrawerListController dlc = new DrawerListController(this,userSession);
        Button bAddPlayer = (Button)findViewById(R.id.bAddPlayer);
        Button bRefreshTeam = (Button)findViewById(R.id.bRefreshTeam);
        Button bEditSettings = (Button)findViewById(R.id.bEdit);
        bAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.UserTeamToAddPlayer(activity, userSession);
            }
        });
        bEditSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.teamToSettings(activity,userSession);
            }
        });
        bRefreshTeam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                activity.recreate();
            }
        });
        getTeam(userSession);
    }

    public void getTeam(ActiveSession userSession) {
        fc.getUserTeam(this,userSession);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_fantasy_team, menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
