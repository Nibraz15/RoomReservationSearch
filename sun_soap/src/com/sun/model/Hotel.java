package com.sun.model;

import javax.persistence.*;

@Entity(name = "E1197_HOTEL")
@Table(name = "E1197_HOTEL")
public class Hotel {


    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long h_id;
    @Column
    private String h_name ;
    @Column
    private String location;

    protected Hotel() {
    }
    public Hotel(String h_name , String location){
        this.h_name = h_name;
        this.location = location;

    }
    public Hotel(long h_id, String h_name , String location){
        this.h_id = h_id;
        this.h_name = h_name;
        this.location = location;

    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getH_name() {
        return h_name;
    }
    public String getLocation() {
        return location;
    }
    public Long getH_id() {
        return h_id;
    }

    public void setH_id(Long h_id) {
        this.h_id = h_id;
    }

}
