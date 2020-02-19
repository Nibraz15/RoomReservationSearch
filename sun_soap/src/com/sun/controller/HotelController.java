package com.sun.controller;

import com.sun.model.Hotel;

import com.sun.service.hotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.jws.WebService;
import java.util.List;

@WebService
public class HotelController {
    private hotelServices hotels = new hotelServices();

    public List getHotels(){
        return hotels.getHotels();
    }



}
