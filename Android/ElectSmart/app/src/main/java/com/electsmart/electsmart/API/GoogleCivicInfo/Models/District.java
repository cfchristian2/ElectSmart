package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class District {
    private String name;
    private String scope;
    private String id;

    public District(String name, String scope, String id) {
        this.name = name;
        this.scope = scope;
        this.id = id;
    }

    public District() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", scope='" + scope + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
