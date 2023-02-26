package com.hoteldekho.hotelservice.controller;

import com.hoteldekho.hotelservice.entities.Hotel;
import com.hoteldekho.hotelservice.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }
    @GetMapping ("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        return new ResponseEntity<>(hotelService.getHotel(hotelId), HttpStatus.OK);
    }@GetMapping("/all")
    public ResponseEntity<List<Hotel>> getHotels(){
        return new ResponseEntity<>(hotelService.getHotels(), HttpStatus.OK);
    }

}
