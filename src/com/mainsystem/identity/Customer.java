package com.mainsystem.identity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.data.annotation.Persistent;

import com.mainsystem.identity.aggregate.Adress;
import com.mainsystem.identity.aggregate.Contact;
import com.mainsystem.identity.aggregate.Person;
import com.mainsystem.rental.identity.Rental;

import lombok.Data;

@Entity
public class Customer extends Person{
	@Transient
	private List<Rental> historyRental;
	private int level;
	
}