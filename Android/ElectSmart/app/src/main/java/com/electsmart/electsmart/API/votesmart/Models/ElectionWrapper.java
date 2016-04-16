package com.electsmart.electsmart.API.votesmart.Models;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public class ElectionWrapper {
    private GeneralInfo generalInfo;
    private Election election;

    public ElectionWrapper() {
    }

    public ElectionWrapper(GeneralInfo generalInfo, Election election) {
        this.generalInfo = generalInfo;
        this.election = election;
    }

    public GeneralInfo getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(GeneralInfo generalInfo) {
        this.generalInfo = generalInfo;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    @Override
    public String toString() {
        return "ElectionWrapper{" +
                "generalInfo=" + generalInfo +
                ", election=" + election +
                '}';
    }
}
