package com.electsmart.electsmart.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RelativeLayout mainEventPeek = (RelativeLayout) view.findViewById(R.id.MainEventPeek);
        mainEventPeek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               // FragmentManager fragmentManager = getFragmentManager();
               // FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
               // ArticleFragment articleFragment = new ArticleFragment();

               // fragmentTransaction.replace(R.id.container, articleFragment);
               // fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.commit();
                Intent intent = new Intent(v.getContext(), ArticleActivity.class);
                getContext().startActivity(intent);
            }
        });

        LinearLayout ElectionBanner = (LinearLayout) view.findViewById(R.id.ElectionBanner);
        ElectionBanner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ElectionFragment electionFragment = new ElectionFragment();

                fragmentTransaction.replace(R.id.container, electionFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });

        return view;

    }




}
