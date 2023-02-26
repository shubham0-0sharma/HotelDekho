package com.hoteldekho.userservice.service;

import com.hoteldekho.userservice.entities.Rating;
import com.hoteldekho.userservice.entities.User;

import java.util.List;

public interface UserService {
User createUser(User user);
User getUser(String userId);
List<User> getUsers();
    Rating createRating(Rating rating);
}
