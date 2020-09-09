package com.mis.nirma.nirmauniversitymis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class
NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //protected static final int SUB_ACTIVITY_REQUEST_CODE = 100;

    //public static String Name = "Name:-\t\t\t";
    
    TextView actualname;
    String getActualName = StudentLoginActivity.getActualName();

    String TAG = "a";
    android.app.FragmentManager fragmentManager =   getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Intent i = new Intent(NavigationActivity.this, Sub.class);
        //startActivityForResult(i,SUB_ACTIVITY_REQUEST_CODE);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.package.ACTION_LOGOUT");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("onReceiveN", "Logout in progress");
                //At this point you should start the login activity and finish this one
                finish();
            }
        }, intentFilter);


        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Notifications", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View nameheader = navigationView.getHeaderView(0);

        actualname = (TextView) nameheader.findViewById(R.id.actualname);
        Log.i(TAG, getActualName);
        actualname.setText(getActualName);
    }

   


    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SUB_ACTIVITY_REQUEST_CODE) {
            if (data.hasExtra("Name")) {
                Name = Name + data.getExtras().getString("Name").toString();
            }
        }
    }*/


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //finish();
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_navigation, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_stud_attendance) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new stud_AttendanceFragment()).commit();
            //Toast.makeText(getApplicationContext(),"Coming Soon.",Toast.LENGTH_SHORT).show();


        } else if (id == R.id.nav_stud_timetable) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new stud_TimeTableFragment()).commit();

        } else if (id == R.id.nav_stud_result) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new stud_ResultFragment()).commit();

        } else if (id == R.id.nav_settings) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new stud_SettingsFragment()).commit();

        } else if (id == R.id.nav_stud_personalinformation) {

            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame,new stud_PersonalInfoFragment()).commit();

        } else if (id == R.id.nav_stud_logout) {
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("com.package.ACTION_LOGOUT");
            broadcastIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            sendBroadcast(broadcastIntent);
            startActivity(new Intent(getApplicationContext(),LoginOptions.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
