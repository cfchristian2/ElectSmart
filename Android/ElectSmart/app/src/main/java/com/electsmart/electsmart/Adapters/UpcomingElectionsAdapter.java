package com.electsmart.electsmart.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.electsmart.electsmart.Models.UpcomingElectionRow;
import com.electsmart.electsmart.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brand on 3/11/2016.
 */
public class UpcomingElectionsAdapter extends BaseAdapter {
    Context context;
    List<UpcomingElectionRow> upcomingElectionList;

    public UpcomingElectionsAdapter(Context context, List<UpcomingElectionRow> upcomingElectionsList) {
        this.context = context;
        this.upcomingElectionList = upcomingElectionsList;
    }

    @Override
    public int getCount() {

        return upcomingElectionList.size();
    }

    @Override
    public Object getItem(int position){
        return upcomingElectionList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return upcomingElectionList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.fragment_upcoming_elections_listview_row, null);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_upcoming_elections_listview_row, parent, false);
        }

        TextView leftElectionDate = (TextView) convertView.findViewById(R.id.UpcomingElection_Calendar_Date_Left);
        TextView rightElectionDate = (TextView) convertView.findViewById(R.id.UpcomingElection_Calendar_Date_Right);
        TextView leftElectionName = (TextView) convertView.findViewById(R.id.UpcomingElection_Title_Left);
        TextView rightElectionName = (TextView) convertView.findViewById(R.id.UpcomingElection_Title_Right);

        UpcomingElectionRow row1 = upcomingElectionList.get(position);

        leftElectionDate.setText(" " + row1.getLeft().getDay() + " ");
        rightElectionDate.setText(" " + row1.getRight().getDay() + " ");

        leftElectionName.setText(row1.getLeft().getName());
        rightElectionName.setText(row1.getRight().getName());

        return convertView;
    }
}