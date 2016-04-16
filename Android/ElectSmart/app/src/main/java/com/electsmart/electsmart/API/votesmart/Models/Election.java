package com.electsmart.electsmart.API.votesmart.Models;

import java.util.List;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public class Election {
    private Long electionId;
    private String name;
    private String stateId;
    private String officeTypeId;
    private String special;
    private String electionYear;
    private List<Stage> stage;

    public Election() {
    }

    public Election(Long electionId, String name, String stateId, String officeTypeId, String special, String electionYear, List<Stage> stage) {
        this.electionId = electionId;
        this.name = name;
        this.stateId = stateId;
        this.officeTypeId = officeTypeId;
        this.special = special;
        this.electionYear = electionYear;
        this.stage = stage;
    }

    public Long getElectionId() {
        return electionId;
    }

    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getOfficeTypeId() {
        return officeTypeId;
    }

    public void setOfficeTypeId(String officeTypeId) {
        this.officeTypeId = officeTypeId;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getElectionYear() {
        return electionYear;
    }

    public void setElectionYear(String electionYear) {
        this.electionYear = electionYear;
    }

    public List<Stage> getStage() {
        return stage;
    }

    public void setStage(List<Stage> stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "Election{" +
                "electionId=" + electionId +
                ", name='" + name + '\'' +
                ", stateId='" + stateId + '\'' +
                ", officeTypeId='" + officeTypeId + '\'' +
                ", special='" + special + '\'' +
                ", electionYear='" + electionYear + '\'' +
                ", stage=" + stage +
                '}';
    }
}
