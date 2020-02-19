package com.sun.service;

import com.sun.dao.RoomDao;
import com.sun.model.Room;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Transactional
    @Override
    public long save(Room room) {
        return roomDao.save(room);
    }

    @Override
    public Room get(long id) {
        return roomDao.get(id);
    }

    @Override
    public List list(long id , int numRoom , int numAdult) {
        return roomDao.list(id, numRoom, numAdult);
    }

    @Override
    public void update(long id, Room room) {
        roomDao.update(id, room);
    }

    @Override
    public void delete(long id) {
        roomDao.delete(id);
    }
}
