package com.sun.controller;

import com.sun.service.contractServices;
import com.sun.service.hotelServices;
import com.sun.service.RoomServices;



import javax.jws.WebService;

import java.util.List;
@WebService
public class ContractController  {
    private contractServices contract = new contractServices();
    private hotelServices hotels = new hotelServices();
    private RoomServices rooms = new RoomServices();

    public List getContracts(){
        return contract.getContracts();
    }

    public String addContract(String h_name, String location, String room_type,String max_adult, String room_count, String price , float markup, String validFrom,String validTo){

        String room_type1 = room_type.replace(" ", "");
        String room_type2 = room_type1.replace(",", " ");
        String room_types[] = room_type2.split("\\s");

        String room_count1 = room_count.replace(" ", "");
        String room_count2 = room_count1.replace(",", " ");
        String room_counts[] = room_count2.split("\\s");

        String max_adult1 = max_adult.replace(" ", "");
        String max_adult2 = max_adult1.replace(",", " ");
        String max_adults[] = max_adult2.split("\\s");

        String price1 = price.replace(" ", "");
        String price2 = price1.replace(",", " ");
        String prices[] = price2.split("\\s");
        long h_id;
        long c_id;
        if(hotels.checkHotel(h_name)){
            h_id = hotels.getHotelId(h_name);
            c_id = contract.addContract(h_id,room_type,max_adult,room_count,price,markup,validFrom,validTo);
        }
        else{
            h_id = hotels.addHotel(h_name,location);
            c_id = contract.addContract(h_id,room_type,max_adult,room_count,price,markup,validFrom,validTo);
        }
        for(int i=0;i< room_types.length;i++){
            rooms.addRoom(c_id,h_id,Integer.parseInt(max_adults[i]),room_types[i],Integer.parseInt(room_counts[i]),Float.parseFloat(prices[i]));
        }


        return "True";
    }
}
