package com.sun.model;

public class PaperContract {
    private String h_name ;
    private String location;
    private String max_adult;
    private String room_type;
    private String room_count;
    private String price;
    private Double markup;
    private String validFrom;
    private String validTo;

    private PaperContract(){}

    public PaperContract(String h_name, String location, String max_adult, String room_type, String room_count, String price, Double markup, String validFrom, String validTo) {
        this.h_name = h_name;
        this.location = location;
        this.max_adult = max_adult;
        this.room_type = room_type;
        this.room_count = room_count;
        this.price = price;
        this.markup = markup;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public String getH_name() {
        return h_name;
    }

    public String getLocation() {
        return location;
    }

    public String getMax_adult() {
        return max_adult;
    }

    public String getRoom_type() {
        return room_type;
    }

    public String getRoom_count() {
        return room_count;
    }

    public String getPrice() {
        return price;
    }

    public Double getMarkup() {
        return markup;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public String getValidTo() {
        return validTo;
    }
}
