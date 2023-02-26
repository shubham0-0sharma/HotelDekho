package com.hoteldekho.ratingservice.repository;

import com.hoteldekho.ratingservice.entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends MongoRepository<Ratings, String> {
    Optional<List<Ratings>>findByUserId(String userId);
    Optional<List<Ratings>>findByHotelId(String hotelId);
}
