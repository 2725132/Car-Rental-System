package com.mainsystem.identity.aggregate;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data @Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Person {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String CPF;
	
	@Embedded
	private Adress adress;
	
	@Embedded
	private Contact contact;
}
