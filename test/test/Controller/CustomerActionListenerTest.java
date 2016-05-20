package test.Controller;

import com.mainsystem.identity.manage.CustomerActionListener;

import junit.framework.Assert;

public class CustomerActionListenerTest {
	public void InsertNewCustomer(){
		CustomerActionListener cal = new CustomerActionListener();
		cal.insertNewCustomer();
		
	}
	
	public static void main(String[] args) {
		CustomerActionListenerTest calt = new CustomerActionListenerTest();
		calt.InsertNewCustomer();
	}
}
