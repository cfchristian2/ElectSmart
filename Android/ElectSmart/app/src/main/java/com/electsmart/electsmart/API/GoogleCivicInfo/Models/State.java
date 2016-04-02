package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

import java.util.List;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class State {
    private String id;
    private String name;
    private ElectionAdminBody electionAdministrationBody;
    private String local_jurisdiction;
    private List<Source> sources;

    public State() {
    }

    public State(String id, String name, ElectionAdminBody electionAdministrationBody, String local_jurisdiction, List<Source> sources) {
        this.id = id;
        this.name = name;
        this.electionAdministrationBody = electionAdministrationBody;
        this.local_jurisdiction = local_jurisdiction;
        this.sources = sources;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElectionAdminBody getElectionAdministrationBody() {
        return electionAdministrationBody;
    }

    public void setElectionAdministrationBody(ElectionAdminBody electionAdministrationBody) {
        this.electionAdministrationBody = electionAdministrationBody;
    }

    public String getLocal_jurisdiction() {
        return local_jurisdiction;
    }

    public void setLocal_jurisdiction(String local_jurisdiction) {
        this.local_jurisdiction = local_jurisdiction;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @Override
    public String toString() {
        return "State{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", electionAdministrationBody=" + electionAdministrationBody +
                ", local_jurisdiction='" + local_jurisdiction + '\'' +
                ", sources=" + sources +
                '}';
    }
}
