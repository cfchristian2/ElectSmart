package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class GoogleElection {

    private long id;
    private String name;
    private String electionDay;
    private String ocdDivisionId;

    public GoogleElection() {
    }

    public GoogleElection(long id, String name, String electionDay, String ocdDivisionId) {
        this.id = id;
        this.name = name;
        this.electionDay = electionDay;
        this.ocdDivisionId = ocdDivisionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElectionDay() {
        return electionDay;
    }

    public void setElectionDay(String electionDay) {
        this.electionDay = electionDay;
    }

    public String getOcdDivisionId() {
        return ocdDivisionId;
    }

    public void setOcdDivisionId(String ocdDivisionId) {
        this.ocdDivisionId = ocdDivisionId;
    }

    @Override
    public String toString() {
        return "GoogleElection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", electionDay='" + electionDay + '\'' +
                ", ocdDivisionId='" + ocdDivisionId + '\'' +
                '}';
    }
}
