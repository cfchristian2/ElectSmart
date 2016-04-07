package com.electsmart.electsmart.API.bing;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.electsmart.electsmart.API.bing.Models.BingSearchResults;
import com.electsmart.electsmart.Adapters.CurrentEventsAdapter;
import com.electsmart.electsmart.DownloadImageTask;
import com.electsmart.electsmart.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott on 4/4/2016.
 */
public class BingTask extends AsyncTask<Void, Void, String> {
    private CurrentEventsAdapter currentEventsAdapter;
    private View context;
    private boolean isHome;
    private String URL = "https://api.datamarket.azure.com/Bing/Search/v1/News?Query=%27Hillary%20Clinton%27&$format=JSON&$top=10";
    private String KEY_STRING = "fDs4/JuSlVn0HIG0tp4QaQwxuLnfe35r8Kq6ej51RL0";
    public BingTask(CurrentEventsAdapter currentEventsAdapter){
        this.currentEventsAdapter = currentEventsAdapter;
        isHome = false;
    }

    public BingTask(View context){
        this.context = context;
        isHome = true;
    }
    @Override
    protected String doInBackground(Void... arg0) {
        RestClient client = new RestClient(URL);
        byte[] accountKeyBytes = Base64.encodeBase64((KEY_STRING + ":" + KEY_STRING).getBytes());
        String accountKeyEnc = new String(accountKeyBytes);

        client.AddHeader("Authorization", "Basic " + accountKeyEnc);
        try {
            client.Execute(RestClient.RequestMethod.GET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = client.getResponse();
        String theResponseFromBing = response;
        return response;
    }

    protected void onPostExecute(String result) {
        try {
            // Will update UI here
            if(result != null){
                Gson gson = (new GsonBuilder()).create();
                BingSearchResults bingResult = gson.fromJson(result, BingSearchResults.class);
                if(isHome){
                    final BingSearchResults.Result mainEventResult = bingResult.d.results[0];
                    String eventTitle = mainEventResult.Title;
                    String eventDescription = mainEventResult.Description;
                    HandleSetupForHomeMainEvent(eventTitle, eventDescription);
                    RelativeLayout mainEventArticlePeeker = (RelativeLayout) context.findViewById(R.id.MainEventPeek);
                    mainEventArticlePeeker.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri uri = Uri.parse(mainEventResult.Url);
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            context.getContext().startActivity(intent);
                        }
                    });
                }else{
                    List<BingSearchResults.Result> resultsConverted = new ArrayList<>();
                    BingSearchResults.Result[] results = bingResult.d.results;
                    for(int i = 1; i < results.length; i++){
                        resultsConverted.add(results[i]);
                    }
                    HandleCurrentEventsAdapterSetup(resultsConverted);
                }
            }else{
                if(isHome){
                    HandleSetupForHomeMainEvent(" ", " ");
                }else{
                    List<BingSearchResults.Result> results = new ArrayList<>();
                    HandleCurrentEventsAdapterSetup(results);
                }

            }
        } catch(NullPointerException e) {
            // if an exception occurred, show an error message
            Log.e(result.toString(), e.getMessage());
        }
    }

    private void HandleSetupForHomeMainEvent(String eventTitle, String eventDescription) {
        TextView titleText = (TextView) context.findViewById(R.id.EventTitleText);
        titleText.setText(eventTitle);
        TextView descriptionText = (TextView) context.findViewById(R.id.MainEventDescription);
        descriptionText.setText(eventDescription);

    }

    private void HandleCurrentEventsAdapterSetup(List<BingSearchResults.Result> resultsConverted) {
        currentEventsAdapter.clear();
        currentEventsAdapter.addAll(resultsConverted);
        currentEventsAdapter.notifyDataSetChanged();
    }

    private void getImage(String ImageUrl){
        try{
            new DownloadImageTask((ImageView) context.findViewById(R.id.sourceImageHome)).execute(ImageUrl);
        }catch (Exception ex){

        }
    }
}
