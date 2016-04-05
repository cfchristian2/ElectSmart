package com.electsmart.electsmart.API.bing.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("__metadata")
@Expose
private com.electsmart.electsmart.API.bing.Models.Metadata Metadata;
@SerializedName("ID")
@Expose
private String ID;
@SerializedName("Title")
@Expose
private String Title;
@SerializedName("Url")
@Expose
private String Url;
@SerializedName("Source")
@Expose
private String Source;
@SerializedName("Description")
@Expose
private String Description;
@SerializedName("Date")
@Expose
private String Date;

/**
* 
* @return
* The Metadata
*/
public com.electsmart.electsmart.API.bing.Models.Metadata getMetadata() {
return Metadata;
}

/**
* 
* @param Metadata
* The __metadata
*/
public void setMetadata(com.electsmart.electsmart.API.bing.Models.Metadata Metadata) {
this.Metadata = Metadata;
}

/**
* 
* @return
* The ID
*/
public String getID() {
return ID;
}

/**
* 
* @param ID
* The ID
*/
public void setID(String ID) {
this.ID = ID;
}

/**
* 
* @return
* The Title
*/
public String getTitle() {
return Title;
}

/**
* 
* @param Title
* The Title
*/
public void setTitle(String Title) {
this.Title = Title;
}

/**
* 
* @return
* The Url
*/
public String getUrl() {
return Url;
}

/**
* 
* @param Url
* The Url
*/
public void setUrl(String Url) {
this.Url = Url;
}

/**
* 
* @return
* The Source
*/
public String getSource() {
return Source;
}

/**
* 
* @param Source
* The Source
*/
public void setSource(String Source) {
this.Source = Source;
}

/**
* 
* @return
* The Description
*/
public String getDescription() {
return Description;
}

/**
* 
* @param Description
* The Description
*/
public void setDescription(String Description) {
this.Description = Description;
}

/**
* 
* @return
* The Date
*/
public String getDate() {
return Date;
}

/**
* 
* @param Date
* The Date
*/
public void setDate(String Date) {
this.Date = Date;
}

}