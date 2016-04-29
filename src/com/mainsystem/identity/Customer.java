package com.mainsystem.identity;

import java.util.List;

import com.mainsystem.identity.aggregate.Adress;
import com.mainsystem.identity.aggregate.Contact;
import com.mainsystem.identity.aggregate.Person;
import com.mainsystem.rental.identity.Rental;

import lombok.Data;

public class Customer extends Person{
	public List<Rental> historyRental;
	private int level;
}