package com.sun.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.controller.DBconnection;
import com.sun.model.Contract;
import com.sun.model.Hotel;
import com.sun.model.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomServices {
    private DBconnection dBconnection = new DBconnection();
    public RoomServices(){}
    public void addRoom(long c_id , long h_id,
                        int max_adult , String room_type , int num_room, float price) {
        Connection connection = dBconnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO E1197_ROOM (C_ID,H_ID,MAX_ADULT,ROOM_TYPE,NUM_ROOM,PRICE) VALUES (?,?,?,?,?,?)");
            stmt.setLong(1, c_id);
            stmt.setLong(2, h_id);
            stmt.setInt(3,max_adult);
            stmt.setString(4, room_type);
            stmt.setInt(5,num_room);
            stmt.setFloat(6,price);
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.next();
            connection.close();
        } catch (Exception e) {

        }
    }

    public List<String> searchRoom(long cID , int numRooms , int numAdult ){
        Connection connection = dBconnection.getConnection();
        List<String> rooms = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT E1197_HOTEL.H_NAME AS H_NAME  , E1197_ROOM.ROOM_TYPE AS ROOM_TYPE , E1197_ROOM.MAX_ADULT AS MAX_ADULT , E1197_ROOM.PRICE*((1+E1197_CONTRACT.MARKUP)*?) AS PRICE FROM E1197_ROOM INNER JOIN E1197_HOTEL ON E1197_HOTEL.H_ID = E1197_ROOM.H_ID INNER JOIN E1197_CONTRACT ON E1197_ROOM.C_ID =E1197_CONTRACT.C_ID \n" +
                    "WHERE E1197_ROOM.C_ID = ? AND E1197_ROOM.NUM_ROOM >= ? AND E1197_ROOM.MAX_ADULT*(?) >= ? ");
            stmt.setInt(1,numAdult);
            stmt.setLong(2,cID);
            stmt.setInt(3,numRooms);
            stmt.setInt(4,numRooms);
            stmt.setInt(5,numAdult);
            stmt.execute();
            ResultSet resultSet = stmt.getResultSet();
            ObjectMapper obj = new ObjectMapper();
            while (resultSet.next()){
                Response response = new Response(resultSet.getString("H_NAME"),
                                                    resultSet.getString("ROOM_TYPE"),
                        resultSet.getInt("MAX_ADULT"),
                        resultSet.getFloat("PRICE"));
                rooms.add(obj.writeValueAsString(response));
            }
            return rooms;

        }catch (Exception e){
            return rooms;
        }

    }
}
