package com.example.wade.gabote;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class DraftHelp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String item;
        String item2;
        int pos;
        final Activity activity = this;
        CurrPlayerList curr = new CurrPlayerList();
        playerHolder pH = new playerHolder();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draft_help);
        Bundle b = getIntent().getExtras();
        final ActiveSession userSesssion = new ActiveSession();
        userSesssion.setActiveUserId(b.getInt("userSession"));
        DrawerListController dlc = new DrawerListController(activity,userSesssion);
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
        dhOption.setOnItemSelectedListener(new spinnerValues(pH,curr,dhOption,dhPos));
        dhPos.setOnItemSelectedListener(new spinnerValues(pH,curr, dhOption, dhPos));
        Button addPlayer = (Button)findViewById(R.id.dhAddPlayer);
        addPlayer.setOnClickListener(new buttonListener(pH,curr,dhPos, "add"));
        Button repickPlayer = (Button)findViewById(R.id.dhRepick);
        repickPlayer.setOnClickListener(new buttonListener(pH,curr,dhPos, "repick"));
        Button vetoPlayer = (Button)findViewById(R.id.dhVeto);
        vetoPlayer.setOnClickListener(new buttonListener(pH,curr,dhPos, "veto"));


    }
    protected class spinnerValues implements AdapterView.OnItemSelectedListener {
        CurrPlayerList curr;
        playerHolder ph;
        public spinnerValues(playerHolder pH, CurrPlayerList curr, Spinner val1, Spinner val2){
            this.curr = curr;
            this.ph = pH;
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String temp;
            String temp2;
            int dPos;
            Button addPlayer = (Button)findViewById(R.id.dhAddPlayer);
            Button repickPlayer = (Button)findViewById(R.id.dhRepick);
            Button vetoPlayer = (Button)findViewById(R.id.dhVeto);
            Spinner type = (Spinner)findViewById(R.id.dhTypeOfDraft);
            Spinner posDraft = (Spinner)findViewById(R.id.dhPos);
            temp =  type.getSelectedItem().toString();
            temp2 = posDraft.getSelectedItem().toString();
            dPos = Integer.parseInt(temp2);
            if(temp.equals("Static Draft")){
                addPlayer.setEnabled(false);
                repickPlayer.setEnabled(false);
                vetoPlayer.setEnabled(false);
            }
            else
            {
                addPlayer.setEnabled(true);
                repickPlayer.setEnabled(true);
                vetoPlayer.setEnabled(true);
            }
            getDraftablePlayers(ph, curr, temp, dPos);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    protected class buttonListener implements AdapterView.OnClickListener {
        CurrPlayerList curr;
        playerHolder ph;
        String type;
        int pos;
        public buttonListener(playerHolder pH, CurrPlayerList curr, Spinner posDraft, String type){
            this.curr = curr;
            this.ph = pH;
            this.type = type;
            //Spinner posDraft = (Spinner)findViewById(R.id.dhPos);
            //this.pos = Integer.parseInt(posDraft.getSelectedItem().toString());
        }

        public void onClick(View v) {
            Spinner posDraft = (Spinner)findViewById(R.id.dhPos);
            this.pos = Integer.parseInt(posDraft.getSelectedItem().toString());
            addDraftablePlayer(this.ph, this.curr, this.type, this.pos);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_draft_help, menu);,
        return true;
    }
    public void getDraftablePlayers(playerHolder ph, CurrPlayerList curr, String typeOfDraft, int pos){
        FacadeController fc= new FacadeController();
        fc.getDraftablePlayers(this,ph, curr, typeOfDraft, pos);
    }
    public void addDraftablePlayer(playerHolder ph, CurrPlayerList curr, String type, int pos){
        FacadeController fc = new FacadeController();
        fc.addDraftablePlayer(this,ph,curr, type, pos, 1);
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
