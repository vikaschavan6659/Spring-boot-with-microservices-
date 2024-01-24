package com.vikas.hotel.repositories;

import com.vikas.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel , String> {
    Hotel findByHotelId(String id);
}
