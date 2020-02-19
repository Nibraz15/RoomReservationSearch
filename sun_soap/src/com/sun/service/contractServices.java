package com.sun.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.controller.DBconnection;
import com.sun.model.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class contractServices {

    private DBconnection dBconnection = new DBconnection();
    public List<String> getContracts(){
        List<String> contracts = new ArrayList< >();
        Connection connection = dBconnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM E1197_CONTRACT");
            ResultSet resultSet = stmt.executeQuery();
            ObjectMapper obj = new ObjectMapper();
            while (resultSet.next()) {
                Contract contract = new Contract(resultSet.getLong("C_ID"),
                        resultSet.getLong("H_ID"),
                        resultSet.getString("ROOM_TYPE"),
                        resultSet.getString("MAX_ADULT"),
                        resultSet.getString("ROOM_COUNT"),
                        resultSet.getString("PRICE"),
                        resultSet.getDouble("MARKUP"),
                        (resultSet.getDate("VALIDFROM")).toString(),
                        (resultSet.getDate("VALIDTO")).toString());

                contracts.add(obj.writeValueAsString(contract));
            }
            connection.close();
            return  contracts;

        }catch (Exception e){
            contracts.add("Db Connection No established try again");
            return contracts;
        }
    }

    public contractServices(){}

    public long addContract(long h_id,String room_type,String max_adult, String room_count, String price , float markup, String validFrom,String validTo) {
        Connection connection = dBconnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO E1197_CONTRACT (MARKUP,MAX_ADULT,PRICE,ROOM_COUNT,ROOM_TYPE,VALIDFROM,VALIDTO,H_ID) VALUES (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(8, h_id);
            stmt.setString(5, room_type);
            stmt.setString(2, max_adult);
            stmt.setString(4, room_count);
            stmt.setString(3, price);
            stmt.setFloat(1, markup);
            stmt.setDate(6, Date.valueOf(validFrom));
            stmt.setDate(7, Date.valueOf(validTo));
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.next();
            String rowID = resultSet.getString(1);
            stmt = connection.prepareStatement("SELECT C_ID FROM E1197_CONTRACT WHERE ROWID = ? ");
            stmt.setString(1,rowID);
            stmt.execute();
            resultSet = stmt.getResultSet();
            resultSet.next();
            long C_ID = resultSet.getLong("C_ID");
            return C_ID;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Long> searchByDate(String bookFrom, String bookTo){
        Connection connection = dBconnection.getConnection();
        List<Long> cId = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT C_ID FROM E1197_CONTRACT WHERE VALIDFROM <= ? AND VALIDTO >= ?");
            stmt.setDate(1,Date.valueOf(bookFrom));
            stmt.setDate(2,Date.valueOf(bookTo));
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                cId.add(resultSet.getLong("C_ID"));
            }
            return cId;
        }catch (Exception e){
            return cId;
        }
    }
}
