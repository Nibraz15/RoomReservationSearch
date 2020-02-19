package com.sun.dao;

import com.sun.model.Room;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
@Repository
public class RoomDaoImpl implements RoomDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Room room) {
        sessionFactory.getCurrentSession().save(room);
        return room.getR_id();
    }

    @Override
    public Room get(long id) {
        return sessionFactory.getCurrentSession().get(Room.class, id);
    }

    @Override
    public List list(long id , int numRoom , int numAdult) {
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT hotels.h_name , room_type , max_adult , price*(1+contract.markup) FROM E1197_ROOM WHERE max_adult*num_room >= :numAdult and num_room >= :rooms");
        query.setParameter("numAdult",numAdult);
        query.setParameter("rooms",numRoom);
        List<Long> contractlist = query.getResultList();
        return  contractlist;
    }

    @Override
    public void update(long id, Room room) {
        Session session = sessionFactory.getCurrentSession();
        Room room2 = session.byId(Room.class).load(id);
        room2.setContract(room.getContract());
        room2.setHotels(room.getHotels());
        room2.setMax_adult(room.getMax_adult());
        room2.setPrice(room.getPrice());
        room2.setRoom_type(room2.getRoom_type());

    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Room room = session.byId(Room.class).load(id);
        session.delete(room);
    }
}
