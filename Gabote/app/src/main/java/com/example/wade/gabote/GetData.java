package com.example.wade.gabote;

import java.util.List;

public class GetData implements ResultListener{
    protected GetData() {
      //Constructor
    }
    protected class WeekDataTable{
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




    }




    private List<String> tableData;
    protected List<String> returnWeekData(int week) {
        GetNetworkConn task = new GetNetworkConn();
        task.setOnResultsListener(this);
        task.execute("SELECT * FROM game WHERE finished='f' AND week='4' ORDER BY start_time ASC LIMIT 3");

        return null;
    }

    @Override
    public void onResultSuccess(List<String> result) {
        tableData=result;
    }
}
