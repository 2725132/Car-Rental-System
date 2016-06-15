package com.mainsystem.identity.manage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.repository.CarRepository;

@Service
public class CarActionListener {
	
	@Autowired
	private CarRepository cr;
	
	public CarActionListener() {
		cr = new CarRepository();
	}

	public void insertNewCar() {
		Car Car = new Car();
		cr.insert(Car);
	}

	public void deleteCar(int id) {
		cr.removeById(id);

	}

	public Car findCar(int id) {
		Car newCar = cr.findById(id);
		return newCar;
	}

}
