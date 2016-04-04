package com.electsmart.electsmart.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.electsmart.electsmart.API.Faroo.Models.FarooArticle;
import com.electsmart.electsmart.DownloadImageTask;
import com.electsmart.electsmart.R;

import java.util.ArrayList;

/**
 * Created by Scott on 3/11/2016.
 */
public class CurrentEventsAdapter extends ArrayAdapter<FarooArticle> {
    private Context context;
    private ArrayList<FarooArticle> currentEvents;

    public CurrentEventsAdapter(Context context, ArrayList<FarooArticle> currentEvents) {
        super(context, 0, currentEvents);
        this.context = context;
        this.currentEvents = currentEvents;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final FarooArticle currentEvent = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.current_events_list_item, parent, false);
        }

        RelativeLayout currentEventsArticlePeeker = (RelativeLayout) convertView.findViewById(R.id.currentEventsArticlePeek);
        currentEventsArticlePeeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse(currentEvent.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getContext().startActivity(intent);
                //Uri uri = Uri.parse(currentEvent.getUrl());
                //Intent intent = new Intent(, ArticleActivity.class);
                //intent.putExtra("uri", uri);
                //getContext().startActivity(intent);
            }
        });

        TextView title = (TextView) convertView.findViewById(R.id.EventTitleText);
        title.setText(currentEvent.getTitle());
        getImage(currentEvent.getIurl(), convertView);




        // Populate the data into the template view using the data object
        //tvName.setText(election.date);

        // Return the completed view to render on screen
        return convertView;
    }

    private void getImage(String ImageUrl, View convertView){
        try{
            new DownloadImageTask((ImageView) convertView.findViewById(R.id.sourceImage)).execute(ImageUrl);
        }catch (Exception ex){

        }
    }
}
