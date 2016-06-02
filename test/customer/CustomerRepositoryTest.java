package customer;

import org.apache.commons.lang.Validate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mainsystem.identity.Customer;
import com.mainsystem.identity.aggregate.Adress;
import com.mainsystem.identity.aggregate.Contact;
import com.mainsystem.identity.aggregate.Person;
import com.mainsystem.identity.repository.CarRepository;
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
	
	
	public void insertTest(){
		Customer result = cr.insert(customer);
		if (result == null) System.out.println("Resultado nulo");
		else System.out.println(result.toString());
		
	}
	
	public void removeByIdTest(){
		if(cr.removeById(1)) System.out.println("Removido");
		else System.out.println("ID inexistente");
	}
	
	public void findByIdTest(){
		Customer result = cr.findById(1);
		if(result != null) System.out.println(result.toString());
		else System.out.println("Resultado Nulo");
		
	}
	
	public void updateTest(){
		Customer result = cr.insert(customer);
		result.setFirstName("Updated Name");
		cr.update(result);
	}
	
	public static void main(String[] args) {
		CustomerRepositoryTest crt = new CustomerRepositoryTest();
		//crt.insertTest();
		//crt.findByIdTest();
		//crt.removeByIdTest();
		//crt.updateTest();
	}
}
