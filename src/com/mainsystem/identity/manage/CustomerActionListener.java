package com.mainsystem.identity.manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mainsystem.identity.Customer;
import com.mainsystem.identity.exception.CustomerNotFoundException;
import com.mainsystem.identity.repository.CustomerRepository;
import com.mainsystem.window.CustomerRegisterWindow;

public class CustomerActionListener {
	CustomerRepository cr;

	public CustomerActionListener(CustomerRegisterWindow crw) {
		cr = new CustomerRepository();
	}

	public void insertNewCustomer() {
		Customer customer = new Customer();
		cr.insert(customer);
	}

	public void deleteCustomer(int id) {
		cr.removeById(id);

	}

	public Customer findCustomer(int id) {
		Customer newCustomer = cr.findById(id);
		return newCustomer;
	}

}
