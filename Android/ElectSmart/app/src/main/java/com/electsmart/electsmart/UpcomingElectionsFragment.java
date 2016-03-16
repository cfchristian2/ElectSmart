package com.electsmart.electsmart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.electsmart.electsmart.Adapters.UpcomingElectionsAdapter;
import com.electsmart.electsmart.Models.UpcomingElectionRow;

import java.util.ArrayList;
import java.util.List;

public class UpcomingElectionsFragment extends ListFragment {

    private static final String TAG = UpcomingElectionsFragment.class.getSimpleName();
    private List<UpcomingElectionRow> upcomingElectionList;
    UpcomingElectionsAdapter adapter;

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
        UpcomingElectionRow row1 = new UpcomingElectionRow(01, 01, 2017, 0, "First Election", 12, 31, 2017, 1, "Second Election");
        UpcomingElectionRow row2 = new UpcomingElectionRow(02, 02, 2018, 2, "Third Election", 07, 16, 2017, 3, "My Birthday");

        upcomingElectionList = new ArrayList<UpcomingElectionRow>();
        upcomingElectionList.add(row1);
        upcomingElectionList.add(row2);

        adapter = new UpcomingElectionsAdapter(getActivity(), upcomingElectionList);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_upcoming_elections, null, false);
    }

        /* NEED TO CREATE AN ELECTION FRAGMENT */

        /*ElectionFragment nextFrag= new ElectionFragmen();
        this.getFragmentManager().beginTransaction()
                .replace(R.id.container, nextFrag, "UpcomingElectionsFragment")
                .addToBackStack(null)
                .commit();*/
}
