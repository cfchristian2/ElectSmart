package com.electsmart.electsmart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ElectionFragment extends Fragment {


    public ElectionFragment() {
        // Required empty public constructor
    }

    public static ElectionFragment newInstance(){
        ElectionFragment electionFragment = new ElectionFragment();
        return electionFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_election, container, false);
    }

}
