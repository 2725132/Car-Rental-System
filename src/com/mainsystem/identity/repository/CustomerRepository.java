package com.mainsystem.identity.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

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

	@Transactional
	public boolean removeById(int id) {
		Customer customerToBeDeleted = em.find(Customer.class, id);
		try {
			validate(customerToBeDeleted);
			em.remove(customerToBeDeleted);
		} catch (CustomerNotFoundException e) {
			e.printError();
		}

		return true;
	}

	public boolean validate(Customer customer) throws CustomerNotFoundException {
		if (customer.getId() == 0) {
			throw new CustomerNotFoundException();
		} else
			return true;
	}
}
