package car;
import static org.junit.Assert.assertEquals;
import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mainsystem.identity.Car;
import com.mainsystem.identity.repository.CarRepository;

import lombok.extern.log4j.Log4j;
@Log4j
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
		boolean result = cr.removeById(carResult.getId());
		AssertEquals(result, true);
		

	}
	
	@Test
	public void updateTest(){
		cr.update(car);
	}
	
	public void findByIdTest(){
		
		Car result = cr.findById(9);
		System.out.println(result.toString());
	}
	public static void main(String[] args) {
		
		CarRepositoryTest crt = new CarRepositoryTest();
		//crt.insertTest();
		crt.removeTest();
		//crt.updateTest();
		//crt.findByIdTest();
		
		
		
		
	}
}
