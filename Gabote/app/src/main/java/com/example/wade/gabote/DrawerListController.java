package com.example.wade.gabote;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceFragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    public DrawerListController(final Activity activity, final ActiveSession userSession){
        mContext = activity.getApplicationContext();
        RelativeLayout mDrawerPane;
        DrawerLayout mDrawerLayout;
        ListView mDrawerList;

        mNavItems.add(new NavItem("Game Scores", "Display Scores of NFL Games", 0));
        mNavItems.add(new NavItem("Draft Helper","Help Selecting Draft Picks",0));
        mNavItems.add(new NavItem("View User Team","View Team",0));
        mNavItems.add(new NavItem("View User Score","View User Team Score",0));
        mNavItems.add(new NavItem("Add Player","Add Player to User Team",0));
        mNavItems.add(new NavItem("Edit Scoring Settings","Change Scoring Settings",0));
        mNavItems.add(new NavItem("Edit Account Settings","Change your account email/teamname/password",0));
        mNavItems.add(new NavItem("Exit Application","Exit the GABOTE application",0));

        mDrawerPane = (RelativeLayout)activity.findViewById(R.id.drawerPane);
        mDrawerLayout = (DrawerLayout)activity.findViewById(R.id.drawerLayout);
        mDrawerList = (ListView)activity.findViewById(R.id.navList);
        mDrawerList.setAdapter(this);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position,activity,userSession);
            }
        });
    }

    private void selectItemFromDrawer(int position,Activity activity, ActiveSession userSession) {
        Intent i = new Intent(activity.getApplicationContext(), DraftHelp.class);
        switch(position) {
            case 0:
                i = new Intent(activity.getApplicationContext(), GameScores.class);
                break;
            case 1:
                i = new Intent(activity.getApplicationContext(), DraftHelp.class);
                break;
            case 2:
                i = new Intent(activity.getApplicationContext(), userFantasyTeam.class);
                break;
            case 3:
                i = new Intent(activity.getApplicationContext(), FantasyMatchup.class);
                break;
            case 4:
                i = new Intent(activity.getApplicationContext(), AddPlayer.class);
                break;
            case 5:
                i = new Intent(activity.getApplicationContext(), ScoringSettings.class);
                break;
            case 6:
                i = new Intent(activity.getApplicationContext(), EditTeam.class);
                break;
            case 7:
                System.exit(0);
                return;
            default:
                i = new Intent(activity.getApplicationContext(),activity.getClass());
                break;

        }
        i.putExtra("userSession", userSession.getActiveUserId());
        activity.startActivity(i);
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