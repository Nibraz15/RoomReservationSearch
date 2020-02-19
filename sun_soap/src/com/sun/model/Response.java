package com.sun.model;

public class Response {
    private String h_name;
    private String room_Type;
    private int max_adult;
    private float price;

    public Response(String h_name, String room_Type, int max_adult , float price){
        this.h_name = h_name;
        this.room_Type =room_Type;
        this.max_adult = max_adult;
        this.price = price;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getRoom_Type() {
        return room_Type;
    }

    public void setRoom_Type(String room_Type) {
        this.room_Type = room_Type;
    }

    public int getMax_adult() {
        return max_adult;
    }

    public void setMax_adult(int max_adult) {
        this.max_adult = max_adult;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

