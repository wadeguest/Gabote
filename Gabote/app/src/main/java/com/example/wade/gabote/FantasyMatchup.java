package com.example.wade.gabote;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class FantasyMatchup extends AppCompatActivity {

    FacadeController fc = new FacadeController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fantasy_matchup);

        Bundle b = getIntent().getExtras();
        final ActiveSession userSession = new ActiveSession();
        final Activity activity = this;
        DrawerListController dlc = new DrawerListController(this, userSession);

        userSession.setActiveUserId(b.getInt("userSession"));


        final Spinner wkSpinner = (Spinner)findViewById(R.id.wkSpin);
        wkSpinner.setEnabled(false);
        wkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String weekStr = wkSpinner.getSelectedItem().toString().substring(wkSpinner.getSelectedItem().toString().length() - 2).trim();
                int week = Integer.parseInt(weekStr);
                fc.getUserPlayerPoints(activity, userSession, week);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button bEditTeam = (Button)activity.findViewById(R.id.bEditUserTeam);
        bEditTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity.getApplicationContext(), userFantasyTeam.class);
                i.putExtra("userSession", userSession.getActiveUserId());
                activity.startActivity(i);
            }
        });
        String weekStr =wkSpinner.getSelectedItem().toString().substring(wkSpinner.getSelectedItem().toString().length()-2).trim();
        int week =Integer.parseInt(weekStr);

        fc.getUserPlayerPoints(activity,userSession,week);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fantasy_matchup, menu);
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
