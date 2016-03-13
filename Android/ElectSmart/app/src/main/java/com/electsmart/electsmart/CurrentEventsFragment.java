package com.electsmart.electsmart;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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



        View view = inflater.inflate(R.layout.fragment_current_events, container, false);
        ListView listView = (ListView) view.findViewById(R.id.current_event_list);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_events, container, false);
    }
}
