package com.example.wade.gabote;

import java.util.List;

public class GetData implements ResultListener{
    protected GetData() {
      //Constructor
    }

    protected List<String> returnWeekData(int week) {
        GetNetworkConn task = new GetNetworkConn();
        task.setOnResultsListener(this);
        task.execute("SELECT * FROM game WHERE finished='f' AND week='4' ORDER BY start_time ASC LIMIT 3");
        return null;
    }

    @Override
    public List<String> onResultSuccess(List<String> result) {
        return result;
    }
}
