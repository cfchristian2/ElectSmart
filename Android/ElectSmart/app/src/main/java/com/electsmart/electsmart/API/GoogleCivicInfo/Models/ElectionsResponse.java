package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class ElectionsResponse {
    private String kind;
    private List<GoogleElection> elections;

    public ElectionsResponse() {
        this.kind = "";
        this.elections = new ArrayList<GoogleElection>();
    }

    public ElectionsResponse(String kind, List<GoogleElection> elections) {
        this.kind = kind;
        this.elections = elections;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<GoogleElection> getElections() {
        return elections;
    }

    public void setElections(List<GoogleElection> elections) {
        this.elections = elections;
    }

    @Override
    public String toString() {
        return "ElectionsResponse{" +
                "kind='" + kind + '\'' +
                ", elections=" + elections +
                '}';
    }
}
