package com.sun.model;

import java.sql.Date;

public class Request {
    private String bookFrom;
    private String bookTo;
    private int numRoom;
    private int numAdult;

    private Request(){}

    public Request(String bookFrom, String bookTo, int numRoom, int numAdult) {
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.numRoom = numRoom;
        this.numAdult = numAdult;
    }

    public String getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(String bookFrom) {
        this.bookFrom = bookFrom;
    }

    public String getNights() {
        return bookTo;
    }

    public void setNights(String bookTo) {
        this.bookTo = bookTo;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getNumAdult() {
        return numAdult;
    }

    public void setNumAdult(int numAdult) {
        this.numAdult = numAdult;
    }
}
