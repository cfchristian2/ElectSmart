package com.electsmart.electsmart;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.electsmart.electsmart.Adapters.ElectionAdapter;
import com.electsmart.electsmart.Messages.ElectionMessage;
import com.electsmart.electsmart.Models.Election;

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

    public ElectionFragment(){

    }

    public static ElectionFragment newInstance(Election election) {
        ElectionFragment fragment = new ElectionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        this.election = (Election) bundle.getSerializable("election");

        System.out.println("ElectionFragment: " + election.getName());

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_election_view, null);
        System.out.println("ElectionFragment: Inflate View!");
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //expListView = (ExpandableListView) view.findViewById(R.id.expList);
        //adapter = new ElectionAdapter(getActivity(), election.getOpenPositions(), election.getMap());
        //expListView.setAdapter(adapter);
        //expListView.setGroupIndicator(null);
        System.out.println("ElectionFragment: Set adapter for expandableListView!");
    }
}
