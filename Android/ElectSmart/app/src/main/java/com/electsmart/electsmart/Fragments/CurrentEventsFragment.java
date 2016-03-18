package com.electsmart.electsmart.Fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        for (int i = 0; i < 10; i++) {
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

        View view = inflater.inflate(R.layout.fragment_current_events, container, false);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    //@Override

    /**
     * public void onActivityCreated(Bundle savedInstanceState){
     * ListView currentEventsList = getListView();
     * currentEventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     *
     * @Override public void onItemClick(AdapterView<?> list, View view, int position, long id) {
     * CurrentEvent currentEvent = (CurrentEvent) list.getItemAtPosition(position);
     * FragmentManager fragmentManager = getFragmentManager();
     * FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
     * ArticleFragment articleFragment = new ArticleFragment();
     * //fragmentTransaction.remove(R.id.main_content, )
     * fragmentTransaction.replace(R.id.main_content, articleFragment);
     * fragmentTransaction.addToBackStack(null);
     * fragmentTransaction.commit();
     * }
     * });
     * super.onActivityCreated(savedInstanceState);
     * }
     **/

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ArticleFragment articleFragment = new ArticleFragment();
        //fragmentTransaction.remove(R.id.main_content, )
        fragmentTransaction.replace(R.id.main_content, articleFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
