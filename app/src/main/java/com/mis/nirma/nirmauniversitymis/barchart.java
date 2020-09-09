package com.mis.nirma.nirmauniversitymis;

/*
Minor Changes from MAC
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class barchart extends AppCompatActivity {

    HorizontalBarChart  chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud_attendance);
        chart = (HorizontalBarChart) findViewById(R.id.barchart1);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Projects");

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);

    }

    public void AddValuesToBARENTRY(){

        BARENTRY.add(new BarEntry(2f, 0));
        BARENTRY.add(new BarEntry(4f, 1));
        BARENTRY.add(new BarEntry(6f, 2));
        BARENTRY.add(new BarEntry(8f, 3));
        BARENTRY.add(new BarEntry(7f, 4));
        BARENTRY.add(new BarEntry(3f, 5));

    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("January");
        BarEntryLabels.add("February");
        BarEntryLabels.add("March");
        BarEntryLabels.add("April");
        BarEntryLabels.add("May");
        BarEntryLabels.add("June");

    }
}
