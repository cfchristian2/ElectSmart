package com.electsmart.electsmart.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.Adapters.ElectionAdapter;
import com.electsmart.electsmart.Models.Election;
import com.electsmart.electsmart.R;

import java.util.HashMap;
import java.util.List;

public class ElectionActivity extends AppCompatActivity {

    private Election election;
    ElectionAdapter adapter;
    View rootView;
    ExpandableListView expListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            election = (Election) getIntent().getSerializableExtra("election");
            List<String> openPositions = election.getOpenPositions();
            List<Candidate> candidates = election.getCandidates(election.getOpenPositions().get(0));
            HashMap<String, List<Candidate>> candidatePositionMap = election.getMap();

            expListView = (ExpandableListView) findViewById(R.id.expList);
            adapter = new ElectionAdapter(this, election.getOpenPositions(), election.getMap());
            expListView.setAdapter(adapter);
            expListView.setGroupIndicator(null);
    }
}
