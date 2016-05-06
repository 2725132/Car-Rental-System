package com.mainsystem.identity.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mainsystem.identity.Customer;
import com.mainsystem.identity.exception.CustomerNotFoundException;
import com.mainsystem.identity.repository.CustomerRepository;
import com.mainsystem.window.CustomerRegisterWindow;

public class CustomerActionListener {
	CustomerRepository cr;
	CustomerRegisterWindow crw;
	
	public CustomerActionListener(CustomerRegisterWindow crw) {
		cr = new CustomerRepository();
	}

	
	public void init(){
		
	}
	
	public void insertNewCustomer() {
		System.out.println("INSERIU");
		
		Customer customer = new Customer();
		customer.setFirstName(crw.getTxtName().getText());
		customer.setLastName(crw.getTxtLastName().getText());
		customer.setCPF(crw.getTxtCPF().getText());
		System.out.println(customer.toString());
		//cr.insert(customer);
	}

	public void deleteCustomer(int id) {
		System.out.println("REMOVEU");
		
		cr.removeById(id);

	}

	public Customer findCustomer(int id) {
		System.out.println("ACHOU");
		
		Customer newCustomer = cr.findById(id);
		return newCustomer;
	}

}
