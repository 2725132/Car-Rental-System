package com.mainsystem.identity;

import javax.persistence.Entity;

import com.mainsystem.identity.aggregate.Person;

import lombok.Data;

@Data @Entity
public class Employee extends Person{
	private int numberOfRentals;
}
