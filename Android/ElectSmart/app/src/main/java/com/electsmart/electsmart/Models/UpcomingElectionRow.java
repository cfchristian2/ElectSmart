package com.electsmart.electsmart.Models;

/**
 * Created by brand on 3/11/2016.
 */
public class UpcomingElectionRow {
    private Election left;
    private Election right;

    public UpcomingElectionRow(int dayLeft, int monthLeft, int yearLeft, int idLeft, String nameLeft,
                               int dayRight, int monthRight, int yearRight, int idRight, String nameRight){
        this.left = new Election(dayLeft, monthLeft, yearLeft, idLeft, nameLeft);
        this.right = new Election(dayRight, monthRight, yearRight, idRight, nameRight);
    }

    public Election getLeft(){
        return this.left;
    }
    public Election getRight(){
        return this.right;
    }
}
