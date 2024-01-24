package com.vikas.rating.controller;

import com.vikas.rating.entite.Rating;
import com.vikas.rating.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ratings")
public class RatingController {


    @Autowired
    RatingServices ratingServices;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating ){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(rating));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingServices.getRating());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId( @PathVariable String  userId){
        System.out.println("in side get rating with the help ag user id ");
        return ResponseEntity.ok(ratingServices.getRatingByUserId(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId( @PathVariable String hotelId){
        return ResponseEntity.ok(ratingServices.getRatingByHotelId(hotelId));
    }



}
