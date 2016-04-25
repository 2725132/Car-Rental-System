package com.mainsystem.identity.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainsystem.identity.Car;
@Repository
public class CarRepository {
	@PersistenceContext
	private EntityManager em;
	
	public CarRepository(){
		
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
	
	public boolean removeById(int id){
		Car Car = em.find(Car.class, id);
		em.remove(Car);
		return true;
	}
}
