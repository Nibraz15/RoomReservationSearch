package com.sun.controller;

import com.sun.model.Hotel;
import com.sun.model.PaperContract;
import com.sun.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    public ResponseEntity<List<Hotel>> list(){
       List<Hotel> list = hotelService.list();
       return ResponseEntity.ok().body(list);
    }

}
