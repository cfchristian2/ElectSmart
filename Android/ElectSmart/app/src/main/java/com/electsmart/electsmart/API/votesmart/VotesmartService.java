package com.electsmart.electsmart.API.votesmart;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public class VotesmartService {

    private static final String API_URL = "http://api.votesmart.org/";
    public static final String API_KEY = "bbad23b6fa27737fd5b2e4655d4ac334";

    private static VotesmartAPI apiInstance;

    public static VotesmartAPI createApiInstance() {
        if(null == apiInstance) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInstance = retrofit.create(VotesmartAPI.class);
        }
        return apiInstance;
    }
}
