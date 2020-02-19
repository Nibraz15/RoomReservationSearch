package com.sun.service;

import com.sun.dao.HotelDao;
import com.sun.model.Hotel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;

    @Transactional
    @Override
    public long save(Hotel hotel) {
        return hotelDao.save(hotel);
    }

    @Override
    public Hotel get(long id) {
        return hotelDao.get(id);
    }


    @Override
    public boolean getname(String name) {
        return  hotelDao.getname(name);
    }

    @Override
    public long getHotel(String name) {
        return hotelDao.getHotel(name);
    }


    @Override
    public List<Hotel> list() {
        return hotelDao.list();
    }

    @Override
    public void update(long id, Hotel hotel) {
        hotelDao.update(id, hotel);

    }

    @Override
    public void delete(long id) {
        hotelDao.delete(id);
    }
}
