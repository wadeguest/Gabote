package com.example.wade.gabote;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wade.gabote.R;

import java.util.ArrayList;

public class DrawerListController extends BaseAdapter {

   public static class NavItem{
        String mTitle;
        String mSubtitle;
        int mIcon;

        public NavItem(String title,String subtitle, int icon){
            mTitle=title;
            mSubtitle=subtitle;
            mIcon=icon;
        }
    }


    Context mContext;
    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    public DrawerListController(){;}
    public DrawerListController(Activity activity){
        mContext = activity.getApplicationContext();
        RelativeLayout mDrawerPane;
        DrawerLayout mDrawerLayout;
        ListView mDrawerList;

        mNavItems.add(new NavItem("Game Scores", "Display Scores of NFL Games", 0));
        mNavItems.add(new NavItem("Fantasy Menu", "Show all Fantasy Football Options", 0));
        mNavItems.add(new NavItem("Chat Rooms","Show Active Chat Rooms",0));
        mNavItems.add(new NavItem("Messaging","View/Send Messages to other users",0));

        mDrawerPane = (RelativeLayout)activity.findViewById(R.id.drawerPane);
        mDrawerLayout = (DrawerLayout)activity.findViewById(R.id.drawerLayout);
        mDrawerList = (ListView)activity.findViewById(R.id.navList);
        mDrawerList.setAdapter(this);

    }

    @Override
    public int getCount() {
        return mNavItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item, null);
        } else {
            view= convertView;
        }

        TextView titleView = (TextView)view.findViewById(R.id.title);
        TextView subtitleView = (TextView)view.findViewById(R.id.subTitle);
        //ImageView iconView = (ImageView)view.findViewById(R.id.icon);

        titleView.setText(mNavItems.get(position).mTitle);
        subtitleView.setText(mNavItems.get(position).mSubtitle);
        //iconView.setImageResource(mNavItems.get(position).mIcon);
        return view;
    }
}