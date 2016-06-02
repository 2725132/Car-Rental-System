package com.mainsystem.rental.identity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.Customer;
import com.mainsystem.identity.Employee;
import com.mainsystem.rental.identity.aggregate.DataRange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @Entity
public class Rental {
	public Rental(int carId, int customerId, int employeeId, DataRange dataRange) {
		this.carId = carId;
		this.customerId = customerId;
		this.employeeId = employeeId;
	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int carId;
	
	private int customerId;
	
	private int employeeId;
	
	@Embedded
	private DataRange data;
}
