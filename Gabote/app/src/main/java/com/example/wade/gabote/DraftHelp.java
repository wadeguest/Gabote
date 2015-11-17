package com.example.wade.gabote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DraftHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draft_help);
        //DrawerListController dla= new DrawerListController(this);
        Spinner dhOption = (Spinner)findViewById(R.id.dhTypeOfDraft);
        ArrayAdapter<CharSequence> adsp = ArrayAdapter.createFromResource(this,R.array.dhSpinner,android.R.layout.simple_spinner_item);
        adsp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dhOption.setAdapter(adsp);
        dhOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                getDraftablePlayers(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                getDraftablePlayers("Live Draft");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draft_help, menu);
        return true;
    }
    public void getDraftablePlayers(String typeOfDraft){
        FacadeController fc= new FacadeController();
        fc.getDraftablePlayers(this, typeOfDraft);
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
