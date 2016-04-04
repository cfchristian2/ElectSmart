package com.electsmart.electsmart.Models;

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
    private HashMap<String, List<String>> candidatePositionMap;

    public Election (int day, int month, int year, int id, String name, HashMap<String, List<String>> hashMap){
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
    public HashMap<String, List<String>> getMap(){
        return candidatePositionMap;
    }
}
