package com.mainsystem.window.exception;

import lombok.Data;

@Data
public class NullImageException extends Exception {
	public void printError(){
		System.out.println("Null image!!");
	}
}
