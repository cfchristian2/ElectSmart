package com.electsmart.electsmart.Messages;

import com.electsmart.electsmart.Models.Election;

/**
 * Created by brand on 3/16/2016.
 */
public class ElectionMessage {
    public final Election election;

    public ElectionMessage(Election election){
        this.election = election;
    }
}
