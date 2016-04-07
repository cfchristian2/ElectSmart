package com.electsmart.electsmart.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.electsmart.electsmart.API.bing.BingTask;
import com.electsmart.electsmart.API.bing.Models.BingSearchResults;
import com.electsmart.electsmart.Adapters.CurrentEventsAdapter;
import com.electsmart.electsmart.R;

import java.util.ArrayList;
import java.util.List;

public class CurrentEventsFragment extends ListFragment {

    private static final String TAG = CurrentEventsFragment.class.getSimpleName();
    CurrentEventsAdapter adapter;
    public static final String API_KEY = "&key=1wh189GsSHUhjtseYvz5LtCNMPU_";


    public CurrentEventsFragment() {
        // Required empty public constructor
    }

    public static CurrentEventsFragment newInstance() {
        CurrentEventsFragment fragment = new CurrentEventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<BingSearchResults.Result> results = new ArrayList<>();
        CurrentEventsAdapter currentEventsAdapter = new CurrentEventsAdapter(this.getContext(), results);
        //SearchView search = (SearchView) getView().findViewById(R.id.queryNews);
        //String query = search.getQuery().toString();
        setListAdapter(currentEventsAdapter);
        new BingTask(currentEventsAdapter).execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_current_events, container, false);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
