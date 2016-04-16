package com.electsmart.electsmart.API.votesmart;

import com.electsmart.electsmart.API.votesmart.Models.ElectionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public interface VotesmartAPI {

    @Headers("Accept: application/json")
    @GET("Election.getElectionByYearState?o=JSON")
    Call<ElectionsResponse> getElectionsByYearState(@Query(value = "key") String key, @Query(value = "year") String year, @Query(value = "stateId") String state);
}
