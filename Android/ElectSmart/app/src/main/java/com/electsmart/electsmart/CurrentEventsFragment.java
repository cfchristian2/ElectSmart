package com.electsmart.electsmart;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.electsmart.electsmart.Adapters.CurrentEventsAdapter;
import com.electsmart.electsmart.Models.CurrentEvent;

import java.util.ArrayList;

public class CurrentEventsFragment extends ListFragment {

    private static final String TAG = CurrentEventsFragment.class.getSimpleName();

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // ListView listView = (ListView) view.findViewById(R.id.current_event_list);
        View view = inflater.inflate(R.layout.fragment_current_events, container, false);

        ArrayList<CurrentEvent> currentEvents = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            CurrentEvent CurrentEvent = new CurrentEvent();
            CurrentEvent.title = "Drumpf";
            currentEvents.add(CurrentEvent);
        }

        CurrentEventsAdapter adapter = new CurrentEventsAdapter(getActivity(), currentEvents);
        setListAdapter(adapter);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_events, container, false);
    }
}
