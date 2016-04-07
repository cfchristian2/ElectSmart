package com.electsmart.electsmart.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.Adapters.ElectionAdapter;
import com.electsmart.electsmart.DownloadImageTask;
import com.electsmart.electsmart.R;

public class CandidateActivity extends AppCompatActivity {

    private Candidate candidate;
    ElectionAdapter adapter;
    View rootView;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_candidate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        candidate = (Candidate) getIntent().getSerializableExtra("candidate");

        //Set elements
        ((TextView) findViewById(R.id.Candidate_Name)).setText(candidate.getName());

        new DownloadImageTask(((ImageView) findViewById(R.id.CandidatePhoto))).execute(candidate.getPhotoUrl());

        ImageButton candidateButton = (ImageButton) findViewById(R.id.candidateForum);
        candidateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Forum.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}


