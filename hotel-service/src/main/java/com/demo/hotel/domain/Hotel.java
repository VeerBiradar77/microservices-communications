package com.demo.hotel.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_hotels")
public class Hotel {
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "Name", length = 20)
	private String name;
	
	@Column(name = "Location")
	private String location;
	
	@Column(name = "About")
	private String about;
	

}
