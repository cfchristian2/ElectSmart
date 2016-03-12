package com.electsmart.electsmart;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.electsmart.electsmart.Adapters.UpcomingElectionsAdapter;
import com.electsmart.electsmart.Models.UpcomingElection;

import java.util.ArrayList;

public class UpcomingElectionsFragment extends ListFragment {

    private static final String TAG = UpcomingElectionsFragment.class.getSimpleName();

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
        // Inflate the layout for this fragment
        // Construct the data source
        View view = inflater.inflate(R.layout.fragment_upcoming_elections, container, false);
        ListView listView = (ListView) view.findViewById(R.id.upcoming_elections_list);

        ArrayList<UpcomingElection> arrayOfElections = new ArrayList<UpcomingElection>();

        //Need to fill Elections info

        // Create the adapter to convert the array to views
        UpcomingElectionsAdapter adapter = new UpcomingElectionsAdapter(getActivity(), arrayOfElections);

        // Attach the adapter to a ListView
        listView.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_upcoming_elections, container, false);
    }
}
