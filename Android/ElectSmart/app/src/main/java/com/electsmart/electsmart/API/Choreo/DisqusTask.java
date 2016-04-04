package com.electsmart.electsmart.API.Choreo;

import android.os.AsyncTask;
import android.util.Log;

import com.electsmart.electsmart.Adapters.ForumAdapter;
import com.google.gson.Gson;
import com.temboo.Library.Disqus.Forums.ListThreads;
import com.temboo.core.TembooSession;

/**
 * Created by Scott on 4/4/2016.
 */
public class DisqusTask extends AsyncTask<Void, Void, String> {
    private ForumAdapter forumAdapter;

    public DisqusTask(ForumAdapter forumAdapter){
        this.forumAdapter = forumAdapter;
    }
    @Override
    protected String doInBackground(Void... arg0) {
        try {
            // Temboo code will go here
            // Instantiate the Choreo, using a previously instantiated TembooSession object, eg:
            TembooSession session = new TembooSession("runfranks525", "myFirstApp", "ctNgcL3UbLD3fF5k8XgvAvj17yqikF7j");

            ListThreads listThreadsChoreo = new ListThreads(session);

            // Get an InputSet object for the choreo
            ListThreads.ListThreadsInputSet listThreadsInputs = listThreadsChoreo.newInputSet();

            // Set inputs
            listThreadsInputs.set_PublicKey("veLosqnJ37IHa8xvvE3jv7yTDBMfNdq9FkUm44HYWLLLxhxUdOZ1ys3ka5Agyvuc");
            listThreadsInputs.set_Forum("winbeta");

            // Execute Choreo
            ListThreads.ListThreadsResultSet listThreadsResults = listThreadsChoreo.execute(listThreadsInputs);
            return listThreadsResults.get_Response();
        } catch(Exception e) {
            // if an exception occurred, log it
            Log.e(this.getClass().toString(), e.getMessage());
        }
        return null;
    }

    protected void onPostExecute(String result) {
        try {
            // Will update UI here
            Gson gson = new Gson();
            com.electsmart.electsmart.API.Choreo.Models.Thread response = gson.fromJson(result, com.electsmart.electsmart.API.Choreo.Models.Thread.class);
            forumAdapter.clear();
            forumAdapter.addAll(response.getResponse());
            forumAdapter.notifyDataSetChanged();
        } catch(Exception e) {
            // if an exception occurred, show an error message
            Log.e(this.getClass().toString(), e.getMessage());
        }
    }
}
