package com.vikas.hotel.services;

import com.vikas.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    // create

    Hotel create(Hotel hotel);

    // getall

    List<Hotel> getAll();

    // get single

    Hotel get(String id);

}
