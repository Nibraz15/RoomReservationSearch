package com.sun.model;

import javax.persistence.*;
import javax.xml.soap.Name;
import java.sql.Date;

@Entity(name = "E1197_CONTRACT")
@Table(name = "E1197_CONTRACT")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long c_id;
    @Column
    private double markup;
    @Column
    private Date validFrom;
    @Column
    private Date validTo;
    @Column
    private String max_adult;
    @Column
    private String room_type;
    @Column
    private String room_count;
    @Column
    private String price;

    @ManyToOne(targetEntity = Hotel.class , fetch = FetchType.LAZY , cascade=CascadeType.ALL)
    @JoinColumn(name = "h_id",referencedColumnName = "h_id")
    private Hotel hotels = new Hotel();

    protected Contract() {
    }
    public Contract(Hotel hotels,String room_type,String max_adult, String room_count, String price , double markup, Date validFrom,Date validTo){
        this.hotels = hotels;
        this.room_type = room_type;
        this.max_adult = max_adult;
        this.room_count = room_count;
        this.price = price;
        this.markup = markup;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Hotel getHotels() {
        return hotels;
    }

    public void setHotels(Hotel hotels) {
        this.hotels = hotels;
    }

    public String getMax_adult() {
        return max_adult;
    }

    public void setMax_adult(String max_adult) {
        this.max_adult = max_adult;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_count() {
        return room_count;
    }

    public void setRoom_count(String room_count) {
        this.room_count = room_count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
