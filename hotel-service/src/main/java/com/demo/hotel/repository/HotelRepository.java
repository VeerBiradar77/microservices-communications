package com.demo.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hotel.domain.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
