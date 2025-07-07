package com.demo.rating.service;

import java.util.List;

import com.demo.rating.domain.Rating;

public interface RatingService {
	
	Rating create(Rating rating);
	
	//get all ratings
	List<Rating>getRatings();
	
	//get all by userId
	List<Rating>getRatingByUserId(String userId);
	
	//get all by hoteId
	List<Rating>getRatingByHotelId(String hotelId);
	

}
