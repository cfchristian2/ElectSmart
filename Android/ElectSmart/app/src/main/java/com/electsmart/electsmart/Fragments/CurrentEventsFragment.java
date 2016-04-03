package com.electsmart.electsmart.Fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.electsmart.electsmart.API.Faroo.FarooAPI;
import com.electsmart.electsmart.API.Faroo.FarooService;
import com.electsmart.electsmart.API.Faroo.Models.FarooResponse;
import com.electsmart.electsmart.Adapters.CurrentEventsAdapter;
import com.electsmart.electsmart.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        FarooAPI service = FarooService.createApiInstance();
        Call<FarooResponse> call = service.getNews();
        call.enqueue(new Callback<FarooResponse>() {
            @Override
            public void onResponse(Call<FarooResponse> call, Response<FarooResponse> response) {
                int statusCode = response.code();
                FarooResponse farooResponse = response.body();
                adapter = new CurrentEventsAdapter(getContext(), farooResponse.getFarooArticles());
                setListAdapter(adapter);

            }

            @Override
            public void onFailure(Call<FarooResponse> call, Throwable t) {

            }
        });

       /* ArrayList<CurrentEvent> currentEvents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CurrentEvent CurrentEvent = new CurrentEvent();
            CurrentEvent.title = "Drumpf";
            currentEvents.add(CurrentEvent);
        }*/
        //adapter = new CurrentEventsAdapter(getContext(), currentEvents);
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
