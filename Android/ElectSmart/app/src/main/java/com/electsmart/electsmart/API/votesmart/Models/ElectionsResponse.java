package com.electsmart.electsmart.API.votesmart.Models;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public class ElectionsResponse {
    private ElectionWrapper elections;

    public ElectionsResponse() {
    }

    public ElectionsResponse(ElectionWrapper elections) {
        this.elections = elections;
    }

    public ElectionWrapper getElections() {
        return elections;
    }

    public void setElections(ElectionWrapper elections) {
        this.elections = elections;
    }

    @Override
    public String toString() {
        return "ElectionsResponse{" +
                "elections=" + elections +
                '}';
    }
}
