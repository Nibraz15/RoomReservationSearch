package com.sun.dao;

import com.sun.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class HotelDaoImpl implements HotelDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Hotel hotel) {
        sessionFactory.getCurrentSession().save(hotel);
        return hotel.getH_id();

    }
    @Override
    public Hotel get(long id) {
        return sessionFactory.getCurrentSession().get(Hotel.class, id);
    }
    @Override
    public List<Hotel> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Hotel> cq = cb.createQuery(Hotel.class);
        Root<Hotel> root = cq.from(Hotel.class);
        cq.select(root);
        Query<Hotel> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public boolean getname(String name) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT h_name FROM E1197_HOTEL WHERE h_name = :name";
        Query query = session.createQuery(sql);
        query.setParameter("name",name);
        List<String> queryResultList = query.getResultList();
        if (queryResultList.size()>0){
            return true;
        }
        return  false;

    }

    @Override
    public long getHotel(String name) {
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT distinct h_id FROM E1197_HOTEL WHERE h_name = :name");
        query.setParameter("name",name);
        List<Long> querl = query.getResultList();
        System.out.println(querl.get(0));
        return querl.get(0);


    }

    @Override
    public void update(long id, Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel2 = session.byId(Hotel.class).load(id);
        hotel2.setH_name(hotel.getH_name());
        hotel2.setLocation(hotel.getLocation());
        session.flush();

    }
    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = session.byId(Hotel.class).load(id);
        session.delete(hotel);
    }
}
