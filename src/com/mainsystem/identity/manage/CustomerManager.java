package com.mainsystem.identity.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainsystem.identity.Customer;
import com.mainsystem.identity.aggregate.Adress;
import com.mainsystem.identity.aggregate.Contact;
import com.mainsystem.identity.repository.CustomerRepository;
import com.mainsystem.window.CustomerRegisterWindow;

import lombok.Data;

@Data
@Service
public class CustomerManager {

	@Autowired
	private CustomerRepository cr;

	public CustomerRegisterWindow crw;

	public CustomerManager() {
	}

	public void addWindow(CustomerRegisterWindow crw) {
		this.crw = crw;
	}

	public void setVisible(boolean b) {
		crw.setVisible(true);
	}

	public boolean validate(String data) {
		if (!"".equals(data))
			return true;
		return false;
	}

	public boolean validateCustomer(Customer c) {
		if (!validate(c.getCPF()))
			if (!validate(c.getFirstName()))
				return false;
		if (!validate(c.getLastName()))
			return false;
		return true;

	}

	public Customer formToCustomer() {
		Customer customer = new Customer();
		customer.setFirstName(crw.getTxtFirstName().getText());
		customer.setLastName(crw.getTxtLastName().getText());
		customer.setCPF(crw.getTxtCPF().getText());
		int number = Integer.parseInt(crw.getTxtNum().getText());
		customer.setAdress(new Adress(crw.getTxtCity().getText(),
							crw.getTxtStreet().getText(), number));
		
		customer.setContact(new Contact(crw.getTxtTel().getText(),
						crw.getTxtCel().getText(), crw.getTxtEmail().getText()));

		return customer;
	}

	public void insertNewCustomer() {
		Customer newCustomer = formToCustomer();

		cr.insert(newCustomer);

	}

	public boolean deleteCustomer(int id) {
		System.out.println("REMOVEU");
		if (cr.removeById(id))
			return true;
		else
			return false;

	}

	public Customer findCustomer(int id) {
		Customer newCustomer = cr.findById(id);
		return newCustomer;
	}

	
	public void printAll(){
		List<Customer> list = cr.allCustomers();
		for(Customer c: list){
			System.out.println(c.toString());
		}
	}
	
	public List<Customer> findAll(){
		return cr.allCustomers();
	}
}
