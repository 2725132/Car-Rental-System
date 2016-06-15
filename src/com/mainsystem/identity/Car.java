package com.mainsystem.identity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @Entity
public class Car {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	private String name;
	
	private String model;
	
	private String brand;
	
	private String plate;
	
	private byte[] image;
}
