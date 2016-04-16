package com.electsmart.electsmart.API.votesmart.Models;

/**
 * Created by Josh Kasuboski on 4/16/16.
 */
public class GeneralInfo {
    private String title;
    private String linkBack;

    public GeneralInfo() {
    }

    public GeneralInfo(String title, String linkBack) {
        this.title = title;
        this.linkBack = linkBack;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkBack() {
        return linkBack;
    }

    public void setLinkBack(String linkBack) {
        this.linkBack = linkBack;
    }

    @Override
    public String toString() {
        return "GeneralInfo{" +
                "title='" + title + '\'' +
                ", linkBack='" + linkBack + '\'' +
                '}';
    }
}
