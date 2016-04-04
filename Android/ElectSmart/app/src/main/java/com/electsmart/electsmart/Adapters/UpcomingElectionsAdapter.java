package com.electsmart.electsmart.Adapters;

import android.app.Activity;

import android.support.v4.app.*;
import android.content.Context;
import android.support.v7.widget.util.SortedListAdapterCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.electsmart.electsmart.ElectionFragment;
import com.electsmart.electsmart.Messages.ElectionMessage;
import com.electsmart.electsmart.Models.UpcomingElectionRow;
import com.electsmart.electsmart.R;
import com.electsmart.electsmart.UpcomingElectionsCallback;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by brand on 3/11/2016.
 */
public class UpcomingElectionsAdapter extends BaseAdapter{
    Context context;
    List<UpcomingElectionRow> upcomingElectionList;
    private UpcomingElectionsCallback mAdapterCallback;
    public UpcomingElectionsAdapter(Context context, List<UpcomingElectionRow> upcomingElectionsList, UpcomingElectionsCallback callback) {
        this.context = context;
        this.upcomingElectionList = upcomingElectionsList;
        this.mAdapterCallback = callback;
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
            convertView = mInflater.inflate(R.layout.upcoming_elections_listview_row, null);
        }

        TextView leftElectionDate = (TextView) convertView.findViewById(R.id.UpcomingElection_Calendar_Date_Left);
        TextView rightElectionDate = (TextView) convertView.findViewById(R.id.UpcomingElection_Calendar_Date_Right);
        TextView leftElectionName = (TextView) convertView.findViewById(R.id.UpcomingElection_Title_Left);
        TextView rightElectionName = (TextView) convertView.findViewById(R.id.UpcomingElection_Title_Right);

        final UpcomingElectionRow row = upcomingElectionList.get(position);

        leftElectionDate.setText(" " + row.getLeft().getDay() + " ");
        rightElectionDate.setText(" " + row.getRight().getDay() + " ");

        leftElectionName.setText(row.getLeft().getName());
        rightElectionName.setText(row.getRight().getName());

        convertView.findViewById(R.id.leftElection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onElectionClick(row.getLeft());
            }
        });

        convertView.findViewById(R.id.rightElection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapterCallback.onElectionClick(row.getLeft());
            }
        });
        return convertView;
    }
}