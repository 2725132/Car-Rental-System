package com.mainsystem.helper;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import lombok.Data;

public class ApplicationContextProvider {
	private static ApplicationContext spring;
	
	public ApplicationContextProvider(){
		spring = new ClassPathXmlApplicationContext("application-context.xml");
	}
	
	public static ApplicationContext getApplicationContext(){
		return spring;
	}
	
	
}
