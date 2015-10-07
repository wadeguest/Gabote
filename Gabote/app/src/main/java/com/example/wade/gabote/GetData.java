package com.example.wade.gabote;

import java.util.ArrayList;
import java.util.List;

public class GetData {
    protected GetData() {
        //Constructor
    }

    protected static class WeekDataTable implements ResultListener {
        //Column Variables
        private int gsis_id;
        private int gamekey;
        private String start_time;
        private int week;
        private String day_of_week;
        private int year;
        private String season_type;
        private char finished;
        private String home_team;
        private int home_score;
        private int home_score_q1;
        private int home_score_q2;
        private int home_score_q3;
        private int home_score_q4;
        private int home_score_q5;
        private int home_turnovers;
        private String away_team;
        private int away_score;
        private int away_score_q1;
        private int away_score_q2;
        private int away_score_q3;
        private int away_score_q4;
        private int away_score_q5;
        private int away_turnovers;
        private String time_inserted;
        private String time_updated;

        ArrayList<String[]> tableData = new ArrayList<>();

        public WeekDataTable(int week) {

            GetNetworkConn task = new GetNetworkConn();
            task.setOnResultsListener(this);
            task.execute("SELECT * FROM game WHERE week=" + week + " AND season_year='2015' AND season_type='Regular' ORDER BY start_time");
        }

        @Override
        public void onResultSuccess(ArrayList<String[]> result) {
            tableData = result;
            this.gsis_id=Integer.parseInt(tableData.get(0)[0]);
            this.gamekey=Integer.parseInt(tableData.get(1)[0]);
        }
    }
}
