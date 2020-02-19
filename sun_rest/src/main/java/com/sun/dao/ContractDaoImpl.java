package com.sun.dao;

import com.sun.model.Contract;

import java.util.Date;
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
public class ContractDaoImpl implements ContractDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Contract contract) {
        sessionFactory.getCurrentSession().save(contract);
        return contract.getC_id();
    }

    @Override
    public Contract get(long id) {
        return sessionFactory.getCurrentSession().get(Contract.class, id);
    }

    @Override
    public List<Long> getContractByDate(Date from, Date to) {
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT c_id FROM E1197_CONTRACT WHERE validFrom <= :from and validTo >= :to");
        query.setParameter("from",from);
        query.setParameter("to",to);
        List<Long> contractlist = query.getResultList();
        return  contractlist;
    }

    @Override
    public List list() {
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT hotels.h_name , room_type , room_count , max_adult , markup , validFrom , validTo FROM E1197_CONTRACT");
        return  query.getResultList();
    }

    @Override
    public void update(long id, Contract contract) {
        Session session = sessionFactory.getCurrentSession();
        Contract contract2 = session.byId(Contract.class).load(id);
        contract2.setHotels(contract.getHotels());
        contract2.setMarkup(contract.getMarkup());
        contract2.setValidFrom(contract.getValidFrom());
        contract2.setValidTo(contract.getValidTo());
        contract2.setMax_adult(contract.getMax_adult());
        contract2.setRoom_count(contract.getRoom_count());
        contract2.setPrice(contract.getPrice());
        contract2.setRoom_type(contract.getRoom_type());
        session.flush();

    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Contract contract = session.byId(Contract.class).load(id);
        session.delete(contract);
    }
}
