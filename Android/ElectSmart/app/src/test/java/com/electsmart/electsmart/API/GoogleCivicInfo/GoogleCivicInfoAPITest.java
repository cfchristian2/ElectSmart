package com.electsmart.electsmart.API.GoogleCivicInfo;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.ElectionsResponse;
import com.electsmart.electsmart.API.GoogleCivicInfo.GoogleCivicInfoService;

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

        assertNotNull(response.body());
        System.out.println(response.body());
    }
}
