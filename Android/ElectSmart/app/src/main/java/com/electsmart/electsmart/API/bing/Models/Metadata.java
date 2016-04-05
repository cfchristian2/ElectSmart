package com.electsmart.electsmart.API.bing.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

@SerializedName("uri")
@Expose
private String uri;
@SerializedName("type")
@Expose
private String type;

/**
* 
* @return
* The uri
*/
public String getUri() {
return uri;
}

/**
* 
* @param uri
* The uri
*/
public void setUri(String uri) {
this.uri = uri;
}

/**
* 
* @return
* The type
*/
public String getType() {
return type;
}

/**
* 
* @param type
* The type
*/
public void setType(String type) {
this.type = type;
}

}