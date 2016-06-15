package customer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.Customer;
import com.mainsystem.identity.aggregate.Adress;
import com.mainsystem.identity.aggregate.Contact;
import com.mainsystem.identity.repository.CustomerRepository;

public class CustomerRepositoryTest {
	CustomerRepository cr;
	Customer customer;
	ApplicationContext spring;
	
	public CustomerRepositoryTest(){
		ApplicationContext spring = new ClassPathXmlApplicationContext("application-context.xml");
		cr =  spring.getBean(CustomerRepository.class);
		customer = new Customer();
		customer.setFirstName("Felipe");
		customer.setLastName("Gouvea");
		customer.setAdress(new Adress("Jacarei","Rua Nilo Maximo",141));
		customer.setContact(new Contact("3958-8409","99733-1498","95felipeg@gmail.com"));
		customer.setCPF("426.617.808.58");
		
	}
	
	@Test
	public void insertTest(){
		Customer result = cr.insert(customer);
		assertNotNull(result);
		assertNotEquals(0,result.getId());		
	}
	
	@Test
	public void removeByIdTest(){
		assertNotNull(customer);
		Customer result = cr.insert(customer);
		assertNotNull(result);
		assertEquals(true, cr.removeById(result.getId()));
	}
	
	@Test
	public void findByIdTest(){
		assertNotNull(customer);
		Customer result = cr.insert(customer);
		assertNotNull(result);
		assertEquals(result, cr.findById(result.getId()));
		
	}
	
	public void updateTest(){
		Customer result = cr.insert(customer);
		result.setFirstName("Updated Name");
		cr.update(result);
	}
}
