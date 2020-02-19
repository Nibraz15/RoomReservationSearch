package com.sun.service;

import com.sun.model.Hotel;

import java.util.List;

public interface HotelService {
    long save(Hotel hotel);
    Hotel get(long id);
    boolean getname(String name);
    long getHotel(String name);
    List<Hotel> list();
    void update(long id , Hotel hotel);
    void delete(long id);
}
