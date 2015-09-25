package com.example.wade.gabote;

import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.util.Log;
import android.widget.TextView;

import java.sql.*;

import java.util.Properties;

class GetNetworkConn extends AsyncTask<String,Void,Connection> {

    Connection cn;

    protected Connection doInBackground(String... urls) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://10.0.2.2/";
            Properties props = new Properties();
            props.setProperty("user","nfldb");
            props.setProperty("password", "Wg2002!");
            Connection cn = DriverManager.getConnection(url, props);
            Log.e("serv","SUCCESS");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM game WHERE finished='f' AND week='3' ORDER BY start_time ASC LIMIT 10");
            while(rs.next())
            {
                Log.e("game_score",rs.getString(9) + rs.getString(10) + rs.getString(17) + rs.getString(18));
            }
            return cn;
        } catch (Exception e) {
            Log.e("serv","failed");
            Log.e("serv",e.getCause().toString());
        }
        return null;
    }

    protected void onPostExecute() {

        // TODO: check this.exception
        // TODO: do something with the feed
    }
    public void closeNetworkConnection() {
        try {
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
