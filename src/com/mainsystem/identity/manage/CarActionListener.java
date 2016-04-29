package com.mainsystem.identity.manage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.repository.CarRepository;

public class CarActionListener {
	CarRepository cr;

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
