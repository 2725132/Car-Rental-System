package com.mainsystem.rental.manage;

import com.mainsystem.rental.identity.Rental;
import com.mainsystem.rental.repository.RentalRepository;

public class RentalManager {
	RentalRepository rr;
	
	
	public void init (){
		rr = new RentalRepository();
		//select();
	}
	public void select(int op){
		while(true){
			//System.out.println("Enter the option: 1)Make rental 2)Rental History");
			switch (op){
				case 1:
					makeRental();
					break;
				
			}
		}
	}
	public void makeRental(){
		Rental rental = new Rental();
		//rr.Insert(rental);
	}
}
