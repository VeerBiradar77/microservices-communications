package com.demo.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rating.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {
	
	//custom methods
	List<Rating>findByUserId(String userId);
	
	List<Rating>findByHotelId(String hotelId);

}
