package com.electsmart.electsmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.electsmart.electsmart.Models.CurrentEvent;
import com.electsmart.electsmart.R;

import java.util.ArrayList;

/**
 * Created by Scott on 3/11/2016.
 */
public class CurrentEventsAdapter extends ArrayAdapter<CurrentEvent> {
    public CurrentEventsAdapter(Context context, ArrayList<CurrentEvent> currentEvents) {
        super(context, 0, currentEvents);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CurrentEvent currentEvent = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.current_events_list_item, parent, false);
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
