package com.hoteldekho.ratingservice.service.Impl;


import com.hoteldekho.ratingservice.entities.Ratings;
import com.hoteldekho.ratingservice.exception.NoResourceFoundException;
import com.hoteldekho.ratingservice.repository.RatingRepository;
import com.hoteldekho.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
@Autowired
    private RatingRepository ratingRepository;
    @Override
    public Ratings createRating(Ratings rating) {
        return (Ratings) ratingRepository.save(rating);
    }

    @Override
    public List<Ratings> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId).orElseThrow(()-> new NoResourceFoundException("No Ratings available for user id:" + userId));
    }

    @Override
    public List<Ratings> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId).orElseThrow(()-> new NoResourceFoundException("No Ratings available for hotel id:" + hotelId));
    }
}
