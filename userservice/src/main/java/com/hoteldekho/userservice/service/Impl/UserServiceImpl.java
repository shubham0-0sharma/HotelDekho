package com.hoteldekho.userservice.service.Impl;

import com.hoteldekho.userservice.entities.Hotel;
import com.hoteldekho.userservice.entities.Rating;
import com.hoteldekho.userservice.entities.User;
import com.hoteldekho.userservice.exception.NoResourceFoundException;
import com.hoteldekho.userservice.repository.UserRepository;
import com.hoteldekho.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final String CREATE_RATING_URL = "http://localhost:8084/ratings";
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    public Rating createRating(Rating rating) {
        // creating header with entity
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Rating> entity = new HttpEntity<>(rating, header);
        ResponseEntity<Rating> response = restTemplate.exchange(CREATE_RATING_URL, HttpMethod.POST, entity,
                Rating.class);
        return response.getBody();

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoResourceFoundException("User with given id not found on Server: " + userId));

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
                Rating[].class);

        assert ratingsOfUser != null;
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().peek(rating -> {

            ResponseEntity<Hotel> forEntity = restTemplate
                    .getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
            rating.setHotel(hotel);

        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;

    }
}
