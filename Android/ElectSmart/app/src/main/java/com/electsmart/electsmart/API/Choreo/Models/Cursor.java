package com.electsmart.electsmart.API.Choreo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Cursor {

    @SerializedName("prev")
    @Expose
    private Object prev;
    @SerializedName("hasNext")
    @Expose
    private Boolean hasNext;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("hasPrev")
    @Expose
    private Boolean hasPrev;
    @SerializedName("total")
    @Expose
    private Object total;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("more")
    @Expose
    private Boolean more;

    /**
     *
     * @return
     * The prev
     */
    public Object getPrev() {
        return prev;
    }

    /**
     *
     * @param prev
     * The prev
     */
    public void setPrev(Object prev) {
        this.prev = prev;
    }

    /**
     *
     * @return
     * The hasNext
     */
    public Boolean getHasNext() {
        return hasNext;
    }

    /**
     *
     * @param hasNext
     * The hasNext
     */
    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     *
     * @return
     * The next
     */
    public String getNext() {
        return next;
    }

    /**
     *
     * @param next
     * The next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     *
     * @return
     * The hasPrev
     */
    public Boolean getHasPrev() {
        return hasPrev;
    }

    /**
     *
     * @param hasPrev
     * The hasPrev
     */
    public void setHasPrev(Boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    /**
     *
     * @return
     * The total
     */
    public Object getTotal() {
        return total;
    }

    /**
     *
     * @param total
     * The total
     */
    public void setTotal(Object total) {
        this.total = total;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The more
     */
    public Boolean getMore() {
        return more;
    }

    /**
     *
     * @param more
     * The more
     */
    public void setMore(Boolean more) {
        this.more = more;
    }

}
