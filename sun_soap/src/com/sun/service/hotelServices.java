package com.sun.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.controller.DBconnection;
import com.sun.model.Contract;
import com.sun.model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class hotelServices {
    private DBconnection dBconnection = new DBconnection();

    public boolean checkHotel(String name){
        Connection connection = dBconnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(H_NAME) as name FROM E1197_HOTEL WHERE H_NAME = ?");
            stmt.setString(1,name);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();

            if(resultSet.getInt("name")>0){
                connection.close();
                return true;
            }
            else {
                connection.close();
                return false;
            }

        }catch (Exception e){
            return false;
        }
    }

    public long getHotelId(String name){
        Connection connection = dBconnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT H_ID FROM E1197_HOTEL WHERE H_NAME = ?");
            stmt.setString(1,name);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            return resultSet.getLong("H_ID");
        }catch (Exception e){
            return 0;
        }

    }

    public long addHotel(String name , String location){
        Connection connection = dBconnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO E1197_HOTEL (H_NAME,LOCATION) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,name);
            stmt.setString(2,location);
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.next();
            String rowID = resultSet.getString(1);
            stmt = connection.prepareStatement("SELECT H_ID FROM E1197_HOTEL WHERE ROWID = ? ");
            stmt.setString(1,rowID);
            stmt.execute();
            resultSet = stmt.getResultSet();
            resultSet.next();
            return resultSet.getLong("H_ID");
        }catch (Exception e){
            return 0;
        }
    }

    public List<String> getHotels(){
        List<String> hotels = new ArrayList< >();
        Connection connection = dBconnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM E1197_HOTEL");
            ResultSet resultSet = stmt.executeQuery();
            ObjectMapper obj = new ObjectMapper();
            while (resultSet.next()) {
                Hotel hotel = new Hotel(resultSet.getLong("H_ID"),
                        resultSet.getString("H_NAME"),
                        resultSet.getString("LOCATION"));

                hotels.add(obj.writeValueAsString(hotel));
            }
            connection.close();
            return  hotels;

        }catch (Exception e){
            hotels.add("Db Connection No established try again");
            return hotels;
        }
    }
}
