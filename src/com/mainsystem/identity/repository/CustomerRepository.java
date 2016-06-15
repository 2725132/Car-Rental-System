package com.mainsystem.identity.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainsystem.identity.Customer;
import com.mainsystem.identity.exception.CustomerNotFoundException;

@Repository
public class CustomerRepository {
	
	@PersistenceContext
	private EntityManager em;

	public CustomerRepository() {

	}
	
	@PostConstruct
	public void init(){
		System.out.println("Instanciado Customer Repository");
	}

	@Transactional
	public Customer insert(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Transactional
	public Customer update(Customer customer) {
		em.merge(customer);
		return customer;
	}

	public Customer findById(int id) {
		return em.find(Customer.class, id);
	}
	
	public List<Customer> allCustomers(){
		Query q = em.createQuery("select * from Customer c");
		return q.getResultList();
	}

	
	@Transactional
	public boolean removeById(int id) {
		Customer customerToBeDeleted = em.find(Customer.class, id);
		if (validate(customerToBeDeleted)) {
			em.remove(customerToBeDeleted);
			return true;
		} else
			return false;
	}

	public boolean validate(Customer customer) {
		if (customer == null) {
			return false;
		} else
			return true;
	}
}
