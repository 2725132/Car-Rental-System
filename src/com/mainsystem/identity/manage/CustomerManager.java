package com.mainsystem.identity.manage;

import com.mainsystem.identity.repository.CustomerRepository;
import com.mainsystem.window.CustomerRegisterWindow;

public class CustomerManager {
	CustomerRepository cr;
	CustomerRegisterWindow crw;
	public CustomerManager(){
		cr = new CustomerRepository();
		crw = new CustomerRegisterWindow();
	}
	public void insert() {
		
		
	}

}
