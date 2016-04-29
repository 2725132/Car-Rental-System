package com.mainsystem.identity.aggregate;

import lombok.Data;

@Data
public abstract class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String CPF;
	private Adress adress;
	private Contact contact;
}
