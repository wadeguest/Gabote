package com.example.wade.gabote;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.util.Log;
import android.widget.TextView;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.example.wade.gabote.ResultListener;

import javax.xml.transform.Result;

class GetNetworkConn extends AsyncTask<String,Void,List> {

    ResultListener listener;
    public void setOnResultsListener(ResultListener listener){
        this.listener = listener;
    }

    protected List doInBackground(String... query) {
        Connection cn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://10.0.2.2/";
            Properties props = new Properties();
            props.setProperty("user","nfldb");
            props.setProperty("password", "Wg2002!");
            cn = DriverManager.getConnection(url, props);

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query[0]);
            List<String[]> gameList = new ArrayList<>();

            int columnCount = rs.getMetaData().getColumnCount();
            String[] temp = new String[columnCount];
            while(rs.next())
            {
                for(int i =0; i < columnCount; i++)
                {
                    temp[i]=rs.getString(i+1);
                }
                gameList.add(temp);

            }
            temp=null;
            System.gc();
            return gameList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected void onPostExecute(List<String> result) {
        listener.onResultSuccess(result);
    }
}
