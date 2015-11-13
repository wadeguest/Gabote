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
        String item;
        String item2;
        int pos;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draft_help);
        //DrawerListController dla= new DrawerListController(this);
        Spinner dhOption = (Spinner)findViewById(R.id.dhTypeOfDraft);
        ArrayAdapter<CharSequence> adsp = ArrayAdapter.createFromResource(this,R.array.dhSpinner,android.R.layout.simple_spinner_item);
        adsp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dhOption.setAdapter(adsp);
        Spinner dhPos = (Spinner)findViewById(R.id.dhPos);
        ArrayAdapter<CharSequence> adI = ArrayAdapter.createFromResource(this,R.array.dpSpinner,android.R.layout.simple_spinner_item);
        adI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dhPos.setAdapter(adI);

        /*item = dhOption.getSelectedItem().toString();
        item2 = dhPos.getSelectedItem().toString();
        pos = Integer.parseInt(item2);
        getDraftablePlayers(item,pos);*/
        dhOption.setOnItemSelectedListener(new spinnerValues(dhOption,dhPos));
        dhPos.setOnItemSelectedListener(new spinnerValues(dhOption,dhPos));

    }
    protected class spinnerValues implements AdapterView.OnItemSelectedListener {
        public spinnerValues(Spinner val1, Spinner val2){

        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String temp;
            String temp2;
            int dPos;
            Spinner type = (Spinner)findViewById(R.id.dhTypeOfDraft);
            Spinner posDraft = (Spinner)findViewById(R.id.dhPos);
            temp =  type.getSelectedItem().toString();
            temp2 = posDraft.getSelectedItem().toString();
            dPos = Integer.parseInt(temp2);
            getDraftablePlayers(temp,dPos);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draft_help, menu);
        return true;
    }
    public void getDraftablePlayers(String typeOfDraft, int pos){
        FacadeController fc= new FacadeController();
        fc.getDraftablePlayers(this, typeOfDraft,pos);
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
