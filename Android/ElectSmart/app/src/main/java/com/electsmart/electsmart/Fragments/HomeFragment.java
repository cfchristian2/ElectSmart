package com.electsmart.electsmart.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.electsmart.electsmart.API.Faroo.FarooAPI;
import com.electsmart.electsmart.API.Faroo.FarooService;
import com.electsmart.electsmart.API.Faroo.Models.FarooArticle;
import com.electsmart.electsmart.API.Faroo.Models.FarooResponse;
import com.electsmart.electsmart.API.bing.BingTask;
import com.electsmart.electsmart.DownloadImageTask;
import com.electsmart.electsmart.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private void getImage(String ImageUrl, View view) {
        try {
            new DownloadImageTask((ImageView) view.findViewById(R.id.sourceImageHome)).execute(ImageUrl);
        } catch (Exception ex) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        new BingTask().execute();
        FarooAPI service = FarooService.createApiInstance();
        Call<FarooResponse> call = service.getHeadNews();
        call.enqueue(new Callback<FarooResponse>() {
            @Override
            public void onResponse(Call<FarooResponse> call, final Response<FarooResponse> response) {
                int statusCode = response.code();
                farooResponse = response.body();
                final FarooArticle article = farooResponse.getFarooArticles().get(0);
                setupMainEventArticleUI(article);
            }

            @Override
            public void onFailure(Call<FarooResponse> call, Throwable t) {

            }
        });
        return view;
    }

    private void setupMainEventArticleUI(final FarooArticle article) {
        TextView mainEventText = (TextView) getView().findViewById(R.id.EventTitleText);
        mainEventText.setText(article.getTitle());
        getImage(article.getIurl(), getView());
        RelativeLayout mainEventArticlePeeker = (RelativeLayout) getView().findViewById(R.id.MainEventPeek);
        mainEventArticlePeeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(article.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getContext().startActivity(intent);
            }
        });
    }

    public void callWebService() {

    } // end callWebService


}
