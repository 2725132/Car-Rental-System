package com.mainsystem.identity.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.repository.CarRepository;
import com.mainsystem.window.CarRegisterWindow;
import lombok.Data;

@Service
@Data
public class CarManager {

	@Autowired
	private CarRepository cr;

	private CarRegisterWindow crw;

	public void addWindow(CarRegisterWindow crw) {
		this.crw = crw;
	}

	public void setVisible(boolean b){
		crw.setVisible(true);
	}

	public boolean validate(String data) {
		if (!"".equals(data))
			return true;
		return false;
	}

	public boolean validateCar(Car c) {
		return true;
	}

	public Car formToCar() {
		Car Car = new Car();
		
		
		return Car;
	}

	public void insertNewCar() {
		Car newCar = formToCar();
		cr.insert(newCar);

	}

	public boolean deleteCar(int id) {
		System.out.println("REMOVEU");
		if (cr.removeById(id))
			return true;
		else
			return false;

	}

	public Car findCar(int id) {
		Car newCar = cr.findById(id);
		return newCar;
	}
}
