package com.sun.dao;

import com.sun.model.Hotel;

import java.util.Date;
import java.util.List;

public interface HotelDao {

   long save(Hotel hotel);
    Hotel get(long id);
    List<Hotel> list();

    boolean getname(String name);
    long getHotel(String name);
    void update(long id , Hotel hotel);
    void delete(long id);
}
