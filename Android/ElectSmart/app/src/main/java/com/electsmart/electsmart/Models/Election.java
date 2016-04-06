package com.electsmart.electsmart.Models;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by brand on 3/11/2016.
 */
public class Election implements Serializable{

    private int day;
    private int month;
    private int year;
    private int id;
    private String name;
    private HashMap<String, List<Candidate>> candidatePositionMap;

    public Election (int day, int month, int year, int id, String name, HashMap<String, List<Candidate>> hashMap){
        this.day = day;
        this.month = month;
        this.year = year;
        this.id = id;
        this.name = name;
        this.candidatePositionMap = hashMap;
    }

    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public List<String> getOpenPositions(){
        List<String> l = new ArrayList<String>();
        for (String key: candidatePositionMap.keySet()) {
            l.add(key);
        }
        return l;
    }
    public List<Candidate> getCandidates(String position){ return candidatePositionMap.get(position); }
    public HashMap<String, List<Candidate>> getMap(){
        return candidatePositionMap;
    }
    public boolean equals(Object obj){
        Election e = (Election) obj;
        if(this.day == e.getDay() &&
                this.year == e.getYear() &&
                this.month == e.getMonth() &&
                this.id == e.getId() &&
                this.name == e.getName()){
            return true;
        }else{
            return false;
        }
    }
}