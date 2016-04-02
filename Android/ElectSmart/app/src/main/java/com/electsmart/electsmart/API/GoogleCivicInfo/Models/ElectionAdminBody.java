package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

import java.util.List;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class ElectionAdminBody {
    private String name;
    private String electionInfoUrl;
    private String electionRegistrationUrl;
    private String electionRegistrationConfirmationUrl;
    private String absenteeVotingInfoUrl;
    private String votingLocationFinderUrl;
    private String ballotInfoUrl;
    private String electionRulesUrl;
    private List<String> voter_services;
    private String hoursOfOperation;
    private Address correspondenceAddress;
    private Address physicalAddress;
    private List<ElectionOfficial> electionOfficials;

    public ElectionAdminBody() {
    }

    public ElectionAdminBody(String name, String electionInfoUrl, String electionRegistrationUrl, String electionRegistrationConfirmationUrl, String absenteeVotingInfoUrl, String votingLocationFinderUrl, String ballotInfoUrl, String electionRulesUrl, List<String> voter_services, String hoursOfOperation, Address correspondenceAddress, Address physicalAddress, List<ElectionOfficial> electionOfficials) {
        this.name = name;
        this.electionInfoUrl = electionInfoUrl;
        this.electionRegistrationUrl = electionRegistrationUrl;
        this.electionRegistrationConfirmationUrl = electionRegistrationConfirmationUrl;
        this.absenteeVotingInfoUrl = absenteeVotingInfoUrl;
        this.votingLocationFinderUrl = votingLocationFinderUrl;
        this.ballotInfoUrl = ballotInfoUrl;
        this.electionRulesUrl = electionRulesUrl;
        this.voter_services = voter_services;
        this.hoursOfOperation = hoursOfOperation;
        this.correspondenceAddress = correspondenceAddress;
        this.physicalAddress = physicalAddress;
        this.electionOfficials = electionOfficials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElectionInfoUrl() {
        return electionInfoUrl;
    }

    public void setElectionInfoUrl(String electionInfoUrl) {
        this.electionInfoUrl = electionInfoUrl;
    }

    public String getElectionRegistrationUrl() {
        return electionRegistrationUrl;
    }

    public void setElectionRegistrationUrl(String electionRegistrationUrl) {
        this.electionRegistrationUrl = electionRegistrationUrl;
    }

    public String getElectionRegistrationConfirmationUrl() {
        return electionRegistrationConfirmationUrl;
    }

    public void setElectionRegistrationConfirmationUrl(String electionRegistrationConfirmationUrl) {
        this.electionRegistrationConfirmationUrl = electionRegistrationConfirmationUrl;
    }

    public String getAbsenteeVotingInfoUrl() {
        return absenteeVotingInfoUrl;
    }

    public void setAbsenteeVotingInfoUrl(String absenteeVotingInfoUrl) {
        this.absenteeVotingInfoUrl = absenteeVotingInfoUrl;
    }

    public String getVotingLocationFinderUrl() {
        return votingLocationFinderUrl;
    }

    public void setVotingLocationFinderUrl(String votingLocationFinderUrl) {
        this.votingLocationFinderUrl = votingLocationFinderUrl;
    }

    public String getBallotInfoUrl() {
        return ballotInfoUrl;
    }

    public void setBallotInfoUrl(String ballotInfoUrl) {
        this.ballotInfoUrl = ballotInfoUrl;
    }

    public String getElectionRulesUrl() {
        return electionRulesUrl;
    }

    public void setElectionRulesUrl(String electionRulesUrl) {
        this.electionRulesUrl = electionRulesUrl;
    }

    public List<String> getVoter_services() {
        return voter_services;
    }

    public void setVoter_services(List<String> voter_services) {
        this.voter_services = voter_services;
    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    public Address getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(Address correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    public Address getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(Address physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public List<ElectionOfficial> getElectionOfficials() {
        return electionOfficials;
    }

    public void setElectionOfficials(List<ElectionOfficial> electionOfficials) {
        this.electionOfficials = electionOfficials;
    }

    @Override
    public String toString() {
        return "ElectionAdminBody{" +
                "name='" + name + '\'' +
                ", electionInfoUrl='" + electionInfoUrl + '\'' +
                ", electionRegistrationUrl='" + electionRegistrationUrl + '\'' +
                ", electionRegistrationConfirmationUrl='" + electionRegistrationConfirmationUrl + '\'' +
                ", absenteeVotingInfoUrl='" + absenteeVotingInfoUrl + '\'' +
                ", votingLocationFinderUrl='" + votingLocationFinderUrl + '\'' +
                ", ballotInfoUrl='" + ballotInfoUrl + '\'' +
                ", electionRulesUrl='" + electionRulesUrl + '\'' +
                ", voter_services=" + voter_services +
                ", hoursOfOperation='" + hoursOfOperation + '\'' +
                ", correspondenceAddress=" + correspondenceAddress +
                ", physicalAddress=" + physicalAddress +
                ", electionOfficials=" + electionOfficials +
                '}';
    }
}
