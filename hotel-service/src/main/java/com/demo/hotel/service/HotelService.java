package com.demo.hotel.service;

import java.util.List;

import com.demo.hotel.domain.Hotel;

public interface HotelService {
	
	Hotel crate(Hotel hotel);
	
	List<Hotel>getAll();
	
	Hotel get(String id);

}
