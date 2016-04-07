package com.electsmart.electsmart.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.electsmart.electsmart.API.Faroo.Models.FarooResponse;
import com.electsmart.electsmart.API.bing.BingTask;
import com.electsmart.electsmart.Activities.ArticleActivity;
import com.electsmart.electsmart.R;

public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private FarooResponse farooResponse;


    private ImageView mPollingPlaceImage;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        try{
            new BingTask(view).execute();

        }catch (NullPointerException ex){
        }
        LinearLayout electionBanner = (LinearLayout) view.findViewById(R.id.ElectionBanner);
        electionBanner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getContext(), ArticleActivity.class);
                getContext().startActivity(intent);
            }
        });
        return view;
    }
}
