package com.sun.dao;

import com.sun.model.Room;
import java.util.List;

public interface RoomDao {
    long save(Room room);
    Room get(long id);
    List list(long id , int numRoom , int numAdult);
    void update(long id , Room room);
    void delete(long id);
}
