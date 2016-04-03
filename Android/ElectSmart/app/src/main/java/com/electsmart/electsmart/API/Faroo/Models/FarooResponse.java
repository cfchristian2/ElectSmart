package com.electsmart.electsmart.API.Faroo.Models;

import java.util.ArrayList;

/**
 * Created by Scott on 4/3/2016.
 */
public class FarooResponse {
    private ArrayList<FarooArticle> results;

    public FarooResponse(){
        this.results = new ArrayList<FarooArticle>();
    }

    public ArrayList<FarooArticle> getFarooArticles(){
        return results;
    }

    public void setFarooArticles(ArrayList<FarooArticle> farooArticles){
        this.results = farooArticles;
    }

}
