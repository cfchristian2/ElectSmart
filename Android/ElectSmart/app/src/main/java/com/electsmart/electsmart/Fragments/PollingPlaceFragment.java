package com.electsmart.electsmart.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.electsmart.electsmart.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PollingPlaceFragment extends Fragment {


    public PollingPlaceFragment() {
        // Required empty public constructor
    }

    public static PollingPlaceFragment newInstance(){
        PollingPlaceFragment pollingPlaceFragment = new PollingPlaceFragment();
        return pollingPlaceFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_polling_place, container, false);
    }

}
