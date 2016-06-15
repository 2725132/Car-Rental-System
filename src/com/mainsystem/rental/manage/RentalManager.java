package com.mainsystem.rental.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.Customer;
import com.mainsystem.identity.Employee;
import com.mainsystem.rental.identity.Rental;
import com.mainsystem.rental.identity.aggregate.DataRange;
import com.mainsystem.rental.repository.RentalRepository;

import lombok.Data;
import rental.RentalManagerTest;

@Data
@Controller
@Qualifier("rentalManager")
public class RentalManager {
	
	@Autowired
	private RentalRepository rr;

	private Rental rental;
	
	public Rental makeRental(Car car, Customer customer, Employee employee){
		rental = new Rental();
		rental.setCarId(car.getId());
		rental.setCustomerId(customer.getId());
		rental.setEmployeeId(employee.getId());
		rental.setData(new DataRange());
		
		return rr.insert(rental);
		
	}
	
}
