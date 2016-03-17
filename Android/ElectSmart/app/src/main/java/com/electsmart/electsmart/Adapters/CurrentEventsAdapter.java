package com.electsmart.electsmart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.electsmart.electsmart.Models.CurrentEvent;
import com.electsmart.electsmart.R;

import java.util.ArrayList;

/**
 * Created by Scott on 3/11/2016.
 */
public class CurrentEventsAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater mInflater;
    private ArrayList<CurrentEvent> currentEvents;

    public CurrentEventsAdapter(Context context, ArrayList<CurrentEvent> currentEvents) {
        System.out.println("CurrentEvents: IN CONSTRUCTOR");
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.currentEvents = currentEvents;
    }

    @Override
    public int getCount(){
        System.out.println("CurrentEvents: IN GET COUNT " + currentEvents.size());
        return currentEvents.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return currentEvents.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CurrentEvent currentEvent = currentEvents.get(position);
        System.out.println("CurrentEvents: IN GET VIEW");
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.current_events_list_item, parent, false);
        }
        // Lookup view for data population
        /*
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        */

        ImageView srcImage = (ImageView) convertView.findViewById(R.id.sourceImage);
        srcImage.setImageResource(R.drawable.drumpf);

        TextView title = (TextView) convertView.findViewById(R.id.EventTitleText);
        title.setText("Drumpf");

        // Populate the data into the template view using the data object
        //tvName.setText(election.date);

        // Return the completed view to render on screen
        return convertView;
    }
}
