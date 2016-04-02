package com.electsmart.electsmart.API.Faroo;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Scott on 4/2/2016.
 */
public interface FarooAPI {
    @Headers("Accept: application/json")
    @GET("api")
    Call<FarooResponse> getNews(@Query())
}
