package com.mis.nirma.nirmauniversitymis;

import android.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;


public class stud_AttendanceFragment extends Fragment implements OnChartGestureListener {



    View rootView;
    HorizontalBarChart [] charts = new HorizontalBarChart[13];
    BarData [] BARDATA = new BarData[13];
    Button [] Sub = new Button[13];
    TextView NA;
    int sub_count = 0;



    HashMap < String , HashMap <String,Integer> > subject = new HashMap<String , HashMap<String, Integer> >();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.stud_attendance, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NA = (TextView)rootView.findViewById(R.id.NA);
        NA.setVisibility(View.GONE);

        final View layout[]  = new View[13];

        layout[1] = rootView.findViewById(R.id.bar1);
        layout[2] = rootView.findViewById(R.id.bar2);
        layout[3] = rootView.findViewById(R.id.bar3);
        layout[4] = rootView.findViewById(R.id.bar4);
        layout[5] = rootView.findViewById(R.id.bar5);
        layout[6] = rootView.findViewById(R.id.bar6);
        layout[7] = rootView.findViewById(R.id.bar7);
        layout[8] = rootView.findViewById(R.id.bar8);
        layout[9] = rootView.findViewById(R.id.bar9);
        layout[10] = rootView.findViewById(R.id.bar10);
        layout[11] = rootView.findViewById(R.id.bar11);
        layout[12] = rootView.findViewById(R.id.bar12);

        Sub[1] = (Button)rootView.findViewById(R.id.Sub1);
        Sub[2] = (Button)rootView.findViewById(R.id.Sub2);
        Sub[3] = (Button)rootView.findViewById(R.id.Sub3);
        Sub[4] = (Button)rootView.findViewById(R.id.Sub4);
        Sub[5] = (Button)rootView.findViewById(R.id.Sub5);
        Sub[6] = (Button)rootView.findViewById(R.id.Sub6);
        Sub[7] = (Button)rootView.findViewById(R.id.Sub7);
        Sub[8] = (Button)rootView.findViewById(R.id.Sub8);
        Sub[9] = (Button)rootView.findViewById(R.id.Sub9);
        Sub[10] = (Button)rootView.findViewById(R.id.Sub10);
        Sub[11] = (Button)rootView.findViewById(R.id.Sub11);
        Sub[12] = (Button)rootView.findViewById(R.id.Sub12);

        charts[1] = (HorizontalBarChart) rootView.findViewById(R.id.barchart1);
        charts[2] = (HorizontalBarChart) rootView.findViewById(R.id.barchart2);
        charts[3] = (HorizontalBarChart) rootView.findViewById(R.id.barchart3);
        charts[4] = (HorizontalBarChart) rootView.findViewById(R.id.barchart4);
        charts[5] = (HorizontalBarChart) rootView.findViewById(R.id.barchart5);
        charts[6] = (HorizontalBarChart) rootView.findViewById(R.id.barchart6);
        charts[7] = (HorizontalBarChart) rootView.findViewById(R.id.barchart7);
        charts[8] = (HorizontalBarChart) rootView.findViewById(R.id.barchart8);
        charts[9] = (HorizontalBarChart) rootView.findViewById(R.id.barchart9);
        charts[10] = (HorizontalBarChart) rootView.findViewById(R.id.barchart10);
        charts[11] = (HorizontalBarChart) rootView.findViewById(R.id.barchart11);
        charts[12] = (HorizontalBarChart) rootView.findViewById(R.id.barchart12);


        SetBARDATA();

        if(sub_count==0){
            NA.setVisibility(View.VISIBLE);
        }

        for(int i = sub_count+1;i<13;i++)
            Sub[i].setVisibility(View.GONE);


