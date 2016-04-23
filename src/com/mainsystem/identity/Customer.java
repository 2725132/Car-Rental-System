package com.mainsystem.identity;

import java.util.List;

import com.mainsystem.identity.aggregate.Adress;
import com.mainsystem.identity.aggregate.Contact;
import com.mainsystem.identity.aggregate.Level;
import com.mainsystem.identity.aggregate.Person;
import com.mainsystem.rental.identity.Rental;

public class Customer extends Person{
	public List<Rental> historyRental;
	private Level level;
}