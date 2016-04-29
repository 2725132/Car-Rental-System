package com.mainsystem.identity.exception;

public class CustomerNotFoundException extends Exception {
	public void printError(){
		System.out.println("Customer not found!!!!");
	}
}
