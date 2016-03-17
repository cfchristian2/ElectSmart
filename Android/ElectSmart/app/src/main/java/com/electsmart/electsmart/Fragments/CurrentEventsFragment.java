package com.electsmart.electsmart.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.electsmart.electsmart.Adapters.CurrentEventsAdapter;
import com.electsmart.electsmart.Models.CurrentEvent;
import com.electsmart.electsmart.R;

import java.util.ArrayList;

public class CurrentEventsFragment extends ListFragment {

    private static final String TAG = CurrentEventsFragment.class.getSimpleName();
    CurrentEventsAdapter adapter;
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
        // ListView listView = (ListView) view.findViewById(R.id.current_event_list);

        ArrayList<CurrentEvent> currentEvents = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            CurrentEvent CurrentEvent = new CurrentEvent();
            CurrentEvent.title = "Drumpf";
            currentEvents.add(CurrentEvent);
        }
        adapter = new CurrentEventsAdapter(getContext(), currentEvents);
        setListAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_events, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //expListView = (ExpandableListView) view.findViewById(R.id.expList);
        //adapter = new CurrentEventsAdapter(getActivity(), currentEvents);
        //expListView.setAdapter(adapter);
        //expListView.setGroupIndicator(null);
        //ListView currentEventsList = (ListView) view.findViewById(R.id)
        //Toast.makeText(getActivity(), "onViewCreated ElectionFragmen!", Toast.LENGTH_SHORT).show();
    }
}
