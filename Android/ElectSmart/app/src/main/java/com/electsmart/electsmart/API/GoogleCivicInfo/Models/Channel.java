package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class Channel {
    private String type;
    private String id;

    public Channel() {
    }

    public Channel(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
