package com.mis.nirma.nirmauniversitymis;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.GridLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 * Created by bhautik on 9/10/16.
 */
public class stud_TimeTableFragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    TableLayout tl;
    private String[] groups;
    private String[][] children;
    String monarr[][] = StudentLoginActivity.getmonarr();
    String tuearr[][] = StudentLoginActivity.gettuearr();
    String wedarr[][] = StudentLoginActivity.getwedarr();
    String thurarr[][] = StudentLoginActivity.getthurarr();
    String friarr[][] = StudentLoginActivity.getfriarr();

    public void LineupFragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.stud_timetable);

        /*groups = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        children = new String[][]{
                {"9.00-9.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "9.50-10.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                         "11.15-12.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                         "12.15-1.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                         "2.00-3.00\t\tElctive-2(L)\t\tKC\t\tB204",
                         "3.00-4.00\t\tDAA(L)\t\tPP\t\tB212B",
                         "4.15-5.15\t\tUni.Elec\t\tIR\t\tT3",
                         "5.15-6.05\t\tUni.Elec\t\tIR\t\tT3",},
                {"9.00-9.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "9.50-10.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "11.15-12.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "12.15-1.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "2.00-3.00\t\tElctive-2(L)\t\tKC\t\tB204",
                        "3.00-4.00\t\tDAA(L)\t\tPP\t\tB212B",
                        "4.15-5.15\t\tUni.Elec\t\tIR\t\tT3",
                        "5.15-6.05\t\tUni.Elec\t\tIR\t\tT3",},
                {"9.00-9.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "9.50-10.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "11.15-12.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "12.15-1.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "2.00-3.00\t\tElctive-2(L)\t\tKC\t\tB204",
                        "3.00-4.00\t\tDAA(L)\t\tPP\t\tB212B",
                        "4.15-5.15\t\tUni.Elec\t\tIR\t\tT3",
                        "5.15-6.05\t\tUni.Elec\t\tIR\t\tT3",},
                {"9.00-9.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "9.50-10.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "11.15-12.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "12.15-1.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "2.00-3.00\t\tElctive-2(L)\t\tKC\t\tB204",
                        "3.00-4.00\t\tDAA(L)\t\tPP\t\tB212B",
                        "4.15-5.15\t\tUni.Elec\t\tIR\t\tT3",
                        "5.15-6.05\t\tUni.Elec\t\tIR\t\tT3",},
                {"9.00-9.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "9.50-10.50\t\tElctive-1(P)\t\tDB\t\tB2015",
                        "11.15-12.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "12.15-1.15\t\tElctive-3(T)\t\tRAK\t\tB104",
                        "2.00-3.00\t\tElctive-2(L)\t\tKC\t\tB204",
                        "3.00-4.00\t\tDAA(L)\t\tPP\t\tB212B",
                        "4.15-5.15\t\tUni.Elec\t\tIR\t\tT3",
                        "5.15-6.05\t\tUni.Elec\t\tIR\t\tT3",},
                {"Content Loading...."},
        };*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.stud_timetable, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button mondayb = (Button)rootView.findViewById(R.id.mondayb);
        Button tuesdayb = (Button)rootView.findViewById(R.id.tuesdayb);
        Button wednesdayb = (Button)rootView.findViewById(R.id.wednesdayb);
        Button thursdayb = (Button)rootView.findViewById(R.id.thursdayb);
        Button fridayb = (Button)rootView.findViewById(R.id.fridayb);
        Button saturdayb = (Button)rootView.findViewById(R.id.saturdayb);


        //lv = (ExpandableListView) view.findViewById(R.id.lvExp);
        //lv.setAdapter(new ExpandableListAdapter(groups, children));
        //lv.setGroupIndicator(null);

        final View montable = rootView.findViewById(R.id.montable);
        final View tuestable = rootView.findViewById(R.id.tuestable);
        final View wednestable = rootView.findViewById(R.id.wednestable);
        final View thurstable = rootView.findViewById(R.id.thurstable);
        final View fritable = rootView.findViewById(R.id.fritable);
        final View saturtable = rootView.findViewById(R.id.saturtable);

        //start
        //end
       //sub
        //faculty

//MONDAY
        TextView mstart12= (TextView) rootView.findViewById(R.id.mons12);
        mstart12.setText(monarr[0][2]);
        TextView mstart13= (TextView) rootView.findViewById(R.id.mons13);
        mstart13.setText(monarr[0][3]);
        TextView mstart14= (TextView) rootView.findViewById(R.id.mons14);
        mstart14.setText(monarr[0][4]);

        TextView mstart22= (TextView) rootView.findViewById(R.id.mons22);
        mstart22.setText(monarr[1][2]);
        TextView mstart23= (TextView) rootView.findViewById(R.id.mons23);
        mstart23.setText(monarr[1][3]);
        TextView mstart24= (TextView) rootView.findViewById(R.id.mons24);
        mstart24.setText(monarr[1][4]);

        TextView mstart32= (TextView) rootView.findViewById(R.id.mons32);
        mstart32.setText(monarr[2][2]);
        TextView mstart33= (TextView) rootView.findViewById(R.id.mons33);
        mstart33.setText(monarr[2][3]);
        TextView mstart34= (TextView) rootView.findViewById(R.id.mons34);
        mstart34.setText(monarr[2][4]);

        TextView mstart42= (TextView) rootView.findViewById(R.id.mons42);
        mstart42.setText(monarr[3][2]);
        TextView mstart43= (TextView) rootView.findViewById(R.id.mons43);
        mstart43.setText(monarr[3][3]);
        TextView mstart44= (TextView) rootView.findViewById(R.id.mons44);
        mstart44.setText(monarr[3][4]);

        TextView mstart52= (TextView) rootView.findViewById(R.id.mons52);
        mstart52.setText(monarr[4][2]);
        TextView mstart53= (TextView) rootView.findViewById(R.id.mons53);
        mstart53.setText(monarr[4][3]);
        TextView mstart54= (TextView) rootView.findViewById(R.id.mons54);
        mstart54.setText(monarr[4][4]);

        TextView mstart62= (TextView) rootView.findViewById(R.id.mons62);
        mstart62.setText(monarr[5][2]);
        TextView mstart63= (TextView) rootView.findViewById(R.id.mons63);
        mstart63.setText(monarr[5][3]);
        TextView mstart64= (TextView) rootView.findViewById(R.id.mons64);
        mstart64.setText(monarr[5][4]);

        TextView mstart71= (TextView) rootView.findViewById(R.id.mons71);
        mstart71.setVisibility(View.INVISIBLE);
        TextView mstart72= (TextView) rootView.findViewById(R.id.mons72);
        mstart72.setVisibility(View.INVISIBLE);
        TextView mstart73= (TextView) rootView.findViewById(R.id.mons73);
        mstart73.setVisibility(View.INVISIBLE);
        TextView mstart74= (TextView) rootView.findViewById(R.id.mons74);
        mstart74.setVisibility(View.INVISIBLE);

        TextView mstart81= (TextView) rootView.findViewById(R.id.mons81);
        mstart81.setVisibility(View.INVISIBLE);
        TextView mstart82= (TextView) rootView.findViewById(R.id.mons82);
        mstart82.setVisibility(View.INVISIBLE);
        TextView mstart83= (TextView) rootView.findViewById(R.id.mons83);
        mstart83.setVisibility(View.INVISIBLE);
        TextView mstart84= (TextView) rootView.findViewById(R.id.mons84);
        mstart84.setVisibility(View.INVISIBLE);

//TUESDAY
        TextView tuestart12= (TextView) rootView.findViewById(R.id.tues12);
        tuestart12.setText(tuearr[0][2]);
        TextView tuestart13= (TextView) rootView.findViewById(R.id.tues13);
        tuestart13.setText(tuearr[0][3]);
        TextView tuestart14= (TextView) rootView.findViewById(R.id.tues14);
        tuestart14.setText(tuearr[0][4]);

        TextView tuestart22= (TextView) rootView.findViewById(R.id.tues22);
        tuestart22.setText(tuearr[1][2]);
        TextView tuestart23= (TextView) rootView.findViewById(R.id.tues23);
        tuestart23.setText(tuearr[1][3]);
        TextView tuestart24= (TextView) rootView.findViewById(R.id.tues24);
        tuestart24.setText(tuearr[1][4]);

        TextView tuestart32= (TextView) rootView.findViewById(R.id.tues32);
        tuestart32.setText(tuearr[2][2]);
        TextView tuestart33= (TextView) rootView.findViewById(R.id.tues33);
        tuestart33.setText(tuearr[2][3]);
        TextView tuestart34= (TextView) rootView.findViewById(R.id.tues34);
        tuestart34.setText(tuearr[2][4]);

        TextView tuestart42= (TextView) rootView.findViewById(R.id.tues42);
        tuestart42.setText(tuearr[3][2]);
        TextView tuestart43= (TextView) rootView.findViewById(R.id.tues43);
        tuestart43.setText(tuearr[3][3]);
        TextView tuestart44= (TextView) rootView.findViewById(R.id.tues44);
        tuestart44.setText(tuearr[3][4]);

        TextView tuestart52= (TextView) rootView.findViewById(R.id.tues52);
        tuestart52.setText(tuearr[4][2]);
        TextView tuestart53= (TextView) rootView.findViewById(R.id.tues53);
        tuestart53.setText(tuearr[4][3]);
        TextView tuestart54= (TextView) rootView.findViewById(R.id.tues54);
        tuestart54.setText(tuearr[4][4]);

        TextView tuestart62= (TextView) rootView.findViewById(R.id.tues62);
        tuestart62.setText(tuearr[5][2]);
        TextView tuestart63= (TextView) rootView.findViewById(R.id.tues63);
        tuestart63.setText(tuearr[5][3]);
        TextView tuestart64= (TextView) rootView.findViewById(R.id.tues64);
        tuestart64.setText(tuearr[5][4]);

        TextView tuestart71= (TextView) rootView.findViewById(R.id.tues71);
        tuestart71.setVisibility(View.INVISIBLE);
        TextView tuestart72= (TextView) rootView.findViewById(R.id.tues72);
        tuestart72.setVisibility(View.INVISIBLE);
        TextView tuestart73= (TextView) rootView.findViewById(R.id.tues73);
        tuestart73.setVisibility(View.INVISIBLE);
        TextView tuestart74= (TextView) rootView.findViewById(R.id.tues74);
        tuestart74.setVisibility(View.INVISIBLE);

        TextView tuestart81= (TextView) rootView.findViewById(R.id.tues81);
        tuestart81.setVisibility(View.INVISIBLE);
        TextView tuestart82= (TextView) rootView.findViewById(R.id.tues82);
        tuestart82.setVisibility(View.INVISIBLE);
        TextView tuestart83= (TextView) rootView.findViewById(R.id.tues83);
        tuestart83.setVisibility(View.INVISIBLE);
        TextView tuestart84= (TextView) rootView.findViewById(R.id.tues84);
        tuestart84.setVisibility(View.INVISIBLE);

//WEDNESDAY
        TextView wedstart12= (TextView) rootView.findViewById(R.id.weds12);
        wedstart12.setText(wedarr[0][2]);
        TextView wedstart13= (TextView) rootView.findViewById(R.id.weds13);
        wedstart13.setText(wedarr[0][3]);
        TextView wedstart14= (TextView) rootView.findViewById(R.id.weds14);
        wedstart14.setText(wedarr[0][4]);

        TextView wedstart22= (TextView) rootView.findViewById(R.id.weds22);
        wedstart22.setText(wedarr[1][2]);
        TextView wedstart23= (TextView) rootView.findViewById(R.id.weds23);
        wedstart23.setText(wedarr[1][3]);
        TextView wedstart24= (TextView) rootView.findViewById(R.id.weds24);
        wedstart24.setText(wedarr[1][4]);

        TextView wedstart32= (TextView) rootView.findViewById(R.id.weds32);
        wedstart32.setText(wedarr[2][2]);
        TextView wedstart33= (TextView) rootView.findViewById(R.id.weds33);
        wedstart33.setText(wedarr[2][3]);
        TextView wedstart34= (TextView) rootView.findViewById(R.id.weds34);
        wedstart34.setText(wedarr[2][4]);

        TextView wedstart42= (TextView) rootView.findViewById(R.id.weds42);
        wedstart42.setText(wedarr[3][2]);
        TextView wedstart43= (TextView) rootView.findViewById(R.id.weds43);
        wedstart43.setText(wedarr[3][3]);
        TextView wedstart44= (TextView) rootView.findViewById(R.id.weds44);
        wedstart44.setText(wedarr[3][4]);

        TextView wedstart52= (TextView) rootView.findViewById(R.id.weds52);
        wedstart52.setText(wedarr[4][2]);
        TextView wedstart53= (TextView) rootView.findViewById(R.id.weds53);
        wedstart53.setText(wedarr[4][3]);
        TextView wedstart54= (TextView) rootView.findViewById(R.id.weds54);
        wedstart54.setText(wedarr[4][4]);

        TextView wedstart62= (TextView) rootView.findViewById(R.id.weds62);
        wedstart62.setText(wedarr[5][2]);
        TextView wedstart63= (TextView) rootView.findViewById(R.id.weds63);
        wedstart63.setText(wedarr[5][3]);
        TextView wedstart64= (TextView) rootView.findViewById(R.id.weds64);
        wedstart64.setText(wedarr[5][4]);

        TextView wedstart71= (TextView) rootView.findViewById(R.id.weds71);
        wedstart71.setVisibility(View.INVISIBLE);
        TextView wedstart72= (TextView) rootView.findViewById(R.id.weds72);
        wedstart72.setVisibility(View.INVISIBLE);
        TextView wedstart73= (TextView) rootView.findViewById(R.id.weds73);
        wedstart73.setVisibility(View.INVISIBLE);
        TextView wedstart74= (TextView) rootView.findViewById(R.id.weds74);
        wedstart74.setVisibility(View.INVISIBLE);

        TextView wedstart81= (TextView) rootView.findViewById(R.id.weds81);
        wedstart81.setVisibility(View.INVISIBLE);
        TextView wedstart82= (TextView) rootView.findViewById(R.id.weds82);
        wedstart82.setVisibility(View.INVISIBLE);
        TextView wedstart83= (TextView) rootView.findViewById(R.id.weds83);
        wedstart83.setVisibility(View.INVISIBLE);
        TextView wedstart84= (TextView) rootView.findViewById(R.id.weds84);
        wedstart84.setVisibility(View.INVISIBLE);

//THURSDAY
        TextView thurstart12= (TextView) rootView.findViewById(R.id.thurs12);
        thurstart12.setText(thurarr[0][2]);
        TextView thurstart13= (TextView) rootView.findViewById(R.id.thurs13);
        thurstart13.setText(thurarr[0][3]);
        TextView thurstart14= (TextView) rootView.findViewById(R.id.thurs14);
        thurstart14.setText(thurarr[0][4]);

        TextView thurstart22= (TextView) rootView.findViewById(R.id.thurs22);
        thurstart22.setText(thurarr[1][2]);
        TextView thurstart23= (TextView) rootView.findViewById(R.id.thurs23);
        thurstart23.setText(thurarr[1][3]);
        TextView thurstart24= (TextView) rootView.findViewById(R.id.thurs24);
        thurstart24.setText(thurarr[1][4]);

        TextView thurstart32= (TextView) rootView.findViewById(R.id.thurs32);
        thurstart32.setText(thurarr[2][2]);
        TextView thurstart33= (TextView) rootView.findViewById(R.id.thurs33);
        thurstart33.setText(thurarr[2][3]);
        TextView thurstart34= (TextView) rootView.findViewById(R.id.thurs34);
        thurstart34.setText(thurarr[2][4]);

        TextView thurstart42= (TextView) rootView.findViewById(R.id.thurs42);
        thurstart42.setText(thurarr[3][2]);
        TextView thurstart43= (TextView) rootView.findViewById(R.id.thurs43);
        thurstart43.setText(thurarr[3][3]);
        TextView thurstart44= (TextView) rootView.findViewById(R.id.thurs44);
        thurstart44.setText(thurarr[3][4]);

        TextView thurstart52= (TextView) rootView.findViewById(R.id.thurs52);
        thurstart52.setText(thurarr[4][2]);
        TextView thurstart53= (TextView) rootView.findViewById(R.id.thurs53);
        thurstart53.setText(thurarr[4][3]);
        TextView thurstart54= (TextView) rootView.findViewById(R.id.thurs54);
        thurstart54.setText(thurarr[4][4]);

        TextView thurstart62= (TextView) rootView.findViewById(R.id.thurs62);
        thurstart62.setText(thurarr[5][2]);
        TextView thurstart63= (TextView) rootView.findViewById(R.id.thurs63);
        thurstart63.setText(thurarr[5][3]);
        TextView thurstart64= (TextView) rootView.findViewById(R.id.thurs64);
        thurstart64.setText(thurarr[5][4]);

        TextView thurstart71= (TextView) rootView.findViewById(R.id.thurs71);
        thurstart71.setVisibility(View.INVISIBLE);
        TextView thurstart72= (TextView) rootView.findViewById(R.id.thurs72);
        thurstart72.setVisibility(View.INVISIBLE);
        TextView thurstart73= (TextView) rootView.findViewById(R.id.thurs73);
        thurstart73.setVisibility(View.INVISIBLE);
        TextView thurstart74= (TextView) rootView.findViewById(R.id.thurs74);
        thurstart74.setVisibility(View.INVISIBLE);

        TextView thurstart81= (TextView) rootView.findViewById(R.id.thurs81);
        thurstart81.setVisibility(View.INVISIBLE);
        TextView thurstart82= (TextView) rootView.findViewById(R.id.thurs82);
        thurstart82.setVisibility(View.INVISIBLE);
        TextView thurstart83= (TextView) rootView.findViewById(R.id.thurs83);
        thurstart83.setVisibility(View.INVISIBLE);
        TextView thurstart84= (TextView) rootView.findViewById(R.id.thurs84);
        thurstart84.setVisibility(View.INVISIBLE);

//FRIDAY
        TextView fristart12= (TextView) rootView.findViewById(R.id.fris12);
        fristart12.setText(friarr[0][2]);
        TextView fristart13= (TextView) rootView.findViewById(R.id.fris13);
        fristart13.setText(friarr[0][3]);
        TextView fristart14= (TextView) rootView.findViewById(R.id.fris14);
        fristart14.setText(friarr[0][4]);

        TextView fristart22= (TextView) rootView.findViewById(R.id.fris22);
        fristart22.setText(friarr[1][2]);
        TextView fristart23= (TextView) rootView.findViewById(R.id.fris23);
        fristart23.setText(friarr[1][3]);
        TextView fristart24= (TextView) rootView.findViewById(R.id.fris24);
        fristart24.setText(friarr[1][4]);

        TextView fristart32= (TextView) rootView.findViewById(R.id.fris32);
        fristart32.setText(friarr[2][2]);
        TextView fristart33= (TextView) rootView.findViewById(R.id.fris33);
        fristart33.setText(friarr[2][3]);
        TextView fristart34= (TextView) rootView.findViewById(R.id.fris34);
        fristart34.setText(friarr[2][4]);

        TextView fristart42= (TextView) rootView.findViewById(R.id.fris42);
        fristart42.setText(friarr[3][2]);
        TextView fristart43= (TextView) rootView.findViewById(R.id.fris43);
        fristart43.setText(friarr[3][3]);
        TextView fristart44= (TextView) rootView.findViewById(R.id.fris44);
        fristart44.setText(friarr[3][4]);

        TextView fristart52= (TextView) rootView.findViewById(R.id.fris52);
        fristart52.setText(friarr[4][2]);
        TextView fristart53= (TextView) rootView.findViewById(R.id.fris53);
        fristart53.setText(friarr[4][3]);
        TextView fristart54= (TextView) rootView.findViewById(R.id.fris54);
        fristart54.setText(friarr[4][4]);

        TextView fristart62= (TextView) rootView.findViewById(R.id.fris62);
        fristart62.setText(friarr[5][2]);
        TextView fristart63= (TextView) rootView.findViewById(R.id.fris63);
        fristart63.setText(friarr[5][3]);
        TextView fristart64= (TextView) rootView.findViewById(R.id.fris64);
        fristart64.setText(friarr[5][4]);

        TextView fristart71= (TextView) rootView.findViewById(R.id.fris71);
        fristart71.setVisibility(View.INVISIBLE);
        TextView fristart72= (TextView) rootView.findViewById(R.id.fris72);
        fristart72.setVisibility(View.INVISIBLE);
        TextView fristart73= (TextView) rootView.findViewById(R.id.fris73);
        fristart73.setVisibility(View.INVISIBLE);
        TextView fristart74= (TextView) rootView.findViewById(R.id.fris74);
        fristart74.setVisibility(View.INVISIBLE);

        TextView fristart81= (TextView) rootView.findViewById(R.id.fris81);
        fristart81.setVisibility(View.INVISIBLE);
        TextView fristart82= (TextView) rootView.findViewById(R.id.fris82);
        fristart82.setVisibility(View.INVISIBLE);
        TextView fristart83= (TextView) rootView.findViewById(R.id.fris83);
        fristart83.setVisibility(View.INVISIBLE);
        TextView fristart84= (TextView) rootView.findViewById(R.id.fris84);
        fristart84.setVisibility(View.INVISIBLE);


        montable.setVisibility(View.GONE);
        tuestable.setVisibility(View.GONE);
        wednestable.setVisibility(View.GONE);
        thurstable.setVisibility(View.GONE);
        fritable.setVisibility(View.GONE);
        saturtable.setVisibility(View.GONE);

        mondayb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(montable.getVisibility() != View.VISIBLE)
                        {
                            tuestable.setVisibility(View.GONE);
                            wednestable.setVisibility(View.GONE);
                            thurstable.setVisibility(View.GONE);
                            fritable.setVisibility(View.GONE);
                            saturtable.setVisibility(View.GONE);
                            montable.setVisibility(View.VISIBLE);
                        }
                        else
                            montable.setVisibility(View.GONE);

                    }
                });

        tuesdayb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(tuestable.getVisibility() != View.VISIBLE)
                        {
                            montable.setVisibility(View.GONE);
                            wednestable.setVisibility(View.GONE);
                            thurstable.setVisibility(View.GONE);
                            fritable.setVisibility(View.GONE);
                            saturtable.setVisibility(View.GONE);
                            tuestable.setVisibility(View.VISIBLE);
                        }
                        else
                            tuestable.setVisibility(View.GONE);

                    }
                });

        wednesdayb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(wednestable.getVisibility() != View.VISIBLE)
                        {
                            montable.setVisibility(View.GONE);
                            tuestable.setVisibility(View.GONE);
                            thurstable.setVisibility(View.GONE);
                            fritable.setVisibility(View.GONE);
                            saturtable.setVisibility(View.GONE);
                            wednestable.setVisibility(View.VISIBLE);
                        }
                        else
                            wednestable.setVisibility(View.GONE);

                    }
                });

        thursdayb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(thurstable.getVisibility() != View.VISIBLE)
                        {
                            montable.setVisibility(View.GONE);
                            tuestable.setVisibility(View.GONE);
                            wednestable.setVisibility(View.GONE);
                            fritable.setVisibility(View.GONE);
                            saturtable.setVisibility(View.GONE);
                            thurstable.setVisibility(View.VISIBLE);
                        }
                        else
                            thurstable.setVisibility(View.GONE);

                    }
                });

        fridayb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(fritable.getVisibility() != View.VISIBLE)
                        {
                            montable.setVisibility(View.GONE);
                            tuestable.setVisibility(View.GONE);
                            wednestable.setVisibility(View.GONE);
                            thurstable.setVisibility(View.GONE);
                            saturtable.setVisibility(View.GONE);
                            fritable.setVisibility(View.VISIBLE);
                        }
                        else
                            fritable.setVisibility(View.GONE);

                    }
                });

        saturdayb.setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(saturtable.getVisibility() != View.VISIBLE)
                        {
                            montable.setVisibility(View.GONE);
                            tuestable.setVisibility(View.GONE);
                            wednestable.setVisibility(View.GONE);
                            thurstable.setVisibility(View.GONE);
                            fritable.setVisibility(View.GONE);
                            saturtable.setVisibility(View.VISIBLE);
                        }
                        else
                            saturtable.setVisibility(View.GONE);

                    }
                });


    }

    public void clicker()
    {
        lv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            public void onGroupExpand(int groupPosition) {
                try {
                    for(int i=0; i<groups.length; i++) {
                        if(i != groupPosition) {
                            lv.collapseGroup(i);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /*public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;
        private String[] groups;
        private String[][] children;

        public ExpandableListAdapter(String[] groups, String[][] children) {
            this.groups = groups;
            this.children = children;
            inf = LayoutInflater.from(getActivity());
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();

                holder.text = (TextView) convertView.findViewById(R.id.lblListItem);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;

            clicker();

            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_group, parent, false);

                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.lblListHeader);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getGroup(groupPosition).toString());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private class ViewHolder {
            TextView text;
        }
    }*/
}
