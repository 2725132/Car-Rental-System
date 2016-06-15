package rental;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.Customer;
import com.mainsystem.identity.Employee;
import com.mainsystem.rental.manage.RentalManager;

public class RentalManagerTest {
	
	@Autowired
	RentalManager rm;
	Car car;
	Customer customer;
	Employee employee;
	
	public RentalManagerTest(){
		rm = new RentalManager();
		car = new Car();
		car.setName("A");
		car.setPlate("B");
		car.setModel("C");
		car.setBrand("D");
		car.setId(99);
		
		customer = new Customer();
		customer.setAdress(null);
		customer.setContact(null);
		customer.setCPF("123");
		customer.setFirstName("Felipe");
		customer.setLastName("Gouvea");
		customer.setId(99);
		
		employee = new Employee();				
		employee.setAdress(null);
		employee.setContact(null);
		employee.setCPF("123");
		employee.setFirstName("Felipe");
		employee.setLastName("Gouvea");
		employee.setId(99);
	}
	
	@Test
	public void makeRentalTest(){
		if(rm == null) System.out.println("nulo");
		rm.makeRental(car, customer, employee);
	}

}
