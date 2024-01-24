package com.vikas.hotel.services.impl;

import com.vikas.hotel.entity.Hotel;
import com.vikas.hotel.repositories.HotelRepository;
import com.vikas.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        System.out.println("inside get all hotels");
        String hotelId= UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {

        return hotelRepository.findByHotelId(id);
    }
}
