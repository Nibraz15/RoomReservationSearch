package com.sun.controller;

import com.sun.model.Contract;
import com.sun.model.Hotel;
import com.sun.model.Room;
import com.sun.model.PaperContract;
import com.sun.service.ContractService;
import com.sun.service.HotelService;
import com.sun.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ContractController {
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private RoomService roomService;

    @GetMapping
    public  ResponseEntity<List<Contract>> list(){
        List<Contract> contracts = contractService.list();
        return ResponseEntity.ok().body(contracts);
    }

    @PostMapping("/contract")
    public ResponseEntity<?> save(@RequestBody PaperContract paperContract){
        String room_type = paperContract.getRoom_type().replace(" ", "");
        room_type = room_type.replace(",", " ");
        String roomtypes[] = room_type.split("\\s");

        String room_count = paperContract.getRoom_count().replace(" ", "");
        room_count = room_count.replace(",", " ");
        String room_counts[] = room_count.split("\\s");

        String max_adult = paperContract.getMax_adult().replace(" ", "");
        max_adult = max_adult.replace(",", " ");
        String max_adults[] = max_adult.split("\\s");

        String price = paperContract.getPrice().replace(" ", "");
        price = price.replace(",", " ");
        String prices[] = price.split("\\s");
        String h_name = paperContract.getH_name();
        String location = paperContract.getLocation();
        Double markup = paperContract.getMarkup();
        String validFrom = paperContract.getValidFrom();
        String validTo = paperContract.getValidTo();
        Hotel hotel;
        Contract contract;

        if(hotelService.getname(h_name)){
            long sa = hotelService.getHotel(h_name);
            System.out.println(sa);
            hotel = hotelService.get(sa);
            contract = new Contract(hotel,paperContract.getRoom_type(),paperContract.getMax_adult(),
                    paperContract.getRoom_count(),paperContract.getPrice(),markup, Date.valueOf(validFrom),Date.valueOf(validTo));
            long id = contractService.save(contract);
        }
        else {
            hotel = new Hotel(h_name,location);
            long ID = hotelService.save(hotel);
            contract = new Contract(hotel,paperContract.getRoom_type(),paperContract.getMax_adult(),
                    paperContract.getRoom_count(),paperContract.getPrice(),markup, Date.valueOf(validFrom),Date.valueOf(validTo));
            long id = contractService.save(contract);
        }
        for(int i = 0; i< roomtypes.length;i++){

            Room rooms = new Room(contract,hotel,Integer.parseInt(max_adults[i]),roomtypes[i],Integer.parseInt(room_counts[i]),Float.parseFloat(prices[i]));
            long Id = roomService.save(rooms);

        }




        return  ResponseEntity.ok().body("New Hotel Added");
    }
}
