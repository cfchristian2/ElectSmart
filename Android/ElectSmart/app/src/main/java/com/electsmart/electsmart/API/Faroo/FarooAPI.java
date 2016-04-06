package com.electsmart.electsmart.API.Faroo;

import com.electsmart.electsmart.API.Faroo.Models.FarooResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Scott on 4/2/2016.
 */
public interface FarooAPI {
    @Headers("Accept: application/json")
    @GET("/api?q=&start=1&length=10&l=en&src=news&f=json&key=1wh189GsSHUhjtseYvz5LtCNMPU_")
    Call<FarooResponse> getNews();

    @Headers("Accept: application/json")
    @GET("/api?q=&start=1&length=1&l=en&src=news&f=json&key=1wh189GsSHUhjtseYvz5LtCNMPU_")
    Call<FarooResponse> getHeadNews();
}
