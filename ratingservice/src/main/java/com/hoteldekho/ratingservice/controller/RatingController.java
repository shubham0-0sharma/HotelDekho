package com.hoteldekho.ratingservice.controller;

import com.hoteldekho.ratingservice.entities.Ratings;
import com.hoteldekho.ratingservice.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ratings")
public class RatingController {
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating){
        return  new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId){
        return  new ResponseEntity<>(ratingService.getRatingsByUserId(userId), HttpStatus.OK);
    } @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId){
        return  new ResponseEntity<>(ratingService.getRatingsByHotelId(hotelId), HttpStatus.OK);
    } @GetMapping
    public ResponseEntity<List<Ratings>> getRatings(){
        return  new ResponseEntity<>(ratingService.getRatings(), HttpStatus.OK);
    }
}
