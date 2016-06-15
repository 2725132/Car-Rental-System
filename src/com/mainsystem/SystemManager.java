package com.mainsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mainsystem.identity.manage.CarManager;
import com.mainsystem.identity.manage.CustomerManager;
import com.mainsystem.rental.manage.RentalManager;
import com.mainsystem.window.CarRegisterWindow;
import com.mainsystem.window.CustomerRegisterWindow;
import com.mainsystem.window.MainWindow;

import lombok.Data;	
@Component @Data
public class SystemManager {
	
	private CustomerRegisterWindow customerRegisterWindow;
	private CarRegisterWindow carRegisterWindow;

	private MainWindow mw;
	
	@Autowired
	private CustomerManager customerManager;
	
	@Autowired
	private CarManager carManager;
	
	
	
	public void init(){
		customerRegisterWindow = new CustomerRegisterWindow();
		carRegisterWindow = new CarRegisterWindow();
		mw = new MainWindow();
		
		//Controller to send command from MainWindow to view managed by CustomerManager/Car Manager
		mw.addControler(carManager);
		mw.addController(customerManager);

		//Customer View-Controller call 
		customerManager.addWindow(customerRegisterWindow);
		customerRegisterWindow.addController(customerManager);		
	
		//Car View-Controller call 
		carRegisterWindow.addController(carManager);		
		carManager.addWindow(carRegisterWindow);
		
		mw.setVisible(true);
	}
	
	public static void main(String[] args) {
		//Rise Spring context
		ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("application-context.xml");
		
		//Get bean managed by spring
		SystemManager mainframe = spring.getBean("systemManager", SystemManager.class);
		mainframe.init();
	}

}
