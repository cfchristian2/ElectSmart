package com.electsmart.electsmart.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.electsmart.electsmart.API.Choreo.Models.Response;
import com.electsmart.electsmart.Activities.ThreadActivity;
import com.electsmart.electsmart.R;

import java.util.List;

/**
 * Created by Scott on 3/11/2016.
 */
public class ForumAdapter extends ArrayAdapter<Response> {
    private Context context;
    private List<Response> Threads;

    public ForumAdapter(Context context, List<Response> threads) {
        super(context, 0, threads);
        this.context = context;
        this.Threads = threads;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Response currentThread = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.forum_list_item, parent, false);
        }
        TextView threadTitle = (TextView) convertView.findViewById(R.id.ForumTitle);
        TextView threadTime = (TextView) convertView.findViewById(R.id.TimePassed);
        TextView threadReplies = (TextView) convertView.findViewById(R.id.repliesText);
        threadTitle.setText(currentThread.getTitle());
        threadTime.setText(currentThread.getCreatedAt());
        threadReplies.setText(currentThread.getPosts() + " Posts");

        RelativeLayout threadContainer = (RelativeLayout) convertView.findViewById(R.id.ForumContent);
        threadContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ThreadActivity.class);
                context.startActivity(intent);
            }
        });




        // Populate the data into the template view using the data object
        //tvName.setText(election.date);

        // Return the completed view to render on screen
        return convertView;
    }
}
