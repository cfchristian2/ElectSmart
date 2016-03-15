package com.electsmart.electsmart.Models;

/**
 * Created by brand on 3/11/2016.
 */
public class Election {

    private int day;
    private int month;
    private int year;
    private int id;
    private String name;

    public Election (int day, int month, int year, int id, String name){
        this.day = day;
        this.month = month;
        this.year = year;
        this.id = id;
        this.name = name;
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
}
