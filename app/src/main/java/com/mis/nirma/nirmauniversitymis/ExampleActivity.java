package com.mis.nirma.nirmauniversitymis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class
ExampleActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(getApplicationContext(),
                        "Group Clicked " + listDataHeader.get(groupPosition),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();

                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });



        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });


    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Attendance");
        listDataHeader.add("Time-Table");
        listDataHeader.add("Result");
        listDataHeader.add("Personal Information");

        // Adding child data
        List<String> Attendance = new ArrayList<String>();
        Attendance.add("DAA");
        Attendance.add("SE");
        Attendance.add("NSE");
        Attendance.add("ML");
        Attendance.add("MADT");
        Attendance.add("FIB");
        Attendance.add("CI");
        Attendance.add("MP-3");

        List<String> TimeTable = new ArrayList<String>();
        TimeTable.add("Monday");
        TimeTable.add("Tuesday");
        TimeTable.add("Wednesday");
        TimeTable.add("Thursday");
        TimeTable.add("Friday");
        TimeTable.add("Saturday");

        List<String> Result = new ArrayList<String>();
        Result.add("Semester-1");
        Result.add("Semester-2");
        Result.add("Semester-3");
        Result.add("Semester-4");
        Result.add("Semester-5");
        Result.add("Semester-6");
        Result.add("Semester-7");
        Result.add("Semester-8");

        List<String> PersonalInformation = new ArrayList<String>();
        PersonalInformation.add("Personal Details");
        PersonalInformation.add("Contact Details");
        PersonalInformation.add("Address");

        listDataChild.put(listDataHeader.get(0), Attendance); // Header, Child data
        listDataChild.put(listDataHeader.get(1), TimeTable);
        listDataChild.put(listDataHeader.get(2), Result);
        listDataChild.put(listDataHeader.get(3), PersonalInformation);
    }
}