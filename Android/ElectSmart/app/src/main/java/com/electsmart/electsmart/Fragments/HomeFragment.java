package com.electsmart.electsmart.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.electsmart.electsmart.API.Faroo.FarooAPI;
import com.electsmart.electsmart.API.Faroo.FarooService;
import com.electsmart.electsmart.API.Faroo.Models.FarooArticle;
import com.electsmart.electsmart.API.Faroo.Models.FarooResponse;
import com.electsmart.electsmart.DownloadImageTask;
import com.electsmart.electsmart.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        FarooAPI service = FarooService.createApiInstance();
        Call<FarooResponse> call = service.getNews();
        call.enqueue(new Callback<FarooResponse>() {
            @Override
            public void onResponse(Call<FarooResponse> call, Response<FarooResponse> response) {
                int statusCode = response.code();
                FarooResponse farooResponse = response.body();
                TextView mainEventText = (TextView) getView().findViewById(R.id.EventTitleText);
                List<FarooArticle> article = farooResponse.getFarooArticles();
                mainEventText.setText(article.get(0).getTitle());
                getImage(article.get(0).getIurl(), getView());

            }

            @Override
            public void onFailure(Call<FarooResponse> call, Throwable t) {

            }
        });
    }

    private void getImage(String ImageUrl, View view){
        try{
            new DownloadImageTask((ImageView) view.findViewById(R.id.sourceImageHome)).execute(ImageUrl);
        }catch (Exception ex){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /*RelativeLayout mainEventPeek = (RelativeLayout) view.findViewById(R.id.MainEventPeek);
        mainEventPeek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

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

                fragmentTransaction.replace(R.id.container, electionFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });*/

        return view;

    }




}
