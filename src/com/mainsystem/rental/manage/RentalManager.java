package com.mainsystem.rental.manage;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.Customer;
import com.mainsystem.identity.Employee;
import com.mainsystem.rental.identity.Rental;
import com.mainsystem.rental.identity.aggregate.DataRange;
import com.mainsystem.rental.repository.RentalRepository;

public class RentalManager {
	RentalRepository rr;
	
	@PostConstruct
	public void init (){
		
	}
	
	public void makeRental(Car car, Customer customer, Employee employee){
		Rental rental = new Rental(car.getId(), customer.getId(), employee.getId(), new DataRange());
		rr.insert(rental);
	}
	
}
