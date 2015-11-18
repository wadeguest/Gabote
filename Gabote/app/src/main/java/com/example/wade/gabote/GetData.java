package com.example.wade.gabote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import android.content.res.AssetManager;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import static java.lang.Math.*;
import com.example.wade.gabote.GameScores;

import javax.xml.transform.Result;

import static android.app.PendingIntent.getActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class GetData {
    protected GetData() {
        //Constructor
    }

    protected static class WeekDataTable implements ResultListener {

        //Column Variables
        private int[] gsis_id;
        private int[] gamekey;
        private String[] start_time;

        private String[] day_of_week;
        private int[] year;
        private String[] season_type;
        private char[] finished;
        private String[] home_team;
        private int[] home_score;
        private int[] home_score_q1;
        private int[] home_score_q2;
        private int[] home_score_q3;
        private int[] home_score_q4;
        private int[] home_score_q5;
        private int[] home_turnovers;
        private String[] away_team;
        private int[] away_score;
        private int[] away_score_q1;
        private int[] away_score_q2;
        private int[] away_score_q3;
        private int[] away_score_q4;
        private int[] away_score_q5;
        private int[] away_turnovers;
        private String[] time_inserted;
        private String[] time_updated;
        private int gameCount;
        private Activity activity;

        public WeekDataTable(int week, Activity activity) {
            this.activity = activity;
            gsis_id = new int[16];
            gamekey = new int[16];
            start_time = new String[16];
            //week
            day_of_week = new String[16];
            year = new int[16];
            season_type = new String[16];
            finished = new char[16];
            home_team = new String[16];
            home_score = new int[16];
            home_score_q1 = new int[16];
            home_score_q2 = new int[16];
            home_score_q3 = new int[16];
            home_score_q4 = new int[16];
            home_score_q5 = new int[16];
            home_turnovers = new int[16];
            away_team = new String[16];
            away_score = new int[16];
            away_score_q1 = new int[16];
            away_score_q2 = new int[16];
            away_score_q3 = new int[16];
            away_score_q4 = new int[16];
            away_score_q5 = new int[16];
            away_turnovers = new int[16];
            time_inserted = new String[16];
            time_updated = new String[16];
            gameCount = 0;

            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT * FROM game WHERE week=" + week + " AND season_year='2015' AND season_type='Regular' ORDER BY start_time");
        }

        public int[] getGsis_id() {
            return gsis_id;
        }

        public int[] getGameKey() {
            return gamekey;
        }

        public String[] getStart_time() {
            return start_time;
        }

        public String[] getDay_of_week() {
            return day_of_week;
        }

        public int[] getYear() {
            return year;
        }

        public String[] getSeason_type() {
            return season_type;
        }

        public char[] getFinished() {
            return finished;
        }

        public String[] getHome_team() {
            return home_team;
        }

        public int[] getHome_score() {
            return home_score;
        }

        public int[] getHome_score_q1() {
            return home_score_q1;
        }

        public int[] getHome_score_q2() {
            return home_score_q2;
        }

        public int[] getHome_score_q3() {
            return home_score_q3;
        }

        public int[] getHome_score_q4() {
            return home_score_q4;
        }

        public int[] getHome_score_q5() {
            return home_score_q5;
        }

        public int[] getHome_turnovers() {
            return home_turnovers;
        }

        public String[] getAway_team() {
            return away_team;
        }

        public int[] getAway_score() {
            return away_score;
        }

        public int[] getAway_score_q1() {
            return away_score_q1;
        }

        public int[] getAway_score_q2() {
            return away_score_q2;
        }

        public int[] getAway_score_q3() {
            return away_score_q3;
        }

        public int[] getAway_score_q4() {
            return away_score_q4;
        }

        public int[] getAway_score_q5() {
            return away_score_q5;
        }

        public int[] getAway_turnovers() {
            return away_turnovers;
        }

        public String[] getTime_inserted() {
            return time_inserted;
        }

        public String[] getTime_updated() {
            return time_updated;
        }

        public int getGame_count() {
            return gameCount;
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            for (int i = 0; i < result.size(); i++) {
                gsis_id[i] = Integer.parseInt(result.get(i)[0]);
                gamekey[i] = Integer.parseInt(result.get(i)[1]);
                start_time[i] = (result.get(i)[2]);
                //week
                day_of_week[i] = (result.get(i)[4]);
                year[i] = Integer.parseInt(result.get(i)[5]);
                season_type[i] = (result.get(i)[6]);
                finished[i] = (result.get(i)[7].charAt(0));
                home_team[i] = (result.get(i)[8]);
                home_score[i] = Integer.parseInt(result.get(i)[9]);
                home_score_q1[i] = Integer.parseInt(result.get(i)[10]);
                home_score_q2[i] = Integer.parseInt(result.get(i)[11]);
                home_score_q3[i] = Integer.parseInt(result.get(i)[12]);
                home_score_q4[i] = Integer.parseInt(result.get(i)[13]);
                home_score_q5[i] = Integer.parseInt(result.get(i)[14]);
                home_turnovers[i] = Integer.parseInt(result.get(i)[15]);
                away_team[i] = (result.get(i)[16]);
                away_score[i] = Integer.parseInt(result.get(i)[17]);
                away_score_q1[i] = Integer.parseInt(result.get(i)[18]);
                away_score_q2[i] = Integer.parseInt(result.get(i)[19]);
                away_score_q3[i] = Integer.parseInt(result.get(i)[20]);
                away_score_q4[i] = Integer.parseInt(result.get(i)[21]);
                away_score_q5[i] = Integer.parseInt(result.get(i)[22]);
                away_turnovers[i] = Integer.parseInt(result.get(i)[23]);
                time_inserted[i] = (result.get(i)[24]);
                time_updated[i] = (result.get(i)[25]);
            }
            gameCount = result.size();
            updateGameScoreView();
        }

        private String getFullTeamName(String acr) {
            switch (acr) {
                case "ARI":
                    return "ARI Cardinals";
                case "ATL":
                    return "ATL Falcons";
                case "BAL":
                    return "BAL Ravens";
                case "BUF":
                    return "BUF Bills";
                case "CAR":
                    return "CAR Panthers";
                case "CHI":
                    return "CHI Bears";
                case "CIN":
                    return "CIN Bengals";
                case "CLE":
                    return "CLE Browns";
                case "DAL":
                    return "DAL Cowboys";
                case "DEN":
                    return "DEN Broncos";
                case "DET":
                    return "DET Lions";
                case "GB":
                    return "GB Packers";
                case "HOU":
                    return "HOU Texans";
                case "IND":
                    return "IND Colts";
                case "JAC":
                    return "JAC Jaguars";
                case "KC":
                    return "KC Chiefs";
                case "MIA":
                    return "MIA Dolphins";
                case "MIN":
                    return "MIN Vikings";
                case "NE":
                    return "NEW Patriots";
                case "NO":
                    return "NO Saints";
                case "NYG":
                    return "NY Giants";
                case "NYJ":
                    return "NY Jets";
                case "OAK":
                    return "OAK Raiders";
                case "PHI":
                    return "PHI Eagles";
                case "PIT":
                    return "PIT Steelers";
                case "SD":
                    return "SD Chargers";
                case "SEA":
                    return "SEA Seahawks";
                case "SF":
                    return "SF 49ers";
                case "STL":
                    return "STL Rams";
                case "TB":
                    return "TB Buccaneers";
                case "TEN":
                    return "TEN Titans";
                case "WAS":
                    return "WAS Redskins";
                default:
                    return "Error";
            }
        }

        protected void updateGameScoreView() {
            ListView lv = (ListView) activity.findViewById(R.id.listView);
            ArrayList<String> gameList = new ArrayList<String>();

            String temp;
            for (int i = 0; i < getGame_count(); i++) {
                temp = "";
                temp += getFullTeamName(getHome_team()[i]) + ": " + getHome_score()[i];
                temp += "    ";
                temp += getFullTeamName(getAway_team()[i]) + ": " + getAway_score()[i];
                gameList.add(i, temp);
            }
            ArrayAdapter<String> la = new ArrayAdapter<String>(activity, R.layout.rowdef, gameList);

            lv.setAdapter(la);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(activity.getApplicationContext(), android.R.layout.select_dialog_singlechoice);
                    optionAdapter.add("View Details");
                    optionAdapter.add("View Chat Room");

                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Game Options");
                    builder.setItems(R.array.optionMenuItems, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                        @Override
                        public void onShow(DialogInterface dialog2) {

                        }
                    });
                    dialog.show();
                }
            });
        }
    }

    protected static class checkUserSignUp implements ResultListener {
        private String userName;
        private String email;
        private String password;
        private Activity activity;
        private boolean userExists;

        public checkUserSignUp(Activity activity, String userName, String email, String password) {
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.activity = activity;
            this.userExists =  false;

            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT * FROM t_user WHERE username='"+ userName +"' OR user_email='"+ email +"'");
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {

            if(result.size()>0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Information Error")
                        .setMessage("User with same username/email exists. Please retry.")
                        .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                if(!userExists) {
                    userExists = true;
                    GetNetworkConn task = new GetNetworkConn();
                    task.setOnResultsListener(this);
                    task.execute("INSERT INTO t_user VALUES('"+ userName +"','"+ password +"','" + email + "')");
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Success")
                            .setMessage("User sign-up successful!")
                            .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(activity.getApplicationContext(), UserLogin.class);
                                    activity.startActivity(i);
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        }
    }

    protected static class checkUserLogin implements ResultListener {
        private String username;
        private String password;
        private Activity activity;
        private ActiveSession userSession;

        //QUERY TO CHECK IF LOGIN INFORMATION IS CORRECT
        public checkUserLogin(Activity activity, String username, String password, ActiveSession userSession) {
            this.activity = activity;
            this.username = username;
            this.password = password;
            this.userSession = userSession;

            //SEND THE QUERY
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT user_id FROM t_user WHERE username='" + this.username + "' AND password='" + this.password + "'");
        }

        //THE onResultSuccess FUNCTION HANDLES THE RETURN OF THE QUERY
        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            //UPDATE THE VIEW
            if (result.size() == 1) {
                Intent i = new Intent(activity.getApplicationContext(), userFantasyTeam.class);
                userSession.setActiveUserId(Integer.parseInt(result.get(0)[0]));
                i.putExtra("userSession", userSession.getActiveUserId());
                activity.startActivity(i);
            } else {
                final ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(activity.getApplicationContext(), android.R.layout.select_dialog_singlechoice);
                optionAdapter.add("Login Failed.");

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Invalid Login");
                builder.setMessage("Please enter correct account information.");
                builder.setPositiveButton("Hide", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog2) {

                    }
                });
                dialog.show();
            }
        }
    }

    protected static class UserTeam implements ResultListener {
        Activity activity;
        private String[] p_first_name;
        private String[] p_last_name;
        private String[] p_position;
        private String[] p_team;
        private String[] p_id;
        private String[] p_status;

        public UserTeam(Activity activity, ActiveSession userSession,int mode) {
            if(mode==1) {
                this.activity = activity;
                this.p_first_name = new String[50];
                this.p_last_name = new String[50];
                this.p_position = new String[50];
                this.p_team = new String[50];
                this.p_id = new String[50];
                this.p_status = new String[50];

                GetNetworkConn task = new GetNetworkConn();
                task.setOnResultsListener(this);
                task.execute("SELECT P.first_name, P.last_name, P.position,P.team, P.player_id, U.user_id, TU.fantasy_team_name, P.status FROM player P, user_player U, t_user TU WHERE U.user_id='" + userSession.getActiveUserId() + "' AND U.player_id=P.player_id AND TU.user_id=" + userSession.getActiveUserId());
            } else {
                Intent i = new Intent(activity.getApplicationContext(), EditTeam.class);
                i.putExtra("userSession", userSession.getActiveUserId());
                activity.startActivity(i);
            }
        }

        private String getAbbrStatus(String longStatus) {
            String abbrStatus;
            switch(longStatus) {
                case "InjuredReserve" :
                    abbrStatus="IR";
                    break;
                case "PUP":
                    abbrStatus="PUP";
                    break;
                case "Active":
                    abbrStatus="ACT";
                    break;
                default:
                    abbrStatus="UNK";
            }
            return abbrStatus;
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            for (int i = 0; i < result.size(); i++) {
                p_first_name[i] = result.get(i)[0];
                p_last_name[i] = result.get(i)[1];
                p_position[i] = result.get(i)[2];
                p_team[i] = result.get(i)[3];
                p_id[i] = result.get(i)[4];
                p_status[i] = getAbbrStatus(result.get(i)[7]);
            }
            TableLayout tl = (TableLayout) activity.findViewById(R.id.teamPlayerTable);
            //     tl.setBackgroundColor(Color.BLACK);
            ArrayList<String> userPlayerList = new ArrayList<String>();
            TextView teamName = (TextView)activity.findViewById(R.id.userTeamName);
            teamName.setText(result.get(0)[6]);
            String temp;
            boolean firstRun = false;
            for (int i = 0; i < result.size(); i++) {
                TableLayout.LayoutParams lp = new TableLayout.LayoutParams();
                TableRow tr = new TableRow(activity);
                lp.setMargins(25, 0, 0, 0);
                tr.setLayoutParams(lp);


                if (i % 2 == 0) {
                    //      tr.setBackgroundColor(Color.GRAY);
                } else {
                    //      tr.setBackgroundColor(Color.WHITE);
                }
                //  tr.setBackgroundResource(R.drawable.table_borders);

                if (!firstRun) {
                    TextView ch1 = new TextView(activity);
                    TextView ch2 = new TextView(activity);
                    TextView ch3 = new TextView(activity);
                    TextView ch4 = new TextView(activity);

                    ch1.setText("POSITION");
                    ch2.setText("PLAYER NAME");
                    ch3.setText("TEAM");
                    ch4.setText("STATUS");
                    ch1.setGravity(Gravity.CENTER);
                    ch2.setGravity(Gravity.CENTER);
                    ch3.setGravity(Gravity.CENTER);
                    ch4.setGravity(Gravity.CENTER);

                    tr.addView(ch1);
                    tr.addView(ch2);
                    tr.addView(ch3);
                    tr.addView(ch4);
                    firstRun = true;
                    i--;
                } else {
                    TextView posTV = new TextView(activity);
                    posTV.setText(p_position[i].toString());
                    posTV.setGravity(Gravity.CENTER);
                    posTV.setBackgroundResource(R.drawable.cell_borders);
                    tr.addView(posTV);

                    TextView nameTV = new TextView(activity);
                    nameTV.setText(p_first_name[i].toString() + " " + p_last_name[i].toString());
                    nameTV.setGravity(Gravity.CENTER);
                    posTV.setBackgroundResource(R.drawable.cell_borders);
                    tr.addView(nameTV);

                    TextView tmTV = new TextView(activity);
                    tmTV.setText(p_team[i].toString());
                    tmTV.setGravity(Gravity.CENTER);
                    posTV.setBackgroundResource(R.drawable.cell_borders);
                    tr.addView(tmTV);

                    TextView stTV = new TextView(activity);
                    stTV.setText(p_status[i].toString());
                    stTV.setGravity(Gravity.CENTER);
                    posTV.setBackgroundResource(R.drawable.cell_borders);
                    tr.addView(stTV);

                    Button rm = new Button(activity);
                    rm.setGravity(Gravity.CENTER);
                    rm.setText("Remove");
                    rm.setTextColor(Color.BLACK);
                    rm.setOnClickListener(new RemoveOnClick(Integer.parseInt(result.get(i)[5]), result.get(i)[4], result.get(i)[0] + " " + result.get(i)[1], activity));
                    tr.addView(rm);
                }
                if (tr.getParent() != null)
                    ((ViewGroup) tr.getParent()).removeView(tr);

                tl.addView(tr, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            ArrayAdapter<String> la = new ArrayAdapter<String>(activity, R.layout.rowdef, userPlayerList);
        }
        private class RemoveOnClick implements View.OnClickListener, ResultListener {
            int uid;
            String pid;
            String pname;
            Activity activity;
            final RemoveOnClick listener;

            public RemoveOnClick(int uid, String pid, String pname, Activity activity) {
                this.uid = uid;
                this.pid = pid;
                this.pname = pname;
                this.activity = activity;
                this.listener = this;
            }

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);

                builder.setMessage("Are you sure you wish to remove " + pname + " from your team?")
                        .setTitle("Confirm Remove")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                GetNetworkConn task = new GetNetworkConn();
                                task.setOnResultsListener(listener);
                                task.execute("DELETE FROM user_player WHERE user_id="+ uid +" AND player_id='"+ pid +"'");
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onResultSuccess(ArrayList<String[]> result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Player Removed")
                        .setMessage(pname + " removed from team")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }
    }

    protected static class DraftHelpPlayers implements ResultListener {
        Activity activity;
        String typeOfDraft;
        List<String> holderForPlayer = new ArrayList<String>();

        List<String> draftingStrat;
        List<player> playerDetails;
        List<Integer> draftPosition = new ArrayList<Integer>();
        List<String> finalList = new ArrayList<String>();
        private final int roundSize = 15;
        private int draftPos;
        CurrPlayerList currList;
        playerHolder ph;

        public List<String> readAllLines(Activity activity,String path) {
            List<String> mLines = new ArrayList<>();

            AssetManager am = activity.getAssets();

            try {
                InputStream is = am.open(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;

                while ((line = reader.readLine()) != null)
                    mLines.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return mLines;
        }
        public void parseAndUpdate(List<String> lines){
            String name;
            String temp;
            int charFound;
            int spaceFound;
            double adp;
            int adp_DB;
            boolean defense = false;
            for(int i = 0; i < lines.size(); i++){
                if(i == 9){
                    i = 9;
                }
                try {
                    name = lines.get(i);
                    temp = name;
                    charFound = name.indexOf(",");
                    if(charFound == -1){
                        // no team, player has been cut from current team.  No need to to draft a player without a team
                        // or defense team.  See case below if defense
                        if(name.contains("Defense")){
                            defense = true;
                        }else{
                            defense = false;
                            continue;
                        }

                    }
                    if(defense){
                        spaceFound = name.indexOf('\t');
                        charFound = name.indexOf("Defense");
                        name = name.substring(spaceFound,charFound + 7);
                        defense = false;
                    }else {
                        spaceFound = name.indexOf('\t');
                        name = name.substring(spaceFound, charFound - 3);
                    }
                    if(name.indexOf("'")!= -1){
                        name = name.replace("'","''");
                    }
                    name = name.trim();
                    temp = temp.replace(name, "");
                    charFound = temp.indexOf(".");
                    temp = temp.substring(charFound - 3, charFound + 2);
                    spaceFound = temp.indexOf('\t');
                    if(spaceFound == -1){
                        //player has a adp of 3 digits. (>99)
                        spaceFound = 0;
                    }
                    charFound = temp.indexOf(".");
                    temp = temp.substring(spaceFound, charFound + 2);
                    temp = temp.trim();
                    adp = Double.parseDouble(temp);
                    adp_DB = (int) Math.round(adp);

                    GetNetworkConn task = new GetNetworkConn();
                    task.setOnResultsListener(this);
                    task.execute("UPDATE player set adp = " + adp_DB + " WHERE full_name = '" + name + "' AND team != 'UNK'");
                }catch (Exception e){
                    int j = 0;
                }
            }
        }
        public DraftHelpPlayers(Activity activity,playerHolder ph, CurrPlayerList curr, String typeOfDraft, int pos) {
            this.activity = activity;
            this.typeOfDraft = typeOfDraft;
            this.currList = curr;
            this.ph = ph;
            this.currList.setCurrRound(0);
            //lines = readAllLines(activity,"adp.txt");
            //parseAndUpdate(lines);
            loadVals(pos);
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT * FROM player WHERE team != 'UNK' and status = 'Active' and adp != -1 order by adp asc");
            //buildList();
        }
        public DraftHelpPlayers(Activity activity, playerHolder ph,CurrPlayerList curr, String typeOfControl, int pos, int flag){
            this.activity = activity;
            String temp;
            temp = typeOfControl;
            this.currList = curr;
            this.ph = ph;
            loadVals(pos);
            if(typeOfControl.equals("add")){
                addPlayerButtonCalled();
            }
            else if(typeOfControl.equals("repick")){
                repickOrVetoButtonCalled();
            }
            else if(typeOfControl.equals("veto")){
                repickOrVetoButtonCalled();
            }
        }
        public void addPlayerButtonCalled(){
            List<String> It = new ArrayList<String>();
            It = this.currList.getList();
            int i = this.currList.returnRound();
            if(It.size() <= 0){

                return;
            }else {

                //It.remove(0);
                //this.currList.clearList();
                //this.currList.setList(It);
                this.currList.updateList();
                It = this.currList.getList();
                //this.currList.setCurrRound(i++);
                updateLV(It);
                if(It.size() == 0){
                    new AlertDialog.Builder(activity)
                            .setTitle("Draft Complete")
                            .setMessage("Gabote wishes you the best of luck in the upcoming season!")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setIcon(android.R.drawable.dialog_holo_dark_frame)
                            .show();
                }
            }
        }
        public void repickOrVetoButtonCalled(){
            List<String> repickList = new ArrayList<String>();
            List<String> It = new ArrayList<String>();
            String personToRemove;
            String fullName;
            String position;
            int adp;
            String tempADP;
            String team;
            String holder;
            int index;
            playerDetails = new ArrayList<player>();
            It = this.currList.getList();
            personToRemove = It.get(0);
            index = personToRemove.indexOf(",");
            personToRemove = personToRemove.substring(0, index);
            repickList = ph.getList();
            for(int i = 0; i < repickList.size(); i++){
                try {
                    if (repickList.get(i).contains(personToRemove)) {
                        repickList.remove(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    i = i;
                }
            }
            // playerDetails.clear();
            holderForPlayer.clear();
            String temp;
            player p;
            holder = "";
            //temp = "";

            for (int i = 0; i < repickList.size(); i++) {
                temp = repickList.get(i);
                // fullName = temp;
                index = temp.indexOf(",");
                fullName = temp.substring(0, index);
                fullName.trim();
                temp = temp.replace(fullName + ",", "");
                index = temp.indexOf(",");
                position = temp.substring(0, index);
                position.trim();
                temp = temp.replace(position + ",", "");
                index = temp.indexOf(",");
                tempADP = temp.substring(0, index);
                temp = temp.replace(tempADP + ",", "");
                tempADP.trim();
                adp = Integer.parseInt(tempADP);
                team = temp;
                holder += fullName + "," + position + "," + tempADP + "," + team;
                holderForPlayer.add(holder);
                p = new player(fullName,position,adp,team);
                playerDetails.add(p);
                holder = "";
            }
            temp = "";
            ph.clearList();
            ph.setList(holderForPlayer);
            buildList();
        }
        public void loadVals(int position){
            int mult;
            int placeHolder = -1;
            this.draftingStrat = new ArrayList<String>();
            if(position > 0 && position <=4) {
                draftingStrat.add("RB");
                draftingStrat.add("RB");
                draftingStrat.add("WR");
                draftingStrat.add("WR");
                draftingStrat.add("WR");
                draftingStrat.add("RB");
                draftingStrat.add("QB");
                draftingStrat.add("WR");
                draftingStrat.add("TE");
                draftingStrat.add("QB");
                draftingStrat.add("RB");
                draftingStrat.add("WR");
                draftingStrat.add("WR");
                draftingStrat.add("DEF");
                draftingStrat.add("K");
            }
            else if(position > 4 && position <=8) {

                draftingStrat.add("RB");
                draftingStrat.add("WR");
                draftingStrat.add("WR");
                draftingStrat.add("RB");
                draftingStrat.add("WR");
                draftingStrat.add("RB");
                draftingStrat.add("QB");
                draftingStrat.add("WR");
                draftingStrat.add("TE");
                draftingStrat.add("WR");
                draftingStrat.add("QB");
                draftingStrat.add("RB");
                draftingStrat.add("WR");
                draftingStrat.add("DEF");
                draftingStrat.add("K");
            }
            else {
                draftingStrat.add("WR");
                draftingStrat.add("WR");
                draftingStrat.add("RB");
                draftingStrat.add("RB");
                draftingStrat.add("WR");
                draftingStrat.add("RB");
                draftingStrat.add("QB");
                draftingStrat.add("RB");
                draftingStrat.add("TE");
                draftingStrat.add("RB");
                draftingStrat.add("WR");
                draftingStrat.add("QB");
                draftingStrat.add("WR");
                draftingStrat.add("DEF");
                draftingStrat.add("K");
            }
            draftPosition.add(1);
            draftPosition.add(24);
            draftPosition.add(25);
            draftPosition.add(48);
            draftPosition.add(49);
            draftPosition.add(72);
            draftPosition.add(73);
            draftPosition.add(96);
            draftPosition.add(97);
            draftPosition.add(120);
            draftPosition.add(121);
            draftPosition.add(144);
            draftPosition.add(145);
            draftPosition.add(168);
            draftPosition.add(169);
            mult = position - 1;
            if(position > 1){
                for(int i = 0; i < draftPosition.size(); i++){
                    if((i%2)==0) {
                        // add mult
                        placeHolder = draftPosition.get(i);
                        placeHolder = placeHolder + mult;
                        draftPosition.set(i, placeHolder);
                    }
                    else {
                        // minus mult
                        placeHolder = draftPosition.get(i);
                        placeHolder = placeHolder - mult;
                        draftPosition.set(i, placeHolder);
                    }
                }
            }

        }
        public void buildList(){
            String positionStrat;
            int currDraftPos;
            player p;
            String temp;
            int round = currList.returnRound();

            for(int i = round; i < roundSize; i++){
                temp = "";
                if(i == 13){
                    Random rn = new Random();
                    int answer = rn.nextInt(4) + 1;
                    if(answer == 1){
                        temp = "BRONCOS DST";
                    }
                    else if(answer == 2){
                        temp = "SEAHAWKS DST";
                    }
                    else if(answer == 3){
                        temp = "CARDINALS DST";
                    }
                    else if(answer == 4){
                        temp = "RAMS DST";
                    }
                    temp += " - Round 14";
                    finalList.add(temp);
                    continue;
                }
                positionStrat = draftingStrat.get(i);
                currDraftPos = draftPosition.get(i);
                p = retPlayer(positionStrat, currDraftPos);
                temp += p.full_name;
                temp += ", ";
                temp += p.position;
                temp += ", ";
                temp += p.team;
                temp += " - ";
                temp += "Round " + (i+1);
                finalList.add(temp);
            }
            this.currList.setList(finalList);
            updateLV(finalList);

        }
        public player retPlayer(String posDraft, int adpDraft){
            player item;
            String pos;
            int adpHolder;
            int bestPos;

            bestPos = closest(adpDraft, posDraft);
            item = playerDetails.get(bestPos);
            playerDetails.remove(bestPos);
            return item;
        }
        public void updateLV(List<String> list){
            ListView lv = (ListView) activity.findViewById(R.id.dhPlayerList);
            ArrayAdapter<String> la = new ArrayAdapter<String>(activity, R.layout.rowdef, list);
            lv.setAdapter(la);
            la.notifyDataSetChanged();
        }
        /*
        Taken from: http://stackoverflow.com/questions/1187352/find-closest-value-in-an-ordererd-list
        username: DFA
        Link to username: http://stackoverflow.com/users/89266/dfa
        Modified algorithm made by:  Chris Richards 11/12/2015
         */
        public int closest(int of, String posDraft) {
            int min = Integer.MAX_VALUE;
            int closest = of;
            int closestADP;
            for (int i = 0; i < playerDetails.size(); i ++) {
                if(!(playerDetails.get(i).position.equals(posDraft))){
                    continue;
                }
                final int diff = Math.abs(playerDetails.get(i).adp - of);

                if (diff < min) {
                    min = diff;
                    closest = i;
                }
            }

            return closest;
        }
        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            playerDetails = new ArrayList<player>();

            String temp;
            int tempADP;
            player p;
            for (int i = 0; i < result.size(); i++) {
                temp = "";
                temp += result.get(i)[2] +","+ result.get(i)[6] +","+ result.get(i)[16] +","+ result.get(i)[5];
                holderForPlayer.add(temp);
                tempADP = Integer.parseInt(result.get(i)[16]);
                p = new player(result.get(i)[2],result.get(i)[6],tempADP,result.get(i)[5]);
                playerDetails.add(p);
            }
            ph.setList(holderForPlayer);
            buildList();
        }

    }
    public static class player {
        public String full_name;
        public String position;
        public int adp;
        public String team;
        public player(String f, String p, int a, String t){
            this.full_name = f;
            this.position = p;
            this.adp = a;
            this.team = t;
        }
    }

    protected static class UserScoringSettings implements ResultListener {
        private ActiveSession userSession;
        private Activity activity;
        private boolean exists;
        private int mode;
        private double p_yds;
        private int p_td;
        private int p_int;
        private double ru_yds;
        private int ru_td;
        private double re_yds;
        private int re_td;
        private int two_pt_conv;
        private int fumble_lost;
        private int k_pat;
        private int fg_0;
        private int fg_20;
        private int fg_30;
        private int fg_40;
        private int fg_50;
        private int off_fumble_td;
        private int def_sack;
        private int def_int;
        private int def_fumble_rec;
        private int def_safety;
        private int def_td;
        private int def_k_p_td;
        private int def_ptall_0;
        private int def_ptall_1;
        private int def_ptall_7;
        private int def_ptall_14;
        private int def_ptall_21;
        private int def_ptall_28;
        private int def_ptall_35;

        public UserScoringSettings(Activity activity, ActiveSession userSession, int mode) {
            this.activity = activity;
            this.userSession = userSession;
            p_yds = 0;
            p_td = 0;
            p_int = 0;
            ru_yds = 0;
            ru_td = 0;
            re_yds = 0;
            re_td = 0;
            two_pt_conv = 0;
            fumble_lost = 0;
            k_pat = 0;
            fg_0 = 0;
            fg_20 = 0;
            fg_30 = 0;
            fg_40 = 0;
            fg_50 = 0;
            off_fumble_td = 0;
            def_sack = 0;
            def_int = 0;
            def_fumble_rec = 0;
            def_safety = 0;
            def_td = 0;
            def_k_p_td = 0;
            def_ptall_0 = 0;
            def_ptall_1 = 0;
            def_ptall_7 = 0;
            def_ptall_14 = 0;
            def_ptall_21 = 0;
            def_ptall_28 = 0;
            def_ptall_35 = 0;
            this.mode = mode;
            this.exists = false;
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);

            if (mode == 1) {
                task.execute("SELECT * FROM t_user_scoring, t_user U WHERE U.user_id='" + userSession.getActiveUserId() + "'");
            } else if (mode == 2) {
                String SQL = updateScoringSettings();
                task.execute(SQL);
            }
        }

        public void setP_yds(double x) {
            p_yds = x;
        }

        public void setP_td(int x) {
            p_td = x;
        }

        public void setP_int(int x) {
            p_int = x;
        }

        public void setRu_yds(double x) {
            ru_yds = x;
        }

        public void setRu_td(int x) {
            ru_td = x;
        }

        public void setRe_yds(double x) {
            re_yds = x;
        }

        public void setRe_td(int x) {
            re_td = x;
        }

        public void setTwo_pt_conv(int x) {
            two_pt_conv = x;
        }

        public void setFumble_lost(int x) {
            fumble_lost = x;
        }

        public void setK_pat(int x) {
            k_pat = x;
        }

        public void setFg_0(int x) {
            fg_0 = x;
        }

        public void setFg_20(int x) {
            fg_20 = x;
        }

        public void setFg_30(int x) {
            fg_30 = x;
        }

        public void setFg_40(int x) {
            fg_40 = x;
        }

        public void setFg_50(int x) {
            fg_50 = x;
        }

        public void setOff_fumble_td(int x) {
            off_fumble_td = x;
        }

        public void setDef_sack(int x) {
            def_sack = x;
        }

        public void setDef_int(int x) {
            def_int = x;
        }

        public void setDef_fumble_rec(int x) {
            def_fumble_rec = x;
        }

        public void setDef_safety(int x) {
            def_safety = x;
        }

        public void setDef_td(int x) {
            def_td = x;
        }

        public void setDef_k_p_td(int x) {
            def_k_p_td = x;
        }

        public void setDef_ptall_0(int x) {
            def_ptall_0 = x;
        }

        public void setDef_ptall_1(int x) {
            def_ptall_1 = x;
        }

        public void setDef_ptall_7(int x) {
            def_ptall_7 = x;
        }

        public void setDef_ptall_14(int x) {
            def_ptall_14 = x;
        }

        public void setDef_ptall_21(int x) {
            def_ptall_21 = x;
        }

        public void setDef_ptall_28(int x) {
            def_ptall_28 = x;
        }

        public void setDef_ptall_35(int x) {
            def_ptall_35 = x;
        }

        public String updateScoringSettings() {

            EditText et_p_yds = (EditText) activity.findViewById(R.id.et_p_yds);
            setP_yds(Double.parseDouble(et_p_yds.getText().toString()));

            EditText et_p_td = (EditText) activity.findViewById(R.id.et_p_td);
            setP_td(Integer.parseInt(et_p_td.getText().toString()));

            EditText et_p_int = (EditText) activity.findViewById(R.id.et_p_int);
            setP_int(Integer.parseInt(et_p_int.getText().toString()));

            EditText et_ru_yds = (EditText) activity.findViewById(R.id.et_ru_yds);
            setRu_yds(Double.parseDouble(et_ru_yds.getText().toString()));

            EditText et_ru_td = (EditText) activity.findViewById(R.id.et_ru_td);
            setRu_td(Integer.parseInt(et_ru_td.getText().toString()));

            EditText et_re_yds = (EditText) activity.findViewById(R.id.et_re_yds);
            setRe_yds(Double.parseDouble(et_re_yds.getText().toString()));

            EditText et_re_td = (EditText) activity.findViewById(R.id.et_re_td);
            setRe_td(Integer.parseInt(et_re_td.getText().toString()));

            EditText et_two_pt_conv = (EditText) activity.findViewById(R.id.et_two_pt_conv);
            setTwo_pt_conv(Integer.parseInt(et_two_pt_conv.getText().toString()));

            EditText et_fumble_lost = (EditText) activity.findViewById(R.id.et_fumble_lost);
            setFumble_lost(Integer.parseInt(et_fumble_lost.getText().toString()));

            EditText et_k_pat = (EditText) activity.findViewById(R.id.et_k_pat);
            setK_pat(Integer.parseInt(et_k_pat.getText().toString()));

            EditText et_fg_0 = (EditText) activity.findViewById(R.id.et_fg_0);
            setFg_0(Integer.parseInt(et_fg_0.getText().toString()));

            EditText et_fg_20 = (EditText) activity.findViewById(R.id.et_fg_20);
            setFg_20(Integer.parseInt(et_fg_20.getText().toString()));

            EditText et_fg_30 = (EditText) activity.findViewById(R.id.et_fg_30);
            setFg_30(Integer.parseInt(et_fg_30.getText().toString()));

            EditText et_fg_40 = (EditText) activity.findViewById(R.id.et_fg_40);
            setFg_40(Integer.parseInt(et_fg_40.getText().toString()));

            EditText et_fg_50 = (EditText) activity.findViewById(R.id.et_fg_50);
            setFg_50(Integer.parseInt(et_fg_50.getText().toString()));

            EditText et_off_fumble_td = (EditText) activity.findViewById(R.id.et_off_fumble_td);
            setOff_fumble_td(Integer.parseInt(et_off_fumble_td.getText().toString()));

            EditText et_def_sack = (EditText) activity.findViewById(R.id.et_def_sack);
            setDef_sack(Integer.parseInt(et_def_sack.getText().toString()));

            EditText et_def_int = (EditText) activity.findViewById(R.id.et_def_int);
            setDef_int(Integer.parseInt(et_def_int.getText().toString()));

            EditText et_def_fumble_rec = (EditText) activity.findViewById(R.id.et_def_fumble_rec);
            setDef_fumble_rec(Integer.parseInt(et_def_fumble_rec.getText().toString()));

            EditText et_def_safety = (EditText) activity.findViewById(R.id.et_def_safety);
            setDef_safety(Integer.parseInt(et_def_safety.getText().toString()));

            EditText et_def_td = (EditText) activity.findViewById(R.id.et_def_td);
            setDef_td(Integer.parseInt(et_def_td.getText().toString()));

            EditText et_def_k_p_td = (EditText) activity.findViewById(R.id.et_def_k_p_td);
            setDef_k_p_td(Integer.parseInt(et_def_k_p_td.getText().toString()));

            EditText et_def_ptall_0 = (EditText) activity.findViewById(R.id.et_def_ptall_0);
            setDef_ptall_0(Integer.parseInt(et_def_ptall_0.getText().toString()));

            EditText et_def_ptall_1 = (EditText) activity.findViewById(R.id.et_def_ptall_1);
            setDef_ptall_1(Integer.parseInt(et_def_ptall_1.getText().toString()));

            EditText et_def_ptall_7 = (EditText) activity.findViewById(R.id.et_def_ptall_7);
            setDef_ptall_7(Integer.parseInt(et_def_ptall_7.getText().toString()));

            EditText et_def_ptall_14 = (EditText) activity.findViewById(R.id.et_def_ptall_14);
            setDef_ptall_14(Integer.parseInt(et_def_ptall_14.getText().toString()));

            EditText et_def_ptall_21 = (EditText) activity.findViewById(R.id.et_def_ptall_21);
            setDef_ptall_21(Integer.parseInt(et_def_ptall_21.getText().toString()));

            EditText et_def_ptall_28 = (EditText) activity.findViewById(R.id.et_def_ptall_28);
            setDef_ptall_28(Integer.parseInt(et_def_ptall_28.getText().toString()));

            EditText et_def_ptall_35 = (EditText) activity.findViewById(R.id.et_def_ptall_35);
            setDef_ptall_35(Integer.parseInt(et_def_ptall_35.getText().toString()));

            String SQL;
            if (exists) {
                SQL = "UPDATE t_user_scoring SET " +
                        "p_yds='" + p_yds + "'," +
                        "p_td='" + p_td + "'," +
                        "p_int='" + p_int + "'," +
                        "ru_yds='" + ru_yds + "'," +
                        "ru_td='" + ru_td + "'," +
                        "re_yds='" + re_yds + "'," +
                        "re_td='" + re_td + "'," +
                        "two_pt_conv='" + two_pt_conv + "'," +
                        "fumble_lost='" + fumble_lost + "'," +
                        "k_pat='" + k_pat + "'," +
                        "fg_0='" + fg_0 + "'," +
                        "fg_20='" + fg_20 + "'," +
                        "fg_30='" + fg_30 + "'," +
                        "fg_40='" + fg_40 + "'," +
                        "fg_50='" + fg_50 + "'," +
                        "off_fumble_td='" + off_fumble_td + "'," +
                        "def_sack='" + def_sack + "'," +
                        "def_int='" + def_int + "'," +
                        "def_fumble_rec='" + def_fumble_rec + "'," +
                        "def_safety='" + def_safety + "'," +
                        "def_td='" + def_td + "'," +
                        "def_k_p_td='" + def_k_p_td + "'," +
                        "def_ptall_0='" + def_ptall_0 + "'," +
                        "def_ptall_1='" + def_ptall_1 + "'," +
                        "def_ptall_7='" + def_ptall_7 + "'," +
                        "def_ptall_14='" + def_ptall_14 + "'," +
                        "def_ptall_21='" + def_ptall_21 + "'," +
                        "def_ptall_28='" + def_ptall_28 + "'," +
                        "def_ptall_35='" + def_ptall_35 + "' " +
                        "WHERE uid='" + userSession.getActiveUserId() + "'";
            } else {
                SQL = "INSERT INTO t_user_scoring VALUES(" +
                        "'" + userSession.getActiveUserId() + "'," +
                        "'" + p_yds + "'," +
                        "'" + p_td + "'," +
                        "'" + p_int + "'," +
                        "'" + ru_yds + "'," +
                        "'" + ru_td + "'," +
                        "'" + re_yds + "'," +
                        "'" + re_td + "'," +
                        "'" + two_pt_conv + "'," +
                        "'" + fumble_lost + "'," +
                        "'" + k_pat + "'," +
                        "'" + fg_0 + "'," +
                        "'" + fg_20 + "'," +
                        "'" + fg_30 + "'," +
                        "'" + fg_40 + "'," +
                        "'" + fg_50 + "'," +
                        "'" + off_fumble_td + "'," +
                        "'" + def_sack + "'," +
                        "'" + def_int + "'," +
                        "'" + def_fumble_rec + "'," +
                        "'" + def_safety + "'," +
                        "'" + def_td + "'," +
                        "'" + def_k_p_td + "'," +
                        "'" + def_ptall_0 + "'," +
                        "'" + def_ptall_1 + "'," +
                        "'" + def_ptall_7 + "'," +
                        "'" + def_ptall_14 + "'," +
                        "'" + def_ptall_21 + "'," +
                        "'" + def_ptall_28 + "'," +
                        "'" + def_ptall_35 + "'" +
                        ")";
            }
            return SQL;
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            if (mode == 1) {
                if (result.size() > 0) {
                    this.exists = true;
                    p_yds = Double.parseDouble(result.get(0)[1]);
                    p_td = Integer.parseInt(result.get(0)[2]);
                    p_int = Integer.parseInt(result.get(0)[3]);
                    ru_yds = Double.parseDouble(result.get(0)[4]);
                    ru_td = Integer.parseInt(result.get(0)[5]);
                    re_yds = Double.parseDouble(result.get(0)[6]);
                    re_td = Integer.parseInt(result.get(0)[7]);
                    two_pt_conv = Integer.parseInt(result.get(0)[8]);
                    fumble_lost = Integer.parseInt(result.get(0)[9]);
                    k_pat = Integer.parseInt(result.get(0)[10]);
                    fg_0 = Integer.parseInt(result.get(0)[11]);
                    fg_20 = Integer.parseInt(result.get(0)[12]);
                    fg_30 = Integer.parseInt(result.get(0)[13]);
                    fg_40 = Integer.parseInt(result.get(0)[14]);
                    fg_50 = Integer.parseInt(result.get(0)[15]);
                    off_fumble_td = Integer.parseInt(result.get(0)[16]);
                    def_sack = Integer.parseInt(result.get(0)[17]);
                    def_int = Integer.parseInt(result.get(0)[18]);
                    def_fumble_rec = Integer.parseInt(result.get(0)[19]);
                    def_safety = Integer.parseInt(result.get(0)[20]);
                    def_td = Integer.parseInt(result.get(0)[21]);
                    def_k_p_td = Integer.parseInt(result.get(0)[22]);
                    def_ptall_0 = Integer.parseInt(result.get(0)[23]);
                    def_ptall_1 = Integer.parseInt(result.get(0)[24]);
                    def_ptall_7 = Integer.parseInt(result.get(0)[25]);
                    def_ptall_14 = Integer.parseInt(result.get(0)[26]);
                    def_ptall_21 = Integer.parseInt(result.get(0)[27]);
                    def_ptall_28 = Integer.parseInt(result.get(0)[28]);
                    def_ptall_35 = Integer.parseInt(result.get(0)[29]);
                }

                EditText et_p_yds = (EditText) activity.findViewById(R.id.et_p_yds);
                et_p_yds.setText(Double.toString(p_yds));

                EditText et_p_td = (EditText) activity.findViewById(R.id.et_p_td);
                et_p_td.setText(Integer.toString(p_td));

                EditText et_p_int = (EditText) activity.findViewById(R.id.et_p_int);
                et_p_int.setText(Integer.toString(p_int));

                EditText et_ru_yds = (EditText) activity.findViewById(R.id.et_ru_yds);
                et_ru_yds.setText(Double.toString(ru_yds));

                EditText et_ru_td = (EditText) activity.findViewById(R.id.et_ru_td);
                et_ru_td.setText(Integer.toString(ru_td));

                EditText et_re_yds = (EditText) activity.findViewById(R.id.et_re_yds);
                et_re_yds.setText(Double.toString(re_yds));

                EditText et_re_td = (EditText) activity.findViewById(R.id.et_re_td);
                et_re_td.setText(Integer.toString(re_td));

                EditText et_two_pt_conv = (EditText) activity.findViewById(R.id.et_two_pt_conv);
                et_two_pt_conv.setText(Integer.toString(two_pt_conv));

                EditText et_fumble_lost = (EditText) activity.findViewById(R.id.et_fumble_lost);
                et_fumble_lost.setText(Integer.toString(fumble_lost));

                EditText et_k_pat = (EditText) activity.findViewById(R.id.et_k_pat);
                et_k_pat.setText(Integer.toString(k_pat));

                EditText et_fg_0 = (EditText) activity.findViewById(R.id.et_fg_0);
                et_fg_0.setText(Integer.toString(fg_0));

                EditText et_fg_20 = (EditText) activity.findViewById(R.id.et_fg_20);
                et_fg_20.setText(Integer.toString(fg_20));

                EditText et_fg_30 = (EditText) activity.findViewById(R.id.et_fg_30);
                et_fg_30.setText(Integer.toString(fg_30));

                EditText et_fg_40 = (EditText) activity.findViewById(R.id.et_fg_40);
                et_fg_40.setText(Integer.toString(fg_40));

                EditText et_fg_50 = (EditText) activity.findViewById(R.id.et_fg_50);
                et_fg_50.setText(Integer.toString(fg_50));

                EditText et_off_fumble_td = (EditText) activity.findViewById(R.id.et_off_fumble_td);
                et_off_fumble_td.setText(Integer.toString(off_fumble_td));

                EditText et_def_sack = (EditText) activity.findViewById(R.id.et_def_sack);
                et_def_sack.setText(Integer.toString(def_sack));

                EditText et_def_int = (EditText) activity.findViewById(R.id.et_def_int);
                et_def_int.setText(Integer.toString(def_int));

                EditText et_def_fumble_rec = (EditText) activity.findViewById(R.id.et_def_fumble_rec);
                et_def_fumble_rec.setText(Integer.toString(def_fumble_rec));

                EditText et_def_safety = (EditText) activity.findViewById(R.id.et_def_safety);
                et_def_safety.setText(Integer.toString(def_safety));

                EditText et_def_td = (EditText) activity.findViewById(R.id.et_def_td);
                et_def_td.setText(Integer.toString(def_td));

                EditText et_def_k_p_td = (EditText) activity.findViewById(R.id.et_def_k_p_td);
                et_def_k_p_td.setText(Integer.toString(def_k_p_td));

                EditText et_def_ptall_0 = (EditText) activity.findViewById(R.id.et_def_ptall_0);
                et_def_ptall_0.setText(Integer.toString(def_ptall_0));

                EditText et_def_ptall_1 = (EditText) activity.findViewById(R.id.et_def_ptall_1);
                et_def_ptall_1.setText(Integer.toString(def_ptall_1));

                EditText et_def_ptall_7 = (EditText) activity.findViewById(R.id.et_def_ptall_7);
                et_def_ptall_7.setText(Integer.toString(def_ptall_7));

                EditText et_def_ptall_14 = (EditText) activity.findViewById(R.id.et_def_ptall_14);
                et_def_ptall_14.setText(Integer.toString(def_ptall_14));

                EditText et_def_ptall_21 = (EditText) activity.findViewById(R.id.et_def_ptall_21);
                et_def_ptall_21.setText(Integer.toString(def_ptall_21));

                EditText et_def_ptall_28 = (EditText) activity.findViewById(R.id.et_def_ptall_28);
                et_def_ptall_28.setText(Integer.toString(def_ptall_28));

                EditText et_def_ptall_35 = (EditText) activity.findViewById(R.id.et_def_ptall_35);
                et_def_ptall_35.setText(Integer.toString(def_ptall_35));

            } else if (mode == 2) {
                try {
                    if (result.get(0)[0].toString().contains("ERROR")) {
                        exists = true;
                        String temp = updateScoringSettings();
                        GetNetworkConn task = new GetNetworkConn();
                        task.setOnResultsListener(this);
                        task.execute(temp);
                    }
                } catch (Exception e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Scoring Updated");
                    builder.setMessage("Your scoring settings have been updated.");
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }
        }
    }

    protected static class getUserPoints implements ResultListener {

        protected static class player_off {
            public player_off() {
                player_id = "";
                team = "";
                player_name = "";
                passing_yds = 0;
                passing_tds = 0;
                passing_int = 0;
                receiving_tds = 0;
                receiving_tds = 0;
                rushing_tds = 0;
                rushing_yds = 0;
                fumbles_lost = 0;
                ft_name="";
            }

            protected String player_id;
            protected String player_name;
            protected String team;
            protected String player_role;
            protected int passing_tds;
            protected int passing_yds;

            protected int receiving_yds;
            protected int receiving_tds;

            protected int rushing_yds;
            protected int rushing_tds;

            protected int passing_int;
            protected int fumbles_lost;

            protected double total_fantasy_points;
            protected String ft_name;
        }

        protected static class offScoring {
            public offScoring() {
                passingYds_pts = 0;
                passingTds_pts = 0;
                receivingYds_pts = 0;
                receivingTds_pts = 0;
                rushingYds_pts = 0;
                rushingTds_pts = 0;
                passingInt_pts = 0;
                fumbleLost_pts = 0;
            }

            protected double passingYds_pts;
            protected int passingTds_pts;
            protected double receivingYds_pts;
            protected int receivingTds_pts;
            protected double rushingYds_pts;
            protected int rushingTds_pts;
            protected int passingInt_pts;
            protected int fumbleLost_pts;
        }

        protected int week;
        protected boolean getPID = false;
        protected boolean getPlayers = false;
        protected boolean getScoring = false;
        protected boolean readyForUpdate=false;
        protected int count;
        protected int numOfPlayers;
        protected Activity activity;
        protected ActiveSession userSession;
        protected player_off[] userPlayersOff;
        protected offScoring userOffScoring;

        public getUserPoints(Activity activity, ActiveSession userSession, int week) {
            userOffScoring = new offScoring();
            userPlayersOff = new player_off[50];
            for (int i = 0; i < 50; i++) {
                userPlayersOff[i] = new player_off();
            }
            this.week = week;
            this.activity = activity;
            this.userSession = userSession;
            count = 0;

            if (!getPlayers) {
                GetNetworkConn task = new GetNetworkConn();
                task.setOnResultsListener(this);
                task.execute("SELECT UP.player_id, UP.player_team, PL.position, PL.full_name, TU.fantasy_team_name  FROM user_player UP, player PL, t_user TU WHERE PL.player_id=UP.player_id AND UP.user_id=" + userSession.getActiveUserId() + "AND TU.user_id=UP.user_id");
            }

            Spinner wkSpinner = (Spinner)activity.findViewById(R.id.wkSpin);
            if(wkSpinner.isEnabled()) {
                TableLayout tl = (TableLayout) activity.findViewById(R.id.matchupTable);
                tl.removeAllViews();
                TextView totalTeamScore = (TextView) activity.findViewById(R.id.userTeamScore);
                totalTeamScore.setText("LOADING...");
            }

            // task.execute("SELECT * FROM game WHERE week=3 AND season_year='2015' AND season_type='Regular' ORDER BY start_time");

        }

        private void fillPlayers(ArrayList<String[]> result) {
            if (!getPlayers) {

                for (int i = 0; i < result.size(); i++) {
                    userPlayersOff[i].player_id = result.get(i)[0];
                    userPlayersOff[i].team = result.get(i)[1];
                    userPlayersOff[i].player_role =result.get(i)[2];
                    userPlayersOff[i].player_name = result.get(i)[3];
                    userPlayersOff[i].ft_name = result.get(0)[4];
                }
                getPlayers = true;
            } else {

            }
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);

            String SQL;

            SQL = "SELECT SUM(passing_yds)," +
                    "SUM(passing_tds)," +
                    "SUM(receiving_tds)," +
                    "SUM(receiving_yds)," +
                    "SUM(rushing_yds)," +
                    "SUM(rushing_tds)," +
                    "SUM(passing_int)," +
                    "SUM(fumbles_lost) " +
                    "FROM play_player " +
                    "WHERE player_id='" + userPlayersOff[count].player_id + "' AND " +
                    "gsis_id=(SELECT gsis_id FROM game " +
                    "WHERE week=" + week + " AND " +
                    "(home_team='" + userPlayersOff[count].team + "' OR away_team='" + userPlayersOff[count].team + "') AND " +
                    "season_year=2015 AND season_type='Regular');";
            count+=1;
            if (count == 1) {
                getPID = true;
            } else if (count > 1) {
                getPID = false;
            }
            task.execute(SQL);

        }

        protected void calcFantasyPoints() {
            if (!getScoring) {
                GetNetworkConn task = new GetNetworkConn();
                task.setOnResultsListener(this);
                getScoring = true;
                task.execute("SELECT p_yds,p_td,re_yds,re_td,ru_yds,ru_td,p_int,fumble_lost FROM t_user_scoring WHERE uid=" + userSession.getActiveUserId());
            } else {
                for (int i = 0; i < (count-1); i++) {
                    userPlayersOff[i].total_fantasy_points =
                            (userPlayersOff[i].passing_yds * userOffScoring.passingYds_pts) +
                                    (userPlayersOff[i].passing_tds * userOffScoring.passingTds_pts) +
                                    (userPlayersOff[i].receiving_yds * userOffScoring.receivingYds_pts) +
                                    (userPlayersOff[i].receiving_tds * userOffScoring.receivingTds_pts) +
                                    (userPlayersOff[i].rushing_yds * userOffScoring.rushingYds_pts) +
                                    (userPlayersOff[i].rushing_tds * userOffScoring.rushingTds_pts) +
                                    (userPlayersOff[i].passing_int * userOffScoring.passingInt_pts) +
                                    (userPlayersOff[i].fumbles_lost * userOffScoring.fumbleLost_pts);
                }
                readyForUpdate=true;
            }

        }

        public void updateMatchupView(ArrayList<String[]> result) {
            double totalUserScore = 0.00;
            for (int i = 0; i < count; i++) {
                totalUserScore += userPlayersOff[i].total_fantasy_points;
            }
            TableLayout tl = (TableLayout) activity.findViewById(R.id.matchupTable);
            TextView teamName = (TextView) activity.findViewById(R.id.userTeamName);
            teamName.setTextSize(22);
            teamName.setText(userPlayersOff[0].ft_name);
            TextView totalTeamScore = (TextView) activity.findViewById(R.id.userTeamScore);
            totalTeamScore.setText(String.format("%.2f", totalUserScore));
            boolean firstRun = false;
            for (int i = 0; i < numOfPlayers; i++) {
                TableLayout.LayoutParams lp = new TableLayout.LayoutParams();
                TableRow tr = new TableRow(activity);
                lp.setMargins(25, 0, 0, 0);
                tr.setLayoutParams(lp);

                if (!firstRun) {
                    TextView ch1 = new TextView(activity);
                    TextView ch2 = new TextView(activity);
                    TextView ch3 = new TextView(activity);

                    ch1.setTextSize(25);
                    ch2.setTextSize(25);
                    ch3.setTextSize(25);


                    ch1.setText("PLAYER NAME");
                    ch2.setText("POINTS");
                    ch3.setText("ROLE");
                    ch1.setGravity(Gravity.CENTER);
                    ch2.setGravity(Gravity.CENTER);
                    ch3.setGravity(Gravity.CENTER);

                    ch1.setBackgroundResource(R.drawable.cell_borders);
                    ch2.setBackgroundResource(R.drawable.cell_borders);
                    ch3.setBackgroundResource(R.drawable.cell_borders);

                    tr.addView(ch1);
                    tr.addView(ch2);
                    tr.addView(ch3);
                    firstRun = true;
                    i--;
                } else {

                    TextView userPName = new TextView(activity);
                    userPName.setText(userPlayersOff[i].player_name.toString());
                    userPName.setGravity(Gravity.START);
                    userPName.setTextSize(20);
                    userPName.setBackgroundResource(R.drawable.cell_borders);
                    tr.addView(userPName);

                    TextView userPScore = new TextView(activity);
                    userPScore.setText(String.format("%.2f", userPlayersOff[i].total_fantasy_points));
                    userPScore.setGravity(Gravity.CENTER);
                    userPScore.setTextSize(20);
                    userPScore.setBackgroundResource(R.drawable.cell_borders);
                    tr.addView(userPScore);

                    TextView userPPos = new TextView(activity);
                    userPPos.setText(userPlayersOff[i].player_role.toString());
                    userPPos.setGravity(Gravity.CENTER);
                    userPPos.setTextSize(20);
                    userPPos.setBackgroundResource(R.drawable.cell_borders);
                    tr.addView(userPPos);
                }
                if (tr.getParent() != null)
                    ((ViewGroup) tr.getParent()).removeView(tr);

                tl.addView(tr, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }

            ArrayAdapter<String> la = new ArrayAdapter<String>(activity, R.layout.rowdef, result.get(0));
            Spinner wkSpinner = (Spinner)activity.findViewById(R.id.wkSpin);
            if(!wkSpinner.isEnabled()) {
                tl.removeAllViews();
                wkSpinner.setEnabled(true);
            }
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            if(!getPlayers) {
                numOfPlayers= result.size();
                fillPlayers(result);
            } else if(result.size()<50 || result.equals(null)) {
                try {
                    if(count<=numOfPlayers) {
                        int temp = Integer.parseInt(result.get(0)[0]);
                        temp = 0;
                    }
                } catch(Exception e) {
                    String[] nullRes = new String[8];
                    nullRes[0]="0";
                    nullRes[1]="0";
                    nullRes[2]="0";
                    nullRes[3]="0";
                    nullRes[4]="0";
                    nullRes[5]="0";
                    nullRes[6]="0";
                    nullRes[7]="0";
                    result.set(0,nullRes);
                }
                if(count<=numOfPlayers) {
                    userPlayersOff[count-1].passing_yds=Integer.parseInt(result.get(0)[0]);
                    userPlayersOff[count-1].passing_tds=Integer.parseInt(result.get(0)[1]);
                    userPlayersOff[count-1].receiving_tds=Integer.parseInt(result.get(0)[2]);
                    userPlayersOff[count-1].receiving_yds=Integer.parseInt(result.get(0)[3]);
                    userPlayersOff[count-1].rushing_yds=Integer.parseInt(result.get(0)[4]);
                    userPlayersOff[count-1].rushing_tds=Integer.parseInt(result.get(0)[5]);
                    userPlayersOff[count-1].passing_int=Integer.parseInt(result.get(0)[6]);
                    userPlayersOff[count-1].fumbles_lost=Integer.parseInt(result.get(0)[7]);
                    if((count)<numOfPlayers) {
                        fillPlayers(result);
                    } else count++;

                }
                if((count)>numOfPlayers){
                    if(getScoring){
                        userOffScoring.passingYds_pts= Double.parseDouble(result.get(0)[0]);
                        userOffScoring.passingTds_pts= Integer.parseInt(result.get(0)[1]);
                        userOffScoring.receivingYds_pts= Double.parseDouble(result.get(0)[2]);
                        userOffScoring.receivingTds_pts= Integer.parseInt(result.get(0)[3]);
                        userOffScoring.rushingYds_pts= Double.parseDouble(result.get(0)[4]);
                        userOffScoring.rushingTds_pts= Integer.parseInt(result.get(0)[5]);
                        userOffScoring.passingInt_pts= Integer.parseInt(result.get(0)[6]);
                        userOffScoring.fumbleLost_pts= Integer.parseInt(result.get(0)[7]);
                    }
                    calcFantasyPoints();

                }
            } else if(count>=0 && !getPID) {

            }
            if(readyForUpdate==true) {
                updateMatchupView(result);
            }

        }
    }

    protected static class addPlayerOps implements  ResultListener{

        private Activity activity;
        private ActiveSession userSession;
        private boolean checkPlayers=false;
        private String[] pids;
        private String[] teams;
        private String[] positions;
        private boolean playerInsert;
        private int rowSelected;


        public addPlayerOps(Activity activity, ActiveSession userSession, String team, String position, String pName) {
            this.activity = activity;
            this.userSession = userSession;
            playerInsert=false;
            String SQL = "SELECT player_id, full_name, position, team FROM player";
            if(pName=="") {

            } else {
                SQL+= " WHERE full_name LIKE '%"+ pName +"%'";
                if(!team.contains("All")) {
                    SQL+= " AND team='"+ team +"'";
                }
                if(!position.contains("All")) {
                    SQL += " AND position='"+ position +"'";
                }
                SQL+= " AND position!='UNK' AND team!='UNK'";

            }

            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute(SQL);

        }
        private void checkForPlayer(String playerid) {
            checkPlayers = true;
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT * FROM user_player WHERE player_id='"+ playerid +"' AND user_id='"+ userSession.getActiveUserId() +"'");
        }
        private void addPlayer() {
            String playerid = pids[rowSelected];
            String playerTeam= teams[rowSelected];
            playerInsert=true;
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("INSERT INTO user_player VALUES('"+ playerid +"','"+ userSession.getActiveUserId() +"','"+ playerTeam +"',0)");
        }
        @Override
        public void onResultSuccess(final ArrayList<String[]> result) {
            if (!checkPlayers) {
                TableLayout tl = (TableLayout) activity.findViewById(R.id.teamPlayerTable);
                tl.removeAllViews();
                ArrayList<String> searchedPlayers = new ArrayList<String>();
                boolean firstRun = false;
                pids = new String[result.size()];
                teams = new String[result.size()];
                positions = new String[result.size()];

                for (int i = 0; i < result.size(); i++) {
                    TableLayout.LayoutParams lp = new TableLayout.LayoutParams();
                    final TableRow tr = new TableRow(activity);
                    lp.setMargins(25, 0, 0, 0);
                    tr.setLayoutParams(lp);

                    if (!firstRun) {
                        TextView ch1 = new TextView(activity);
                        TextView ch2 = new TextView(activity);
                        TextView ch3 = new TextView(activity);
                        TextView ch4 = new TextView(activity);

                        ch1.setTextSize(15);
                        ch2.setTextSize(15);
                        ch3.setTextSize(15);
                        ch4.setTextSize(15);
                        ch1.setTextColor(Color.BLACK);
                        ch2.setTextColor(Color.BLACK);
                        ch3.setTextColor(Color.BLACK);
                        ch4.setTextColor(Color.BLACK);

                        ch1.setText("PLAYER NAME");
                        ch2.setText("POSITION");
                        ch3.setText("TEAM");
                        ch4.setText("ADD");
                        ch1.setGravity(Gravity.CENTER);
                        ch2.setGravity(Gravity.CENTER);
                        ch3.setGravity(Gravity.CENTER);
                        ch4.setGravity(Gravity.CENTER);

                        ch1.setBackgroundResource(R.drawable.cell_borders);
                        ch2.setBackgroundResource(R.drawable.cell_borders);
                        ch3.setBackgroundResource(R.drawable.cell_borders);
                        ch4.setBackgroundResource(R.drawable.cell_borders);

                        tr.addView(ch1);
                        tr.addView(ch2);
                        tr.addView(ch3);
                        tr.addView(ch4);
                        firstRun = true;
                        i--;
                    } else {
                        pids[i]=result.get(i)[0];
                        positions[i]=result.get(i)[2];
                        teams[i] = result.get(i)[3];

                        TextView pnameTV = new TextView(activity);
                        pnameTV.setText(result.get(i)[1]);
                        pnameTV.setGravity(Gravity.START);
                        pnameTV.setTextSize(15);
                        tr.addView(pnameTV);

                        TextView pposTV = new TextView(activity);
                        pposTV.setText(result.get(i)[2]);
                        pposTV.setGravity(Gravity.CENTER);
                        pposTV.setTextSize(15);
                        tr.addView(pposTV);

                        final TextView pteamTV = new TextView(activity);
                        pteamTV.setText(result.get(i)[3]);
                        pteamTV.setGravity(Gravity.CENTER);
                        pteamTV.setTextSize(15);
                        tr.addView(pteamTV);

                        Button btnAdd = new Button(activity);
                        btnAdd.setText("Add");
                        btnAdd.setOnClickListener(new addButtonOnClick(pids[i],i));
                        tr.addView(btnAdd);
                    }
                    if (tr.getParent() != null) {
                        ((ViewGroup) tr.getParent()).removeView(tr);
                    }
                    tl.addView(tr, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));

                }
                if(result.size()<1) {
                    TableLayout.LayoutParams lp = new TableLayout.LayoutParams();
                    final TableRow tr = new TableRow(activity);
                    lp.setMargins(25, 0, 0, 0);
                    tr.setLayoutParams(lp);

                    TextView ch1 = new TextView(activity);


                    ch1.setTextSize(17);

                    ch1.setTextColor(Color.BLACK);

                    ch1.setText("No players found with given criteria.");
                    ch1.setGravity(Gravity.CENTER);

                    ch1.setBackgroundResource(R.drawable.cell_borders);

                    tr.addView(ch1);
                    if (tr.getParent() != null) {
                        ((ViewGroup) tr.getParent()).removeView(tr);
                    }
                    tl.addView(tr, new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));

                }

                ArrayAdapter<String> la = new ArrayAdapter<String>(activity, R.layout.rowdef, searchedPlayers);
            } else {
                if(!playerInsert) {

                    if (result.size() > 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        builder.setMessage("Player already owned.");
                        builder.setTitle("Duplicate Player");
                        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        addPlayer();
                    }
                } else {
                    playerInsert=false;
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("The player has been added to your roster.");
                    builder.setTitle("Player Added");
                    builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }

            }
        }
        protected class addButtonOnClick implements View.OnClickListener{
            private String pid;
            private int index;
            public addButtonOnClick(String pid, int index) {
                this.pid= pid;
                this.index = index;
            }
            @Override
            public void onClick(View v) {
                rowSelected = index;
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage("Add player to roster?")
                        .setTitle("Add Player")
                        .setPositiveButton("ADD",new checkPlayersOnClick(pid,index))
                        .setNegativeButton("Cancel", new checkPlayersOnClick(pid,index));
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        }
        protected class checkPlayersOnClick implements DialogInterface.OnClickListener {
            private String pid;
            private int index;
            public checkPlayersOnClick(String pid, int index) {
                this.pid = pid;
                this.index = index;
            }
            @Override
            public void onClick(DialogInterface dialog, int which) {
                checkForPlayer(pid);
            }
        }
    }

    protected static class editTeamSettings implements ResultListener {

        private Activity activity;
        private ActiveSession userSession;
        private boolean bSelectCurrData;
        private boolean bChangePassword;
        private boolean bPasswordSuccess;
        private String newPass;

        public editTeamSettings(Activity activity, ActiveSession userSession) {
            this.activity = activity;
            this.userSession = userSession;
            this.bSelectCurrData = false;
            this.bChangePassword = false;
            this.bPasswordSuccess=false;
        }

        public void updateValues(){
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT fantasy_team_name,user_email FROM t_user WHERE user_id=" + userSession.getActiveUserId());
        }
        public void setNewValues(String newEmail, String newTeamName) {
            if(newEmail.isEmpty() || newTeamName.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Empty Fields");
                builder.setMessage("Please do not leave empty fields..");
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                bSelectCurrData = true;
                GetNetworkConn task = new GetNetworkConn();
                task.setOnResultsListener(this);
                task.execute("UPDATE t_user SET user_email='" + newEmail + "', fantasy_team_name='" + newTeamName + "' WHERE user_id=" + userSession.getActiveUserId());
            }
        }
        public void changePassword(String oldPass, String newPass, String newPassConfirm) {
            if(newPass.equals(newPassConfirm)) {
                bChangePassword=true;
                GetNetworkConn task = new GetNetworkConn();
                task.setOnResultsListener(this);
                this.newPass = newPass;
                task.execute("SELECT * FROM t_user WHERE password='"+ oldPass +"'");
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Change Failed");
                builder.setMessage("New passwords do not match.");
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            if(!bSelectCurrData && !bChangePassword) {
                EditText team_name = (EditText)activity.findViewById(R.id.et_teamname);
                EditText user_email = (EditText)activity.findViewById(R.id.et_email);

                team_name.setText(result.get(0)[0]);
                user_email.setText(result.get(0)[1]);
                bSelectCurrData=true;

            } else if(bSelectCurrData && !bChangePassword) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Success")
                        .setMessage("Your information has been updated successfully")
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                if(!bPasswordSuccess) {


                    if (result.size() >= 1) {
                        GetNetworkConn task = new GetNetworkConn();
                        task.setOnResultsListener(this);
                        bPasswordSuccess=true;
                        task.execute("UPDATE t_user SET password='" + newPass + "' WHERE user_id=" + userSession.getActiveUserId());
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        builder.setTitle("Change Failed");
                        builder.setMessage("Old password is incorrect.");
                        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        AlertDialog dialog = builder.create();
                        builder.show();
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Change Successful");
                    builder.setMessage("Your password has been changed.");
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    builder.show();
                }
            }
        }
    }

}