package com.demo.hotel.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hotel.domain.Hotel;
import com.demo.hotel.exceptions.ResourceNotFoundException;
import com.demo.hotel.repository.HotelRepository;
import com.demo.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel crate(Hotel hotel) {
		String randomUid = UUID.randomUUID().toString();
		hotel.setId(randomUid);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with given id !!"));
	}

}
