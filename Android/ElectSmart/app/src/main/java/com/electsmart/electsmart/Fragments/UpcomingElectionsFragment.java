package com.electsmart.electsmart.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.R;


import com.electsmart.electsmart.Adapters.UpcomingElectionsAdapter;
import com.electsmart.electsmart.Models.Election;
import com.electsmart.electsmart.Models.UpcomingElectionRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpcomingElectionsFragment extends Fragment {

    private static final String TAG = UpcomingElectionsFragment.class.getSimpleName();
    private List<UpcomingElectionRow> upcomingElectionList;
    private UpcomingElectionsAdapter adapter;

    public UpcomingElectionsFragment() {
        // Required empty public constructor
    }

    public static UpcomingElectionsFragment newInstance() {
        UpcomingElectionsFragment fragment = new UpcomingElectionsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upcoming_elections, null, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        List<String> openPositions = new ArrayList<String>();
        List<Candidate> candidates = new ArrayList<Candidate>();
        HashMap<String, List<Candidate>> candidatePositionMap = new HashMap<String, List<Candidate>>();

        //DUMMY DATA IN PLACE OF APIS
        for(int j = 0; j < 3; j++){
            candidates.add(new Candidate("Candidate " + j, "Democrat", null, null, "http://amiloszportraits.com/wp-content/uploads/2015/12/barack%20obama%20thumbs%20up%20meme-drunk-obama-thumbs-up.jpg", null, 0, null));
        }
        for(int i = 0; i < 5; i++){
            openPositions.add("Position " + i);
            candidatePositionMap.put(openPositions.get(i), candidates);
        }
        Election elec1 = new Election(01, 01, 2017, 0, "First Election", candidatePositionMap);
        Election elec2 = new Election(12, 31, 2017, 1, "Second Election", candidatePositionMap);
        Election elec3 = new Election(02, 02, 2018, 2, "Third Election", candidatePositionMap);
        Election elec4 = new Election(07, 16, 2017, 3, "My Birthday", candidatePositionMap);

        UpcomingElectionRow row1 = new UpcomingElectionRow(elec1, elec2);
        UpcomingElectionRow row2 = new UpcomingElectionRow(elec3, elec4);


        upcomingElectionList = new ArrayList<UpcomingElectionRow>();
        upcomingElectionList.add(row1);
        upcomingElectionList.add(row2);

        adapter = new UpcomingElectionsAdapter(getActivity(), upcomingElectionList);
        ListView lView = (ListView) getView().findViewById(R.id.upcomingElectionList);
        lView.setAdapter(adapter);
        //setListAdapter(adapter);
    }
}