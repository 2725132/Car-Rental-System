package com.mainsystem.identity.repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.Customer;

import lombok.extern.log4j.Log4j;

@Log4j
@Repository
public class CarRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public CarRepository(){	
	}
	
	@PostConstruct
	public void init () {
		//log.info(" ---------------- Criei .. o danado .. !!!");
	}
		
	@Transactional
	public Car insert(Car Car){
		em.persist(Car);
		return Car;
	}
	
	@Transactional
	public Car update(Car Car){
		em.merge(Car);
		return Car;
	}
	
	public Car findById(int id){
		return em.find(Car.class, id);
		
	}
	
	@Transactional
	public boolean removeById(int id){
		Car carToBeDeleted = em.find(Car.class, id);
		if (validate(carToBeDeleted)) {
			em.remove(carToBeDeleted);
			return true;
		} else
			return false;
	}
	
	public boolean validate(Car car) {
		if (car == null) {
			return false;
		} else
			return true;
	}
}
	