        Sub[1].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[1].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[1].setVisibility(View.VISIBLE);
                            charts[1] = (HorizontalBarChart) rootView.findViewById(R.id.barchart1);
                            charts[1].setData(BARDATA[1]);
                            charts[1].animateXY(3000,3000);
                            charts[1].getAxisRight().setAxisMinValue(0);
                            charts[1].getAxisLeft().setAxisMinValue(0);
                            charts[1].getAxisRight().setAxisMaxValue(100);
                            charts[1].getAxisLeft().setAxisMaxValue(100);
                            charts[1].setDescription("");

                        }
                        else
                            layout[1].setVisibility(View.GONE);

                    }
                });
        Sub[2].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[2].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[2].setVisibility(View.VISIBLE);
                            charts[2] = (HorizontalBarChart) rootView.findViewById(R.id.barchart2);
                            charts[2].setData(BARDATA[2]);
                            charts[2].animateXY(3000,3000);
                            charts[2].getAxisRight().setAxisMinValue(0);
                            charts[2].getAxisLeft().setAxisMinValue(0);
                            charts[2].getAxisRight().setAxisMaxValue(100);
                            charts[2].getAxisLeft().setAxisMaxValue(100);
                            charts[2].setDescription("");

                        }
                        else
                            layout[2].setVisibility(View.GONE);

                    }
                });
        Sub[3].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[3].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[3].setVisibility(View.VISIBLE);
                            charts[3] = (HorizontalBarChart) rootView.findViewById(R.id.barchart3);
                            charts[3].setData(BARDATA[3]);
                            charts[3].animateXY(3000,3000);
                            charts[3].getAxisRight().setAxisMinValue(0);
                            charts[3].getAxisLeft().setAxisMinValue(0);
                            charts[3].getAxisRight().setAxisMaxValue(100);
                            charts[3].getAxisLeft().setAxisMaxValue(100);
                            charts[3].setDescription("");

                        }
                        else
                            layout[3].setVisibility(View.GONE);

                    }
                });
        Sub[4].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[4].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[4].setVisibility(View.VISIBLE);
                            charts[4] = (HorizontalBarChart) rootView.findViewById(R.id.barchart4);
                            charts[4].setData(BARDATA[4]);
                            charts[4].animateXY(3000,3000);
                            charts[4].getAxisRight().setAxisMinValue(0);
                            charts[4].getAxisLeft().setAxisMinValue(0);
                            charts[4].getAxisRight().setAxisMaxValue(100);
                            charts[4].getAxisLeft().setAxisMaxValue(100);
                            charts[4].setDescription("");

                        }
                        else
                            layout[4].setVisibility(View.GONE);

                    }
                });
        Sub[5].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[5].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[5].setVisibility(View.VISIBLE);
                            charts[5] = (HorizontalBarChart) rootView.findViewById(R.id.barchart5);
                            charts[5].setData(BARDATA[5]);
                            charts[5].animateXY(3000,3000);
                            charts[5].getAxisRight().setAxisMinValue(0);
                            charts[5].getAxisLeft().setAxisMinValue(0);
                            charts[5].getAxisRight().setAxisMaxValue(100);
                            charts[5].getAxisLeft().setAxisMaxValue(100);
                            charts[5].setDescription("");

                        }
                        else
                            layout[5].setVisibility(View.GONE);

                    }
                });
        Sub[6].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[6].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[6].setVisibility(View.VISIBLE);
                            charts[6] = (HorizontalBarChart) rootView.findViewById(R.id.barchart6);
                            charts[6].setData(BARDATA[6]);
                            charts[6].animateXY(3000,3000);
                            charts[6].getAxisRight().setAxisMinValue(0);
                            charts[6].getAxisLeft().setAxisMinValue(0);
                            charts[6].getAxisRight().setAxisMaxValue(100);
                            charts[6].getAxisLeft().setAxisMaxValue(100);
                            charts[6].setDescription("");

                        }
                        else
                            layout[6].setVisibility(View.GONE);

                    }
                });

        Sub[7].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[7].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[7].setVisibility(View.VISIBLE);
                            charts[7] = (HorizontalBarChart) rootView.findViewById(R.id.barchart7);
                            charts[7].setData(BARDATA[7]);
                            charts[7].animateXY(3000,3000);
                            charts[7].getAxisRight().setAxisMinValue(0);
                            charts[7].getAxisLeft().setAxisMinValue(0);
                            charts[7].getAxisRight().setAxisMaxValue(100);
                            charts[7].getAxisLeft().setAxisMaxValue(100);
                            charts[7].setDescription("");

                        }
                        else
                            layout[7].setVisibility(View.GONE);

                    }
                });
        Sub[8].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[8].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[8].setVisibility(View.VISIBLE);
                            charts[8] = (HorizontalBarChart) rootView.findViewById(R.id.barchart8);
                            charts[8].setData(BARDATA[8]);
                            charts[8].animateXY(3000,3000);
                            charts[8].getAxisRight().setAxisMinValue(0);
                            charts[8].getAxisLeft().setAxisMinValue(0);
                            charts[8].getAxisRight().setAxisMaxValue(100);
                            charts[8].getAxisLeft().setAxisMaxValue(100);
                            charts[8].setDescription("");

                        }
                        else
                            layout[8].setVisibility(View.GONE);

                    }
                });
        Sub[9].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[9].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[9].setVisibility(View.VISIBLE);
                            charts[9] = (HorizontalBarChart) rootView.findViewById(R.id.barchart9);
                            charts[9].setData(BARDATA[9]);
                            charts[9].animateXY(3000,3000);
                            charts[9].getAxisRight().setAxisMinValue(0);
                            charts[9].getAxisLeft().setAxisMinValue(0);
                            charts[9].getAxisRight().setAxisMaxValue(100);
                            charts[9].getAxisLeft().setAxisMaxValue(100);
                            charts[9].setDescription("");

                        }
                        else
                            layout[9].setVisibility(View.GONE);

                    }
                });
        Sub[10].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[10].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[10].setVisibility(View.VISIBLE);
                            charts[10] = (HorizontalBarChart) rootView.findViewById(R.id.barchart10);
                            charts[10].setData(BARDATA[10]);
                            charts[10].animateXY(3000,3000);
                            charts[10].getAxisRight().setAxisMinValue(0);
                            charts[10].getAxisLeft().setAxisMinValue(0);
                            charts[10].getAxisRight().setAxisMaxValue(100);
                            charts[10].getAxisLeft().setAxisMaxValue(100);
                            charts[10].setDescription("");

                        }
                        else
                            layout[10].setVisibility(View.GONE);

                    }
                });
        Sub[11].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[11].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[11].setVisibility(View.VISIBLE);
                            charts[11] = (HorizontalBarChart) rootView.findViewById(R.id.barchart11);
                            charts[11].setData(BARDATA[11]);
                            charts[11].animateXY(3000,3000);
                            charts[11].getAxisRight().setAxisMinValue(0);
                            charts[11].getAxisLeft().setAxisMinValue(0);
                            charts[11].getAxisRight().setAxisMaxValue(100);
                            charts[11].getAxisLeft().setAxisMaxValue(100);
                            charts[11].setDescription("");

                        }
                        else
                            layout[11].setVisibility(View.GONE);

                    }
                });
        Sub[12].setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(layout[12].getVisibility() != View.VISIBLE)
                        {
                            for(int i =1 ;i<13;i++)
                            {
                                layout[i].setVisibility(View.GONE);
                            }

                            layout[12].setVisibility(View.VISIBLE);
                            charts[12] = (HorizontalBarChart) rootView.findViewById(R.id.barchart12);
                            charts[12].setData(BARDATA[12]);
                            charts[12].animateXY(3000,3000);
                            charts[12].getAxisRight().setAxisMinValue(0);
                            charts[12].getAxisLeft().setAxisMinValue(0);
                            charts[12].getAxisRight().setAxisMaxValue(100);
                            charts[12].getAxisLeft().setAxisMaxValue(100);
                            charts[12].setDescription("");

                        }
                        else
                            layout[12].setVisibility(View.GONE);

                    }
                });


        for(int i = 1;i<=sub_count;i++)
        {
            charts[i].setOnChartGestureListener(this);
        }

    }

    private void SetBARDATA() {

        subject = StudentLoginActivity.getSubject();
        int i = 0;
//        int cn = 0;
        Iterator it = subject.entrySet().iterator();
        while (it.hasNext()) {
            i++;
            Map.Entry pair = (Map.Entry)it.next();

            String sub_code = (String) pair.getKey();
            System.out.println(pair.getKey() + " = " + pair.getValue());

            HashMap <String,Integer> map ;
            map = subject.get(sub_code);
            Sub[i].setText(sub_code);

            ArrayList<BarEntry> BARENTRY = new ArrayList<BarEntry>();
            ArrayList<String> BarEntryLabels = new ArrayList<String>();
            BarDataSet Bardataset ;

            float lp = 0,ln= 0,pp= 0,pn = 0,tp= 0,tn= 0;
            if(map.containsKey("LY"))
            {

                lp = map.get("LY");

            }

            if(map.containsKey("LN"))
            {

                ln = map.get("LN");

            }

            if(map.containsKey("PY"))
            {
                pp = map.get("PY");

            }

            if(map.containsKey("PN"))
            {
                pn = map.get("PN");

            }


            if(map.containsKey("TY"))
            {
                tp = map.get("TY");

            }


            if(map.containsKey("TN"))
            {
                tn = map.get("TN");

            }
            int cn = 0;
            if(lp+ln > 0)
            {
                BarEntryLabels.add("Lacture");
                BARENTRY.add(new BarEntry(100*(lp/(lp+ln)),cn++));
            }
            if(pp+pn > 0)
            {
                BarEntryLabels.add("Practical");
                BARENTRY.add(new BarEntry(100*(pp/(pp+pn)),cn++));
            }
            if(tp+tn > 0)
            {
                BarEntryLabels.add("Tutorial");
                BARENTRY.add(new BarEntry(100*(tp/(tp+tn)),cn++));
            }

            System.out.println(tp/(tp+tn+1) + "  " + lp/(lp+ln+1) + "  " + pp/(pp+pn+1));
            Bardataset = new BarDataSet(BARENTRY,sub_code);

            BARDATA[i] = new BarData(BarEntryLabels,Bardataset);

            Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);


            it.remove(); // avoids a ConcurrentModificationException

        }
        sub_count = i;

    }



    public void showPopup(View anchorView) {

        View popupView = getActivity().getLayoutInflater().inflate(R.layout.popup_attendance, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);

        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorView, Gravity.CENTER,0,0);

    }

    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Toast.makeText(getActivity(),"Fetching Details.." ,Toast.LENGTH_LONG).show();
        showPopup(rootView);
    }

    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }


    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }


}