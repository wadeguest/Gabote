package com.example.wade.gabote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ScoringSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring_settings);
        Bundle b = getIntent().getExtras();
//        DrawerListController dla= new DrawerListController(this);
        final ActiveSession userSession = new ActiveSession();
        userSession.setActiveUserId(b.getInt("userSession"));
        FacadeController fc = new FacadeController();
        fc.getScoringSettings(this,userSession);
    }

}
