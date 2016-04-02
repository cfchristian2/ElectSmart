package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

import java.util.List;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class PollingLocation {
    private String id;
    private Address address;
    private String notes;
    private String pollingHours;
    private String name;
    private String voterServices;
    private String startDate;
    private String endDate;
    private List<Source> sources;

    public PollingLocation() {
    }

    public PollingLocation(String id, Address address, String notes, String pollingHours, String name, String voterServices, String startDate, String endDate, List<Source> sources) {
        this.id = id;
        this.address = address;
        this.notes = notes;
        this.pollingHours = pollingHours;
        this.name = name;
        this.voterServices = voterServices;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sources = sources;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPollingHours() {
        return pollingHours;
    }

    public void setPollingHours(String pollingHours) {
        this.pollingHours = pollingHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoterServices() {
        return voterServices;
    }

    public void setVoterServices(String voterServices) {
        this.voterServices = voterServices;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "PollingLocation{" +
                "id='" + id + '\'' +
                ", address=" + address +
                ", notes='" + notes + '\'' +
                ", pollingHours='" + pollingHours + '\'' +
                ", name='" + name + '\'' +
                ", voterServices='" + voterServices + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", sources=" + sources +
                '}';
    }
}
