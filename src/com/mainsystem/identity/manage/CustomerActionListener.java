package com.mainsystem.identity.manage;

import com.mainsystem.identity.Customer;
import com.mainsystem.identity.repository.CustomerRepository;
import com.mainsystem.window.CustomerRegisterWindow;

public class CustomerActionListener {
	CustomerRepository cr;
	CustomerRegisterWindow crw;

	public CustomerActionListener() {
		init(this);
	}



	public void init(CustomerActionListener cal){
		crw = new CustomerRegisterWindow();
	}
	
	public void setVisible(boolean b){
		crw.setVisible(b);
	}
	
	public boolean validate(String data){
		if(!"".equals(data)) return true;
		return false;
	}
	
	public Customer formToCustomer(){
		Customer c = new Customer();
		if(validate(crw.getTxtFirstName().getText())){
			c.setFirstName(crw.getTxtFirstName().getText());
		}
		
		return c;
	}
	public void insertNewCustomer() {
		System.out.println("INSERIU");
		
		Customer customer = new Customer();
		customer.setCPF("123");
		//customer.setFirstName(crw.);
		//customer.setLastName(crw.getTxtLastName().getText());
		//customer.setCPF(crw.getTxtCPF().getText());
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
