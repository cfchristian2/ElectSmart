package com.electsmart.electsmart.API.GoogleCivicInfo;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.ElectionsResponse;
import com.electsmart.electsmart.API.GoogleCivicInfo.GoogleCivicInfoService;
import com.electsmart.electsmart.API.GoogleCivicInfo.Models.VoterInfoResponse;

import org.junit.Test;

import static org.junit.Assert.*;

import retrofit2.Response;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class GoogleCivicInfoAPITest {

    @Test
    public void testGetAllElections() throws Exception {
        //this is not asynchronous only call like this for tests
        Response<ElectionsResponse> response = GoogleCivicInfoService.createApiInstance().getElections(GoogleCivicInfoService.API_KEY).execute();

        assertNotNull("Response was empty", response.body());
        System.out.println(response.body());
    }

    //doesn't work for the given address
    @Test
    public void testGetVoterInfo() throws Exception {
        Response<VoterInfoResponse> response = GoogleCivicInfoService.createApiInstance().getVoterInfo(GoogleCivicInfoService.API_KEY,"1263 Pacific Ave. Kansas City, KS").execute();

        assertNotNull("Response was empty", response.body());
        System.out.println(response.body());
    }
}
