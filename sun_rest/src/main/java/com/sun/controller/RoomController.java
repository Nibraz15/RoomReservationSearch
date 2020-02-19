package com.sun.controller;

import com.sun.model.Request;
import com.sun.service.ContractService;
import com.sun.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ContractService contractService;

    @PostMapping("/rooms")
    public ResponseEntity<?> reserve(@RequestBody Request request){
        List rooms = new ArrayList();
        List<Long> contracts = contractService.getContractByDate(Date.valueOf(request.getBookFrom())
                ,Date.valueOf(request.getBookFrom()));

        for (int i =0; i < contracts.size();i++){
            List temp = (roomService.list(contracts.get(i),request.getNumRoom(),request.getNumAdult()));
            for(int j=0; j<temp.size();j++){
                rooms.add(temp.get(i));
            }
        }

        return ResponseEntity.ok().body(rooms);
    }
}
