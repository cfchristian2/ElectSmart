package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

import java.util.List;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class Contest {
    private String id;
    private String type;
    private String primaryParty;
    private String electorateSpecifications;
    private String special;
    private String office;
    private List<String> level;
    private List<String> roles;
    private District district;
    private long numberElected;
    private long numberVotingFor;
    private long ballotPlacement;
    private List<Candidate> candidates;
    private String referendumTitle;
    private String referendumSubtitle;
    private String referendumUrl;
    private String referendumBrief;
    private String referendumText;
    private String referendumProStatement;
    private String referendumConStatement;
    private String referendumPassageThreshold;
    private String referendumEffectOfAbstain;
    private List<String> referendumBallotResponses;
    private List<Source> sources;

    public Contest() {
    }

    public Contest(String id, String type, String primaryParty, String electorateSpecifications, String special, String office, List<String> level, List<String> roles, District district, long numberElected, long numberVotingFor, long ballotPlacement, List<Candidate> candidates, String referendumTitle, String referendumSubtitle, String referendumUrl, String referendumBrief, String referendumText, String referendumProStatement, String referendumConStatement, String referendumPassageThreshold, String referendumEffectOfAbstain, List<String> referendumBallotResponses, List<Source> sources) {
        this.id = id;
        this.type = type;
        this.primaryParty = primaryParty;
        this.electorateSpecifications = electorateSpecifications;
        this.special = special;
        this.office = office;
        this.level = level;
        this.roles = roles;
        this.district = district;
        this.numberElected = numberElected;
        this.numberVotingFor = numberVotingFor;
        this.ballotPlacement = ballotPlacement;
        this.candidates = candidates;
        this.referendumTitle = referendumTitle;
        this.referendumSubtitle = referendumSubtitle;
        this.referendumUrl = referendumUrl;
        this.referendumBrief = referendumBrief;
        this.referendumText = referendumText;
        this.referendumProStatement = referendumProStatement;
        this.referendumConStatement = referendumConStatement;
        this.referendumPassageThreshold = referendumPassageThreshold;
        this.referendumEffectOfAbstain = referendumEffectOfAbstain;
        this.referendumBallotResponses = referendumBallotResponses;
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", primaryParty='" + primaryParty + '\'' +
                ", electorateSpecifications='" + electorateSpecifications + '\'' +
                ", special='" + special + '\'' +
                ", office='" + office + '\'' +
                ", level=" + level +
                ", roles=" + roles +
                ", district=" + district +
                ", numberElected=" + numberElected +
                ", numberVotingFor=" + numberVotingFor +
                ", ballotPlacement=" + ballotPlacement +
                ", candidates=" + candidates +
                ", referendumTitle='" + referendumTitle + '\'' +
                ", referendumSubtitle='" + referendumSubtitle + '\'' +
                ", referendumUrl='" + referendumUrl + '\'' +
                ", referendumBrief='" + referendumBrief + '\'' +
                ", referendumText='" + referendumText + '\'' +
                ", referendumProStatement='" + referendumProStatement + '\'' +
                ", referendumConStatement='" + referendumConStatement + '\'' +
                ", referendumPassageThreshold='" + referendumPassageThreshold + '\'' +
                ", referendumEffectOfAbstain='" + referendumEffectOfAbstain + '\'' +
                ", referendumBallotResponses=" + referendumBallotResponses +
                ", sources=" + sources +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrimaryParty() {
        return primaryParty;
    }

    public void setPrimaryParty(String primaryParty) {
        this.primaryParty = primaryParty;
    }

    public String getElectorateSpecifications() {
        return electorateSpecifications;
    }

    public void setElectorateSpecifications(String electorateSpecifications) {
        this.electorateSpecifications = electorateSpecifications;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public List<String> getLevel() {
        return level;
    }

    public void setLevel(List<String> level) {
        this.level = level;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public long getNumberElected() {
        return numberElected;
    }

    public void setNumberElected(long numberElected) {
        this.numberElected = numberElected;
    }

    public long getNumberVotingFor() {
        return numberVotingFor;
    }

    public void setNumberVotingFor(long numberVotingFor) {
        this.numberVotingFor = numberVotingFor;
    }

    public long getBallotPlacement() {
        return ballotPlacement;
    }

    public void setBallotPlacement(long ballotPlacement) {
        this.ballotPlacement = ballotPlacement;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public String getReferendumTitle() {
        return referendumTitle;
    }

    public void setReferendumTitle(String referendumTitle) {
        this.referendumTitle = referendumTitle;
    }

    public String getReferendumSubtitle() {
        return referendumSubtitle;
    }

    public void setReferendumSubtitle(String referendumSubtitle) {
        this.referendumSubtitle = referendumSubtitle;
    }

    public String getReferendumUrl() {
        return referendumUrl;
    }

    public void setReferendumUrl(String referendumUrl) {
        this.referendumUrl = referendumUrl;
    }

    public String getReferendumBrief() {
        return referendumBrief;
    }

    public void setReferendumBrief(String referendumBrief) {
        this.referendumBrief = referendumBrief;
    }

    public String getReferendumText() {
        return referendumText;
    }

    public void setReferendumText(String referendumText) {
        this.referendumText = referendumText;
    }

    public String getReferendumProStatement() {
        return referendumProStatement;
    }

    public void setReferendumProStatement(String referendumProStatement) {
        this.referendumProStatement = referendumProStatement;
    }

    public String getReferendumConStatement() {
        return referendumConStatement;
    }

    public void setReferendumConStatement(String referendumConStatement) {
        this.referendumConStatement = referendumConStatement;
    }

    public String getReferendumPassageThreshold() {
        return referendumPassageThreshold;
    }

    public void setReferendumPassageThreshold(String referendumPassageThreshold) {
        this.referendumPassageThreshold = referendumPassageThreshold;
    }

    public String getReferendumEffectOfAbstain() {
        return referendumEffectOfAbstain;
    }

    public void setReferendumEffectOfAbstain(String referendumEffectOfAbstain) {
        this.referendumEffectOfAbstain = referendumEffectOfAbstain;
    }

    public List<String> getReferendumBallotResponses() {
        return referendumBallotResponses;
    }

    public void setReferendumBallotResponses(List<String> referendumBallotResponses) {
        this.referendumBallotResponses = referendumBallotResponses;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
