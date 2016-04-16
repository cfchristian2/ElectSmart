package com.electsmart.electsmart.API.votesmart.Models;

import java.util.Date;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public class Stage {
    private String stageId;
    private Long electionElectionstageId;
    private String name;
    private String stateId;
    private String electionDate;
    private String filingDeadline;
    private String npatMailed;

    public Stage() {
    }

    public Stage(String stageId, Long electionElectionstageId, String name, String stateId, String electionDate, String filingDeadline, String npatMailed) {
        this.stageId = stageId;
        this.electionElectionstageId = electionElectionstageId;
        this.name = name;
        this.stateId = stateId;
        this.electionDate = electionDate;
        this.filingDeadline = filingDeadline;
        this.npatMailed = npatMailed;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public Long getElectionElectionstageId() {
        return electionElectionstageId;
    }

    public void setElectionElectionstageId(Long electionElectionstageId) {
        this.electionElectionstageId = electionElectionstageId;
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

    public String getElectionDate() {
        return electionDate;
    }

    public void setElectionDate(String electionDate) {
        this.electionDate = electionDate;
    }

    public String getFilingDeadline() {
        return filingDeadline;
    }

    public void setFilingDeadline(String filingDeadline) {
        this.filingDeadline = filingDeadline;
    }

    public String getNpatMailed() {
        return npatMailed;
    }

    public void setNpatMailed(String npatMailed) {
        this.npatMailed = npatMailed;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "stageId='" + stageId + '\'' +
                ", electionElectionstageId=" + electionElectionstageId +
                ", name='" + name + '\'' +
                ", stateId='" + stateId + '\'' +
                ", electionDate='" + electionDate + '\'' +
                ", filingDeadline='" + filingDeadline + '\'' +
                ", npatMailed='" + npatMailed + '\'' +
                '}';
    }
}
