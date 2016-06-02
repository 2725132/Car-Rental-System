package com.mainsystem.rental.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mainsystem.rental.identity.Rental;

import lombok.NoArgsConstructor;

@Repository @NoArgsConstructor
public class RentalRepository {
	@PersistenceContext
	EntityManager em;
	
	public Rental insert(Rental rental){
		em.persist(rental);
		return rental;
	}
	
	public void removeById(int id){
		em.remove(id);
	}
	
	public Rental findById(int id){
		return em.find(Rental.class, id);
	}
	
	public void updateById(Rental rental){
		em.merge(rental.getId());
	}
}
