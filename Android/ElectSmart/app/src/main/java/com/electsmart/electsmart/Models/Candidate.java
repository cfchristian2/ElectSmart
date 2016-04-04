package com.electsmart.electsmart.Models;

import java.io.Serializable;

/**
 * Created by brand on 4/4/2016.
 */
public class Candidate implements Serializable {
    private String name;

    public Candidate(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
