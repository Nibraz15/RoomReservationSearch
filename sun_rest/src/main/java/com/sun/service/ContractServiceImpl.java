package com.sun.service;

import com.sun.dao.ContractDao;
import com.sun.model.Contract;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao contractDao;

    @Transactional
    @Override
    public long save(Contract contract) {
        return contractDao.save(contract);
    }

    @Override
    public Contract get(long id) {
        return contractDao.get(id);
    }

    @Override
    public List<Long> getContractByDate(Date from, Date to) {
        return contractDao.getContractByDate(from,to);
    }

    @Override
    public List list() {
        return contractDao.list();
    }

    @Override
    public void update(long id, Contract contract) {
        contractDao.update(id, contract);
    }

    @Override
    public void delete(long id) {
        contractDao.delete(id);
    }
}
