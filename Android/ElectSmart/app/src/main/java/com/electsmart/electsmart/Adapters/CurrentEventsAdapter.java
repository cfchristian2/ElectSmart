package com.electsmart.electsmart.Adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.electsmart.electsmart.Fragments.ArticleFragment;
import com.electsmart.electsmart.Models.CurrentEvent;
import com.electsmart.electsmart.R;

import java.util.ArrayList;

/**
 * Created by Scott on 3/11/2016.
 */
public class CurrentEventsAdapter extends ArrayAdapter<CurrentEvent> {
    private Context context;
    private ArrayList<CurrentEvent> currentEvents;

    public CurrentEventsAdapter(Context context, ArrayList<CurrentEvent> currentEvents) {
        super(context, 0, currentEvents);
        this.context = context;
        this.currentEvents = currentEvents;
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





        RelativeLayout currentEventsArticlePeeker = (RelativeLayout) convertView.findViewById(R.id.currentEventsArticlePeek);
        currentEventsArticlePeeker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final ArticleFragment articleFragment = ArticleFragment.newInstance();
                final FragmentManager fragmentManager = articleFragment.getFragmentManager();
                final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.main_content, articleFragment);
                fragmentTransaction.commit();

                //Intent intent = new Intent(context, ArticleActivity.class);
                //getContext().startActivity(intent);
            }
        });

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
