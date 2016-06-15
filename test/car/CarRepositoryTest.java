package car;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.repository.CarRepository;

import lombok.extern.log4j.Log4j;
@Log4j //@RunWith(JUnit4ClassRunner.class)
public class CarRepositoryTest {
	
	static CarRepository cr;
	private Car car = new Car();
	public CarRepositoryTest(){
		car.setBrand("TestBrand");
		car.setModel("Conversível");
		car.setName("C-180");
		car.setPlate("DEM-6666");
		
		ApplicationContext spring = new ClassPathXmlApplicationContext("application-context.xml");
		cr =  spring.getBean("carRepository", CarRepository.class);
	}
	
	
	@Test
	public void insertTest(){
		Car result = cr.insert(car);
		
		System.out.println(result.toString());
	}
	
	@Test
	public void removeTest(){
		Car carResult = cr.insert(car);
		assertNotNull(car);
		
		boolean result = cr.removeById(carResult.getId());
		assertEquals(true, result);
		

	}
	
	@Test
	public void updateTest(){
		cr.update(car);
	}
	
	@Test
	public void findByIdTest(){
		Car carResult = cr.insert(car);
		assertNotNull(car);
		
		Car result = cr.findById(carResult.getId());
		assertNotNull(result);
		
		assertEquals(carResult.getId(), result.getId());
	}

}
