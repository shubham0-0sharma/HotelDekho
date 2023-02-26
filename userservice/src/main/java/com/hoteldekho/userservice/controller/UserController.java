package com.hoteldekho.userservice.controller;

import com.hoteldekho.userservice.entities.Rating;
import com.hoteldekho.userservice.entities.User;
import com.hoteldekho.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
@PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return new ResponseEntity<> ( userService.createUser(user), HttpStatus.CREATED);

    }
@PostMapping("/rating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {

        return new ResponseEntity<> ( userService.createRating(rating), HttpStatus.CREATED);

    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser (@PathVariable String userId){
    return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
    return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);

    }
}
