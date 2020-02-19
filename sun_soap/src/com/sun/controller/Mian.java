package com.sun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.model.Contract;
import com.sun.model.Response;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mian {

    public  static void main(String[] args){
        DBconnection dBconnection = new DBconnection();
        String bookFrom = "2020-02-10";
        String bookTo = "2020-02-20";
        long cID = 30;
        int numRooms = 1;
        int numAdult = 2;

        Connection connection = dBconnection.getConnection();
        List<String> rooms = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT E1197_HOTEL.H_NAME AS H_NAME  , E1197_ROOM.ROOM_TYPE AS ROOM_TYPE , E1197_ROOM.MAX_ADULT AS MAX_ADULT , E1197_ROOM.PRICE*((1+E1197_CONTRACT.MARKUP)*?) AS PRICE FROM E1197_ROOM INNER JOIN E1197_HOTEL ON E1197_HOTEL.H_ID = E1197_ROOM.H_ID INNER JOIN E1197_CONTRACT ON E1197_ROOM.C_ID =E1197_CONTRACT.C_ID \n" +
                    "WHERE E1197_ROOM.C_ID = ? AND E1197_ROOM.NUM_ROOM >= ? AND E1197_ROOM.MAX_ADULT*? >= ? ");

            stmt.setInt(1,numAdult);
            stmt.setLong(2,cID);
            stmt.setInt(3,numRooms);
            stmt.setInt(4,numRooms);
            stmt.setInt(5,numAdult);

            stmt.execute();
            System.out.println("asd");
            ResultSet resultSet = stmt.getResultSet();
            ObjectMapper obj = new ObjectMapper();
            System.out.println("asd");
            while (resultSet.next()){
                Response response = new Response(resultSet.getString("H_NAME"),
                        resultSet.getString("ROOM_TYPE"),
                        resultSet.getInt("MAX_ADULT"),
                        resultSet.getFloat("PRICE"));
                System.out.println(obj.writeValueAsString(response));
            }


        }catch (Exception e){
            System.out.println("ee");
        }



    }
}
