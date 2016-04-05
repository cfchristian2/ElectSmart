package com.electsmart.electsmart.API.bing;

import android.os.AsyncTask;
import android.util.Log;

import com.electsmart.electsmart.API.bing.Models.D;
import com.electsmart.electsmart.Adapters.ForumAdapter;
import com.google.gson.Gson;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by Scott on 4/4/2016.
 */
public class BingTask extends AsyncTask<Void, Void, String> {
    private ForumAdapter forumAdapter;
    private String URL = "https://api.datamarket.azure.com/Bing/Search/v1/News?Query=%27Hillary%20Clinton%27&$format=JSON";
    private String KEY_STRING = "fDs4/JuSlVn0HIG0tp4QaQwxuLnfe35r8Kq6ej51RL0";
    public BingTask(){

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
            String theResponseFromBing = result;

            Gson gson = new Gson();
            D bingResult = gson.fromJson(result, D.class);
            String blah = "1";
        } catch(Exception e) {
            // if an exception occurred, show an error message
            Log.e(result.toString(), e.getMessage());
        }
    }
}
