package com.electsmart.electsmart.API.Faroo.Models;

import java.util.Date;

/**
 * Created by Scott on 4/3/2016.
 */
public class FarooArticle {
    private String title;
    private String url;
    private String domain;
    private String iurl;
    private Date firstIndexed;
    private Date firstPublished;
    private String kwic;
    private String author;
    private int votes;
    private boolean isNews;

    public FarooArticle(){

    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getDomain(){
        return domain;
    }

    public void setDomain(String domain){
        this.domain = domain;
    }

    public String getIurl(){
        return iurl;
    }

    public void setIurl(String iurl){
        this.iurl = iurl;
    }

    public String getKwic(){
        return kwic;
    }

    public void setKwic(String kwic){
        this.kwic = kwic;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Date getFirstIndexed(){
        return firstIndexed;
    }

    public void setFirstIndexed(Date firstIndexed){
        this.firstIndexed = firstIndexed;
    }

    public Date getFirstPublished(){
        return firstPublished;
    }

    public void setFirstPublished(Date firstPublished){
        this.firstPublished = firstPublished;
    }

    public int getVotes(){
        return votes;
    }

    public void setVotes(int votes){
        this.votes = votes;
    }

    public boolean getIsNews(){
        return isNews;
    }

    public void setIsNews(boolean isNews){
        this.isNews = isNews;
    }
}
