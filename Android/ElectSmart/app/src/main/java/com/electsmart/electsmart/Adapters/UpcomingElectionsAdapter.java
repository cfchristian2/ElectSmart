package com.electsmart.electsmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.electsmart.electsmart.Models.UpcomingElection;
import com.electsmart.electsmart.R;

import java.util.ArrayList;

/**
 * Created by brand on 3/11/2016.
 */
public class UpcomingElectionsAdapter extends ArrayAdapter<UpcomingElection> {
    public UpcomingElectionsAdapter(Context context, ArrayList<UpcomingElection> upcomingElections) {
        super(context, 0, upcomingElections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        UpcomingElection election = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_upcoming_elections_listview_row, parent, false);
        }
        // Lookup view for data population
        /*
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        */

        // Populate the data into the template view using the data object
        //tvName.setText(election.date);

        // Return the completed view to render on screen
        return convertView;
    }
}