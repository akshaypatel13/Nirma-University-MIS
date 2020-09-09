package com.mis.nirma.nirmauniversitymis;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;


public class stud_ResultFragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    public String[] groups;
    public String[][] children;

    /*public void LineupFragment() {

    }*/

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);


        ArrayList<ArrayList<String>> groupsArray = new ArrayList<>();
        groupsArray = StudentLoginActivity.getSemesters();

        int groupSize = groupsArray.size();

        for(int i=1; i<=groupSize; i++)
        {
            System.out.println("Semester " + i);
        }

        children = new String[groupSize][];

        for(int j=1; j<=groupSize; j++)
        {
            children[j-1] = new String[groupsArray.get(j-1).size()];
            for(int k=1; k<=groupsArray.get(j-1).size(); k++)
            {
                System.out.println(groupsArray.get(j-1).get(k-1));

            }
        }

        groups = new String[groupSize];

        for(int i=1; i<=groupSize; i++)
        {
            groups[i-1] = "Semester - " + i;
        }

        children = new String[groupSize][];

        for(int j=1; j<=groupSize; j++)
        {
            children[j-1] = new String[groupsArray.get(j-1).size()];
            for(int k=1; k<=groupsArray.get(j-1).size(); k++)
            {
                children[j-1][k-1] = groupsArray.get(j-1).get(k-1);

            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.stud_result, container, false);

        return rootView;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.lvExp);
        lv.setAdapter(new ExpandableListAdapter(groups, children));
        lv.setGroupIndicator(null);

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

    private class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;
        private String[] groups;
        private String[][] children;

        private ExpandableListAdapter(String[] groups, String[][] children) {
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
    }
}
