package com.example.wade.gabote;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ScoringSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring_settings);
        Bundle b = getIntent().getExtras();
        final ActiveSession userSession = new ActiveSession();
        final Activity activity = this;
        userSession.setActiveUserId(b.getInt("userSession"));
        DrawerListController dlc = new DrawerListController(activity,userSession);
        FacadeController fc = new FacadeController();
        fc.getScoringSettings(this,userSession);
        Button bSaveScoreSettings = (Button)findViewById(R.id.bSubmitSettings);
        bSaveScoreSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FacadeController fc = new FacadeController();
                fc.setScoringSettings(activity,userSession);
            }
        });
    }

}
