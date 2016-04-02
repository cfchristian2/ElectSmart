package com.electsmart.electsmart.API.GoogleCivicInfo;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.ElectionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public interface GoogleCivicInfoAPI {

    //TODO fix the key being hardcoded
    @Headers("Accept: application/json")
    @GET("elections")
    Call<ElectionsResponse> getElections(@Query(value = "key") String apiKey);
}
