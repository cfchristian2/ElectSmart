package com.electsmart.electsmart.API.Faroo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Scott on 4/2/2016.
 */
public class FarooService {
    private static final String API_URL = "http://www.faroo.com";
    //public static final String API_KEY = "&key=1wh189GsSHUhjtseYvz5LtCNMPU_";
    private static FarooAPI apiInstance;

    public static FarooAPI createApiInstance(){
        if(apiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInstance = retrofit.create(FarooAPI.class);
        }
        return apiInstance;
    }
}
