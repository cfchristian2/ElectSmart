package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class ElectionOfficial {
    private String name;
    private String title;
    private String officePhoneNumber;
    private String faxNumber;
    private String emailAddress;

    public ElectionOfficial() {
    }

    public ElectionOfficial(String name, String title, String officePhoneNumber, String faxNumber, String emailAddress) {
        this.name = name;
        this.title = title;
        this.officePhoneNumber = officePhoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOfficePhoneNumber() {
        return officePhoneNumber;
    }

    public void setOfficePhoneNumber(String officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "ElectionOfficial{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", officePhoneNumber='" + officePhoneNumber + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
