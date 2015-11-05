package com.example.wade.gabote;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wade on 2015-11-05.
 */
public class GameScoreController {
    public GameScoreController(){;}
    public void getWeekData(Activity activity, int week){
        new GetData.WeekDataTable(week,activity);
    }
}
