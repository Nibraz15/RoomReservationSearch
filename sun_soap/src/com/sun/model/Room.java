package com.sun.model;

import javax.persistence.*;

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private  long r_id;
    @Column
    private int max_adult;
    @Column
    private String room_type;
    @Column
    private float price;
    @Column
    private int num_room;
    @ManyToOne(targetEntity = Contract.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id" , referencedColumnName = "c_id")
    private Contract contract = new Contract();
    @ManyToOne(targetEntity = Hotel.class , fetch = FetchType.LAZY)
    @JoinColumn(name = "h_id" , referencedColumnName = "h_id" , nullable = false)
    private Hotel hotels = new Hotel();

    protected Room() {
    }

    public Room(Contract contract , Hotel hotels,
                      int max_adult , String room_type ,int num_room, float price ){
        this.contract = contract;
        this.num_room = num_room;
        this.hotels = hotels;
        this.room_type = room_type;
        this.max_adult = max_adult;
        this.price = price;
    }

    public long getR_id() {
        return r_id;
    }

    public void setR_id(long r_id) {
        this.r_id = r_id;
    }

    public int getMax_adult() {
        return max_adult;
    }

    public void setMax_adult(int max_adult) {
        this.max_adult = max_adult;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Hotel getHotels() {
        return hotels;
    }

    public void setHotels(Hotel hotels) {
        this.hotels = hotels;
    }

    public int getNum_room() {
        return num_room;
    }

    public void setNum_room(int num_room) {
        this.num_room = num_room;
    }
}
