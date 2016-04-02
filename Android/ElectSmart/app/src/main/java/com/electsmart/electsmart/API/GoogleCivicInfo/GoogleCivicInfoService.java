package com.electsmart.electsmart.API.GoogleCivicInfo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class GoogleCivicInfoService {

    private static final String API_URL = "https://www.googleapis.com/civicinfo/v2/";
    public static final String API_KEY = "AIzaSyCGtIc-WI9xXq-sPHbu1htXJT7WV9hxdKk";

    private static GoogleCivicInfoAPI apiInstance;

    public static GoogleCivicInfoAPI createApiInstance() {
        if(null == apiInstance) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInstance = retrofit.create(GoogleCivicInfoAPI.class);
        }
        return apiInstance;
    }
}
