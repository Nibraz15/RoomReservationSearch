package com.sun.dao;

import com.sun.model.Contract;


import java.util.Date;
import java.util.List;

public interface ContractDao {
    long save(Contract contract);
    Contract get(long id);
    List<Long> getContractByDate(Date from , Date to);
    List list();
    void update(long id , Contract contract);
    void delete(long id);
}
