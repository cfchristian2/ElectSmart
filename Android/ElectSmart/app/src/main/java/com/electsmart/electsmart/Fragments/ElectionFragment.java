package com.electsmart.electsmart.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.electsmart.electsmart.Adapters.ElectionAdapter;
import com.electsmart.electsmart.Messages.ElectionMessage;
import com.electsmart.electsmart.Models.Election;
import com.electsmart.electsmart.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by brand on 3/16/2016.
 */
public class ElectionFragment extends Fragment {

    private Election election;
    ElectionAdapter adapter;
    View rootView;
    ExpandableListView expListView;

    public static ElectionFragment newInstance(Election election) {
        ElectionFragment fragment = new ElectionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //DUMMY DATA, can't get upcomingElections to pass data to election view
        //DUMMY DATA IN PLACE OF APIS
        List<String> openPositions = new ArrayList<String>();
        List<String> candidates = new ArrayList<String>();
        HashMap<String, List<String>> candidatePositionMap = new HashMap<String, List<String>>();

        for(int j = 0; j < 3; j++){
            candidates.add("Candidate " + j);
        }
        for(int i = 0; i < 5; i++){
            openPositions.add("Position " + i);
            candidatePositionMap.put(openPositions.get(i), candidates);
        }
        election = new Election(01, 01, 2017, 0, "First Election", candidatePositionMap);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_election_view, null);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expListView = (ExpandableListView) view.findViewById(R.id.expList);
        adapter = new ElectionAdapter(getActivity(), election.getOpenPositions(), election.getMap());
        expListView.setAdapter(adapter);
        expListView.setGroupIndicator(null);
        Toast.makeText(getActivity(), "onViewCreated ElectionFragmen!", Toast.LENGTH_SHORT).show();
    }

    // This method will be called when a ElecctionMessage is posted
    @Subscribe
    public void onMessageEvent(ElectionMessage event){
        this.election = event.election;
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

}
