package com.electsmart.electsmart.Activities;

import android.app.ListActivity;
import android.os.Bundle;

import com.electsmart.electsmart.API.Choreo.DisqusTask;
import com.electsmart.electsmart.API.Choreo.Models.Response;
import com.electsmart.electsmart.Adapters.ForumAdapter;
import com.electsmart.electsmart.R;

import java.util.ArrayList;
import java.util.List;

public class Forum extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        List<Response> responses = new ArrayList<>();
        ForumAdapter forumAdapter = new ForumAdapter(this, responses);
        setListAdapter(forumAdapter);
        new DisqusTask(forumAdapter).execute();
    }
}
