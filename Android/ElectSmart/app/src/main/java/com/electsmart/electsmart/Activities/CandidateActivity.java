package com.electsmart.electsmart.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.Adapters.ElectionAdapter;
import com.electsmart.electsmart.DownloadImageTask;
import com.electsmart.electsmart.Models.Election;
import com.electsmart.electsmart.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    }
}

