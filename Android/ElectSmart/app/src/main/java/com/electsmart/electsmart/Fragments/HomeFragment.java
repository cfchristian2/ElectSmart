package com.electsmart.electsmart.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.electsmart.electsmart.Activities.ArticleActivity;
import com.electsmart.electsmart.R;

public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getSimpleName();

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
        //LinearLayout ElectionBanner = (LinearLayout) getView().findViewById(R.id.ElectionBanner);
        //ElectionBanner.setOnClickListener(myhandler1);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //return inflater.inflate(R.layout.fragment_home, container, false);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //mPollingPlaceImage = (ImageView) view.findViewById(R.id.PollingMarker);
        //mPollingPlaceImage.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent = new Intent(getActivity(), PollingPlaceActivity.class);
        //         startActivity(intent);
        //    }
        // });

        RelativeLayout mainEventPeek = (RelativeLayout) view.findViewById(R.id.MainEventPeek);
        mainEventPeek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), ArticleActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }




}
