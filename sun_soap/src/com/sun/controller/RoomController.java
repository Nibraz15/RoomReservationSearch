package com.sun.controller;


import com.sun.service.RoomServices;
import com.sun.service.contractServices;
import com.sun.service.hotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


@WebService
public class RoomController {
    private contractServices contract = new contractServices();
    private RoomServices rooms = new RoomServices();


    public List searchRoom(String bookFrom , String bookTo, int numRooms , int numAdult){
        List<Long> cID = contract.searchByDate(bookFrom, bookTo);

        List<String> room = new ArrayList<>();
        if(cID.size()>0){
            for(int i = 0; i<cID.size();i++){

                List<String> temp = rooms.searchRoom(cID.get(i),numRooms,numAdult);
                for(int j = 0; j<temp.size();j++){
                    room.add(temp.get(j));
                }
            }
            return room;
        }
        else {
            room.add("No Rooms Available");
            return room;
        }
    }
}
