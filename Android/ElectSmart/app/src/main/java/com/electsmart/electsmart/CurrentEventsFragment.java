package com.electsmart.electsmart;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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





        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_events, container, false);
    }
}
