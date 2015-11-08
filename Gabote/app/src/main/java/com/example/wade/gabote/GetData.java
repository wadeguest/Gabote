package com.example.wade.gabote;

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

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.example.wade.gabote.GameScores;

import javax.xml.transform.Result;

import static android.app.PendingIntent.getActivity;

public class GetData {
    protected GetData() {
        //Constructor
    }

    protected static class WeekDataTable implements ResultListener  {

        //Column Variables
        private int[] gsis_id;
        private int[] gamekey;
        private String[] start_time;
        //private int[] week;
        private int week;
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
            gameCount=0;

            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT * FROM game WHERE week=" + week + " AND season_year='2015' AND season_type='Regular' ORDER BY start_time");
        }

        public int[] getGsis_id(){return gsis_id;}
        public int[] getGameKey(){return gamekey;}
        public String[] getStart_time(){return start_time;}
        public String[] getDay_of_week(){return day_of_week;}
        public int[] getYear(){return year;}
        public String[] getSeason_type(){return season_type;}
        public char[] getFinished(){return finished;}
        public String[] getHome_team(){return home_team;}
        public int[] getHome_score(){return home_score;}
        public int[] getHome_score_q1(){return home_score_q1;}
        public int[] getHome_score_q2(){return home_score_q2;}
        public int[] getHome_score_q3(){return home_score_q3;}
        public int[] getHome_score_q4(){return home_score_q4;}
        public int[] getHome_score_q5(){return home_score_q5;}
        public int[] getHome_turnovers(){return home_turnovers;}
        public String[] getAway_team(){return away_team;}
        public int[] getAway_score(){return away_score;}
        public int[] getAway_score_q1(){return away_score_q1;}
        public int[] getAway_score_q2(){return away_score_q2;}
        public int[] getAway_score_q3(){return away_score_q3;}
        public int[] getAway_score_q4(){return away_score_q4;}
        public int[] getAway_score_q5(){return away_score_q5;}
        public int[] getAway_turnovers(){return away_turnovers;}
        public String[] getTime_inserted(){return time_inserted;}
        public String[] getTime_updated(){return time_updated;}
        public int getGame_count(){return gameCount;}

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            for(int i=0; i<result.size();i++)
            {
                gsis_id[i] =        Integer.parseInt(result.get(i)[0]);
                gamekey[i] =        Integer.parseInt(result.get(i)[1]);
                start_time[i] =     (result.get(i)[2]);
                //week
                day_of_week[i] =    (result.get(i)[4]);
                year[i] =           Integer.parseInt(result.get(i)[5]);
                season_type[i] =    (result.get(i)[6]);
                finished[i] =       (result.get(i)[7].charAt(0));
                home_team[i] =      (result.get(i)[8]);
                home_score[i] =     Integer.parseInt(result.get(i)[9]);
                home_score_q1[i] =  Integer.parseInt(result.get(i)[10]);
                home_score_q2[i] =  Integer.parseInt(result.get(i)[11]);
                home_score_q3[i] =  Integer.parseInt(result.get(i)[12]);
                home_score_q4[i] =  Integer.parseInt(result.get(i)[13]);
                home_score_q5[i] =  Integer.parseInt(result.get(i)[14]);
                home_turnovers[i] = Integer.parseInt(result.get(i)[15]);
                away_team[i] =      (result.get(i)[16]);
                away_score[i] =     Integer.parseInt(result.get(i)[17]);
                away_score_q1[i] =  Integer.parseInt(result.get(i)[18]);
                away_score_q2[i] =  Integer.parseInt(result.get(i)[19]);
                away_score_q3[i] =  Integer.parseInt(result.get(i)[20]);
                away_score_q4[i] =  Integer.parseInt(result.get(i)[21]);
                away_score_q5[i] =  Integer.parseInt(result.get(i)[22]);
                away_turnovers[i] = Integer.parseInt(result.get(i)[23]);
                time_inserted[i] =  (result.get(i)[24]);
                time_updated[i] =   (result.get(i)[25]);
            }
            gameCount = result.size();
            updateGameScoreView();
        }
        private String getFullTeamName(String acr)
        {
            switch(acr) {
                case "ARI": return "ARI Cardinals";
                case "ATL": return "ATL Falcons";
                case "BAL": return "BAL Ravens";
                case "BUF": return "BUF Bills";
                case "CAR": return "CAR Panthers";
                case "CHI": return "CHI Bears";
                case "CIN": return "CIN Bengals";
                case "CLE": return "CLE Browns";
                case "DAL": return "DAL Cowboys";
                case "DEN": return "DEN Broncos";
                case "DET": return "DET Lions";
                case "GB": return "GB Packers";
                case "HOU": return "HOU Texans";
                case "IND": return "IND Colts";
                case "JAC": return "JAC Jaguars";
                case "KC": return "KC Chiefs";
                case "MIA": return "MIA Dolphins";
                case "MIN": return "MIN Vikings";
                case "NE": return "NEW Patriots";
                case "NO": return "NO Saints";
                case "NYG": return "NY Giants";
                case "NYJ": return "NY Jets";
                case "OAK": return "OAK Raiders";
                case "PHI": return "PHI Eagles";
                case "PIT": return "PIT Steelers";
                case "SD": return "SD Chargers";
                case "SEA": return "SEA Seahawks";
                case "SF": return "SF 49ers";
                case "STL": return "STL Rams";
                case "TB": return "TB Buccaneers";
                case "TEN": return "TEN Titans";
                case "WAS": return "WAS Redskins";
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
                    final ArrayAdapter<String> optionAdapter= new ArrayAdapter<String>(activity.getApplicationContext(),android.R.layout.select_dialog_singlechoice);
                    optionAdapter.add("View Details");
                    optionAdapter.add("View Chat Room");

                    AlertDialog.Builder builder= new AlertDialog.Builder(activity);
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
    protected static class UserTeamPlayers implements ResultListener {

        private String teamName;
        private String email;
        private String username;

        private String[] names;
        private String[] position;
        private String[] team;


        public UserTeamPlayers(Activity activity) {
            names = new String[20];
            position = new String[20];
            team = new String[20];

            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT * FROM game WHERE week=3 AND season_year='2015' AND season_type='Regular' ORDER BY start_time");

        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {

        }
    }
    protected static class checkUserSignUp implements ResultListener {
        private String userName;
        private String email;
        private String password;
        private Activity activity;

        public checkUserSignUp(Activity activity, String userName, String email, String password) {
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.activity = activity;

            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("INSERT INTO t_user(username,password,user_email) VALUES('"+this.userName+"','"+this.password+"','"+this.email+"')");
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            String success = result.get(0)[0].toString();
            if(success=="success") {

                final ArrayAdapter<String> optionAdapter= new ArrayAdapter<String>(activity.getApplicationContext(),android.R.layout.select_dialog_singlechoice);
                optionAdapter.add("Signup Success");

                AlertDialog.Builder builder= new AlertDialog.Builder(activity);
                builder.setTitle("Success!");
                builder.setMessage("Account Created Successfully");
                builder.setPositiveButton("Go To Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(activity.getApplicationContext(),UserLogin.class);
                        activity.startActivity(i);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog2) {

                    }
                });
                dialog.show();


            } else {
                final ArrayAdapter<String> optionAdapter= new ArrayAdapter<String>(activity.getApplicationContext(),android.R.layout.select_dialog_singlechoice);
                optionAdapter.add("Signup Failed");

                AlertDialog.Builder builder= new AlertDialog.Builder(activity);
                builder.setTitle("Error with Signup.");
                builder.setMessage("Account not created. Please review fields.");
                builder.setPositiveButton("Hide.", new DialogInterface.OnClickListener() {
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
    protected static class checkUserLogin implements ResultListener{
        private String username;
        private String password;
        private Activity activity;
        private ActiveSession userSession;
        public checkUserLogin(Activity activity, String username, String password, ActiveSession userSession)
        {
            this.activity = activity;
            this.username = username;
            this.password = password;
            this.userSession = userSession;
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT user_id FROM t_user WHERE username='"+ this.username +"' AND password='"+ this.password +"'");
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            if(result.size() == 1){

                Intent i= new Intent(activity.getApplicationContext(),ScoringSettings.class);
                userSession.setActiveUserId(Integer.parseInt(result.get(0)[0]));
                i.putExtra("userSession", userSession.getActiveUserId());
                activity.startActivity(i);


            } else {
                final ArrayAdapter<String> optionAdapter= new ArrayAdapter<String>(activity.getApplicationContext(),android.R.layout.select_dialog_singlechoice);
                optionAdapter.add("Login Failed.");

                AlertDialog.Builder builder= new AlertDialog.Builder(activity);
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
        public UserTeam(Activity activity, ActiveSession userSession)
        {
            this.activity=activity;
            this.p_first_name = new String[50];
            this.p_last_name = new String[50];
            this.p_position = new String[50];
            this.p_team = new String[50];
            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT P.first_name, P.last_name, P.position,P.team FROM player P, user_player U WHERE U.user_id='"+ userSession.getActiveUserId() +"' AND U.player_id=P.player_id");

        }
        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            for(int i=0;i<result.size();i++)
            {
                p_first_name[i] = result.get(i)[0];
                p_last_name[i] = result.get(i)[1];
                p_position[i] = result.get(i)[2];
                p_team[i] = result.get(i)[3];
            }
            TableLayout tl = (TableLayout)activity.findViewById(R.id.teamPlayerTable);
       //     tl.setBackgroundColor(Color.BLACK);
            ArrayList<String> userPlayerList = new ArrayList<String>();
            String temp;
            boolean firstRun = false;
            for(int i=0; i<result.size();i++)
            {
                TableLayout.LayoutParams lp = new TableLayout.LayoutParams();
                TableRow tr = new TableRow(activity);
                lp.setMargins(25, 0, 0, 0);
                tr.setLayoutParams(lp);


                if(i%2 == 0){
              //      tr.setBackgroundColor(Color.GRAY);
                } else {
              //      tr.setBackgroundColor(Color.WHITE);
                }
              //  tr.setBackgroundResource(R.drawable.table_borders);

                if(!firstRun){
                    TextView ch1 = new TextView(activity);
                    TextView ch2 = new TextView(activity);
                    TextView ch3 = new TextView(activity);

                    ch1.setText("POSITION");
                    ch2.setText("PLAYER NAME");
                    ch3.setText("TEAM");
                    ch1.setGravity(Gravity.CENTER);
                    ch2.setGravity(Gravity.CENTER);
                    ch3.setGravity(Gravity.CENTER);

                    tr.addView(ch1);
                    tr.addView(ch2);
                    tr.addView(ch3);
                    firstRun=true;
                    i--;
                } else {
                    TextView posTV = new TextView(activity);
                    posTV.setText(p_position[i].toString());
                    posTV.setGravity(Gravity.CENTER);
                    posTV.setBackgroundResource(R.drawable.table_borders);
                    tr.addView(posTV);

                    TextView nameTV = new TextView(activity);
                    nameTV.setText(p_first_name[i].toString() + " " + p_last_name[i].toString());
                    nameTV.setGravity(Gravity.CENTER);
                    nameTV.setBackgroundResource(R.drawable.table_borders);
                    tr.addView(nameTV);

                    TextView tmTV = new TextView(activity);
                    tmTV.setText(p_team[i].toString());
                    tmTV.setGravity(Gravity.CENTER);
                    tmTV.setBackgroundResource(R.drawable.table_borders);
                    tr.addView(tmTV);

                    Button rm = new Button(activity);
                    rm.setGravity(Gravity.CENTER);
                    rm.setText("Remove");
                    rm.setBackgroundColor(android.graphics.Color.RED);
                    rm.setBackgroundResource(R.drawable.table_borders);
                    tr.addView(rm);
                }
                if(tr.getParent()!=null)
                    ((ViewGroup)tr.getParent()).removeView(tr);

                tl.addView(tr,new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            ArrayAdapter<String> la = new ArrayAdapter<String>(activity,R.layout.rowdef,userPlayerList);
        }
    }
    protected static class UserScoringSettings implements ResultListener {
        ActiveSession userSession;
        Activity activity;
        private boolean exists;
        private int mode;
        private int p_yds;
        private int p_td;
        private int p_int;
        private int ru_yds;
        private int ru_td;
        private int re_yds;
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


        public int getP_yds(){return p_yds;}
        public int getP_td(){return p_td;}
        public int getP_int(){return p_int;}
        public int getRu_yds(){return ru_yds;}
        public int getRu_td(){return ru_td;}
        public int getRe_yds(){return re_yds;}
        public int getRe_td(){return re_td;}
        public int getTwo_pt_conv(){return two_pt_conv;}
        public int getFumble_lost(){return fumble_lost;}
        public int getK_pat(){return k_pat;}
        public int getFg_0(){return fg_0;}
        public int getFg_20(){return fg_20;}
        public int getFg_30(){return fg_30;}
        public int getFg_40(){return fg_40;}
        public int getFg_50(){return fg_50;}
        public int getOff_fumble_td(){return off_fumble_td;}
        public int getDef_sack(){return def_sack;}
        public int getDef_int(){return def_int;}
        public int getDef_fumble_rec(){return def_fumble_rec;}
        public int getDef_safety(){return def_safety;}
        public int getDef_td(){return def_td;}
        public int getDef_k_p_td(){return def_k_p_td;}
        public int getDef_ptall_0(){return def_ptall_0;}
        public int getDef_ptall_1(){return def_ptall_1;}
        public int getDef_ptall_7(){return def_ptall_7;}
        public int getDef_ptall_14(){return def_ptall_14;}
        public int getDef_ptall_21(){return def_ptall_21;}
        public int getDef_ptall_28(){return def_ptall_28;}
        public int getDef_ptall_35(){return def_ptall_35;}

        public void setP_yds(int x){p_yds=x;}
        public void setP_td(int x){p_td=x;}
        public void setP_int(int x){p_int=x;}
        public void setRu_yds(int x){ru_yds=x;}
        public void setRu_td(int x){ru_td=x;}
        public void setRe_yds(int x){re_yds=x;}
        public void setRe_td(int x){re_td=x;}
        public void setTwo_pt_conv(int x){two_pt_conv=x;}
        public void setFumble_lost(int x){fumble_lost=x;}
        public void setK_pat(int x){k_pat=x;}
        public void setFg_0(int x){fg_0=x;}
        public void setFg_20(int x){fg_20=x;}
        public void setFg_30(int x){fg_30=x;}
        public void setFg_40(int x){fg_40=x;}
        public void setFg_50(int x){fg_50=x;}
        public void setOff_fumble_td(int x){off_fumble_td=x;}
        public void setDef_sack(int x){def_sack=x;}
        public void setDef_int(int x){def_int=x;}
        public void setDef_fumble_rec(int x){def_fumble_rec=x;}
        public void setDef_safety(int x){def_safety=x;}
        public void setDef_td(int x){def_td=x;}
        public void setDef_k_p_td(int x){def_k_p_td=x;}
        public void setDef_ptall_0(int x){def_ptall_0=x;}
        public void setDef_ptall_1(int x){def_ptall_1=x;}
        public void setDef_ptall_7(int x){def_ptall_7=x;}
        public void setDef_ptall_14(int x){def_ptall_14=x;}
        public void setDef_ptall_21(int x){def_ptall_21=x;}
        public void setDef_ptall_28(int x){def_ptall_28=x;}
        public void setDef_ptall_35(int x){def_ptall_35=x;}

        public String updateScoringSettings() {

            EditText et_p_yds = (EditText) activity.findViewById(R.id.et_p_yds);
            setP_yds(Integer.parseInt(et_p_yds.getText().toString()));

            EditText et_p_td = (EditText) activity.findViewById(R.id.et_p_td);
            setP_td(Integer.parseInt(et_p_td.getText().toString()));

            EditText et_p_int = (EditText) activity.findViewById(R.id.et_p_int);
            setP_int(Integer.parseInt(et_p_int.getText().toString()));

            EditText et_ru_yds = (EditText) activity.findViewById(R.id.et_ru_yds);
            setRu_yds(Integer.parseInt(et_ru_yds.getText().toString()));

            EditText et_ru_td = (EditText) activity.findViewById(R.id.et_ru_td);
            setRu_td(Integer.parseInt(et_ru_td.getText().toString()));

            EditText et_re_yds = (EditText) activity.findViewById(R.id.et_re_yds);
            setRe_yds(Integer.parseInt(et_re_yds.getText().toString()));

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
                    p_yds = Integer.parseInt(result.get(0)[1]);
                    p_td = Integer.parseInt(result.get(0)[2]);
                    p_int = Integer.parseInt(result.get(0)[3]);
                    ru_yds = Integer.parseInt(result.get(0)[4]);
                    ru_td = Integer.parseInt(result.get(0)[5]);
                    re_yds = Integer.parseInt(result.get(0)[6]);
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
                et_p_yds.setText(Integer.toString(p_yds));

                EditText et_p_td = (EditText) activity.findViewById(R.id.et_p_td);
                et_p_td.setText(Integer.toString(p_td));

                EditText et_p_int = (EditText) activity.findViewById(R.id.et_p_int);
                et_p_int.setText(Integer.toString(p_int));

                EditText et_ru_yds = (EditText) activity.findViewById(R.id.et_ru_yds);
                et_ru_yds.setText(Integer.toString(ru_yds));

                EditText et_ru_td = (EditText) activity.findViewById(R.id.et_ru_td);
                et_ru_td.setText(Integer.toString(ru_td));

                EditText et_re_yds = (EditText) activity.findViewById(R.id.et_re_yds);
                et_re_yds.setText(Integer.toString(re_yds));

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

            } else if(mode==2) {
                if(result.get(0)[0].toString().contains("ERROR")){
                    exists = true;
                    String temp = updateScoringSettings();
                    GetNetworkConn task = new GetNetworkConn();
                    task.setOnResultsListener(this);
                    task.execute(temp);
                }else{

                }
            }
        }
    }
}
