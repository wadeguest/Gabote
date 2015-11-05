package com.example.wade.gabote;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GameScores extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scores);
        DrawerListController dla= new DrawerListController(this);
        Spinner wk = (Spinner)findViewById(R.id.weekDropDown);
        ArrayAdapter<CharSequence> adsp = ArrayAdapter.createFromResource(this,R.array.spinnerWeeks,android.R.layout.simple_spinner_item);
        adsp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        wk.setAdapter(adsp);
        wk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                displayGameScores(position + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                displayGameScores(1);
            }
        });

        displayGameScores(1);
}
    public void displayGameScores(int week){
        FacadeController fc= new FacadeController();
        fc.getGameScoreWeekData(this,week);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_scores, menu);
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
