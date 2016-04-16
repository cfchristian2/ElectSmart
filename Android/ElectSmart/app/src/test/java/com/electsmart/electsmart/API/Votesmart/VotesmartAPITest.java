package com.electsmart.electsmart.API.Votesmart;

import com.electsmart.electsmart.API.votesmart.Models.ElectionsResponse;
import com.electsmart.electsmart.API.votesmart.VotesmartService;

import org.junit.Test;

import retrofit2.Response;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public class VotesmartAPITest {

    @Test
    public void testGetAllElections() throws Exception {
        //this is not asynchronous only call like this for tests
        Response<ElectionsResponse> response = VotesmartService.createApiInstance().getElectionsByYearState(VotesmartService.API_KEY, "2016", null).execute();

        assertNotNull("Response was empty", response.body());
        System.out.println(response.body());
    }
}
