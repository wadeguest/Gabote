package com.example.wade.gabote;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GameScores extends AppCompatActivity {

    ListView mDrawerList;
    RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scores);
        mNavItems.add(new NavItem("Game Scores", "Display Scores of NFL Games", 0));
        mNavItems.add(new NavItem("Fantasy Menu", "Show all Fantasy Football Options", 0));
        mNavItems.add(new NavItem("Chat Rooms","Show Active Chat Rooms",0));
        mNavItems.add(new NavItem("Messaging","View/Send Messages to other users",0));

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

        mDrawerPane = (RelativeLayout)findViewById(R.id.drawerPane);
        mDrawerList = (ListView)findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setAdapter(adapter);

   //     mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
    //        @Override
     //       public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
      //          selectItemFromDrawer(position);
       //     }
        //});

        displayGameScores();
    }
    public void displayGameScores(){
        //GetData.WeekDataTable a = new GetData.WeekDataTable(4);
        ListView lv = (ListView)findViewById(R.id.listView);
        String[] games = {"[Icon] Team 1: 99    [Icon]Team 2: 99", "[Icon] Team 3: 99    [Icon]Team 4: 99", "...", "[Icon] Team n: 99    [Icon]Team m: 99"};
        ArrayList<String> gameList = new ArrayList<String>();
        gameList.addAll(Arrays.asList(games));

        ArrayAdapter<String> la = new ArrayAdapter<String>(this,R.layout.rowdef,gameList);
        lv.setAdapter(la);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_scores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class NavItem{
        String mTitle;
        String mSubtitle;
        int mIcon;

        public NavItem(String title,String subtitle, int icon){
            mTitle=title;
            mSubtitle=subtitle;
            mIcon=icon;
        }
    }
    class DrawerListAdapter extends BaseAdapter{

        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems){
            mContext =context;
            mNavItems = navItems;
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
}
