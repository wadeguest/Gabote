package com.example.wade.gabote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FantasyMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fantasy_menu);
        fillFantasyMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fantasy_menu, menu);
        return true;
    }

    private void fillFantasyMenu(){
        ListView lv = (ListView)findViewById(R.id.fantasy_menu_list);
        String[] games = {"Matchup Scores", "View Current Active Line-up", "Draft Helper", "Best Team"};
        ArrayList<String> gameList = new ArrayList<String>();
        gameList.addAll(Arrays.asList(games));

        ArrayAdapter<String> la = new ArrayAdapter<String>(this,R.layout.rowdef,gameList);
        lv.setAdapter(la);
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
