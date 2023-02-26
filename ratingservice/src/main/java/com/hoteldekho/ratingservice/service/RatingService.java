package com.hoteldekho.ratingservice.service;

import com.hoteldekho.ratingservice.entities.Ratings;

import java.util.List;

public interface RatingService {
    Ratings createRating(Ratings rating);
    List<Ratings> getRatings();
    List<Ratings> getRatingsByUserId(String userId);
    List<Ratings> getRatingsByHotelId(String hotelId);


}
