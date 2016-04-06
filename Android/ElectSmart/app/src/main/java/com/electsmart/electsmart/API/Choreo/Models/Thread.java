package com.electsmart.electsmart.API.Choreo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Thread {

    @SerializedName("cursor")
    @Expose
    private Cursor cursor;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("response")
    @Expose
    private List<Response> response = new ArrayList<Response>();

    /**
     *
     * @return
     * The cursor
     */
    public Cursor getCursor() {
        return cursor;
    }

    /**
     *
     * @param cursor
     * The cursor
     */
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    /**
     *
     * @return
     * The code
     */
    public Integer getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The response
     */
    public List<Response> getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(List<Response> response) {
        this.response = response;
    }

}