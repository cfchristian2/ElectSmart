package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class Candidate implements Serializable{
    private String name;
    private String party;
    private String candidateUrl;
    private String phone;
    private String photoUrl;
    private String email;
    private long orderOnBallot;
    private List<Channel> channels;

    public Candidate() {
    }

    public Candidate(String name, String party, String candidateUrl, String phone, String photoUrl, String email, long orderOnBallot, List<Channel> channels) {
        this.name = name;
        this.party = party;
        this.candidateUrl = candidateUrl;
        this.phone = phone;
        this.photoUrl = photoUrl;
        this.email = email;
        this.orderOnBallot = orderOnBallot;
        this.channels = channels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCandidateUrl() {
        return candidateUrl;
    }

    public void setCandidateUrl(String candidateUrl) {
        this.candidateUrl = candidateUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getOrderOnBallot() {
        return orderOnBallot;
    }

    public void setOrderOnBallot(long orderOnBallot) {
        this.orderOnBallot = orderOnBallot;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", candidateUrl='" + candidateUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", email='" + email + '\'' +
                ", orderOnBallot=" + orderOnBallot +
                ", channels=" + channels +
                '}';
    }
}
