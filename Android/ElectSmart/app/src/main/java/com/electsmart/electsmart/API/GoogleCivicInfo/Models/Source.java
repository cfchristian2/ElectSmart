package com.electsmart.electsmart.API.GoogleCivicInfo.Models;

/**
 * Created by Josh Kasuboski on 4/2/16.
 */
public class Source {
    private String name;
    private boolean official;

    public Source() {
    }

    public Source(String name, boolean official) {
        this.name = name;
        this.official = official;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", official=" + official +
                '}';
    }
}
