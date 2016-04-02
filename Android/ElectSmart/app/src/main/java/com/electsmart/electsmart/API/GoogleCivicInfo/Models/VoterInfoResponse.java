package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

import java.util.List;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class VoterInfoResponse {
    private String kind;
    private GoogleElection election;
    private List<GoogleElection> otherElections;
    private Address normalizedInput;
    private List<PollingLocation> pollingLocations;
    private List<PollingLocation> earlyVoteSites;
    private List<PollingLocation> dropOffLocations;
    private List<Contest> contests;
    private List<State> state;
    private boolean mailOnly;

    public VoterInfoResponse() {
    }

    public VoterInfoResponse(String kind, GoogleElection election, List<GoogleElection> otherElections, Address normalizedInput, List<PollingLocation> pollingLocations, List<PollingLocation> earlyVoteSites, List<PollingLocation> dropOffLocations, List<Contest> contests, List<State> state, boolean mailOnly) {
        this.kind = kind;
        this.election = election;
        this.otherElections = otherElections;
        this.normalizedInput = normalizedInput;
        this.pollingLocations = pollingLocations;
        this.earlyVoteSites = earlyVoteSites;
        this.dropOffLocations = dropOffLocations;
        this.contests = contests;
        this.state = state;
        this.mailOnly = mailOnly;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public GoogleElection getElection() {
        return election;
    }

    public void setElection(GoogleElection election) {
        this.election = election;
    }

    public List<GoogleElection> getOtherElections() {
        return otherElections;
    }

    public void setOtherElections(List<GoogleElection> otherElections) {
        this.otherElections = otherElections;
    }

    public Address getNormalizedInput() {
        return normalizedInput;
    }

    public void setNormalizedInput(Address normalizedInput) {
        this.normalizedInput = normalizedInput;
    }

    public List<PollingLocation> getPollingLocations() {
        return pollingLocations;
    }

    public void setPollingLocations(List<PollingLocation> pollingLocations) {
        this.pollingLocations = pollingLocations;
    }

    public List<PollingLocation> getEarlyVoteSites() {
        return earlyVoteSites;
    }

    public void setEarlyVoteSites(List<PollingLocation> earlyVoteSites) {
        this.earlyVoteSites = earlyVoteSites;
    }

    public List<PollingLocation> getDropOffLocations() {
        return dropOffLocations;
    }

    public void setDropOffLocations(List<PollingLocation> dropOffLocations) {
        this.dropOffLocations = dropOffLocations;
    }

    public List<Contest> getContests() {
        return contests;
    }

    public void setContests(List<Contest> contests) {
        this.contests = contests;
    }

    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }

    public boolean isMailOnly() {
        return mailOnly;
    }

    public void setMailOnly(boolean mailOnly) {
        this.mailOnly = mailOnly;
    }

    @Override
    public String toString() {
        return "VoterInfoResponse{" +
                "kind='" + kind + '\'' +
                ", election=" + election +
                ", otherElections=" + otherElections +
                ", normalizedInput=" + normalizedInput +
                ", pollingLocations=" + pollingLocations +
                ", earlyVoteSites=" + earlyVoteSites +
                ", dropOffLocations=" + dropOffLocations +
                ", contests=" + contests +
                ", state=" + state +
                ", mailOnly=" + mailOnly +
                '}';
    }
}
