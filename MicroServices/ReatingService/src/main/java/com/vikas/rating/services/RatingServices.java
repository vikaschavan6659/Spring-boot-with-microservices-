package com.vikas.rating.services;

import com.vikas.rating.entite.Rating;

import java.util.List;

public interface RatingServices {

    // create
    Rating create (Rating rating);

    //get all rating
    List<Rating> getRating();

    //get all by userid
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
