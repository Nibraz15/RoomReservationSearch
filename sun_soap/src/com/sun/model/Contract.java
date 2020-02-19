package com.sun.model;

import javax.persistence.*;
import java.sql.Date;


public class Contract {

    private Long c_id;
    private double markup;
    private String validFrom;
    private String validTo;
    private String max_adult;
    private String room_type;
    private String room_count;
    private String price;
    private long h_id;
    public Contract() {
    }
    public Contract(long c_id,long h_id,String room_type,String max_adult, String room_count, String price , double markup, String validFrom,String validTo){
        this.c_id = c_id;
        this.h_id = h_id;
        this.room_type = room_type;
        this.max_adult = max_adult;
        this.room_count = room_count;
        this.price = price;
        this.markup = markup;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    public long getC_id() {
        return c_id;
    }

    public long getHotels() { return h_id; }

    public String getRoom_type() {
        return room_type;
    }

    public String getRoom_count() {
        return room_count;
    }

    public String getMax_adult() {
        return max_adult;
    }

    public double getMarkup() {
        return markup;
    }

    public String getPrice() {
        return price;
    }

    public String getValidFrom() { return validFrom; }

    public String getValidTo() { return validTo; }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public void setHotels(long h_id) {
        this.h_id = h_id;
    }

    public void setMax_adult(String max_adult) {
        this.max_adult = max_adult;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
