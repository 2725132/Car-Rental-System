package com.mainsystem;

import com.mainsystem.identity.manage.CustomerManager;
import com.mainsystem.rental.manage.RentalManager;

public class SystemManager {
	private RentalManager rm;
	private CustomerManager cm;
	
	public SystemManager(){
		rm = new RentalManager();
	}
	
	public void rentalFunctions(){
		
	}
	

}
