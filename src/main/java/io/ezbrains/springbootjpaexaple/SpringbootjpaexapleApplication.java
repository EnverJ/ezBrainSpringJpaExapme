package io.ezbrains.springbootjpaexaple;

import io.ezbrains.springbootjpaexaple.models.Employee;
import io.ezbrains.springbootjpaexaple.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SpringbootjpaexapleApplication {

//	@PersistenceUnit
//	private EntityManagerFactory emf;

//	@PersistenceContext
//	private EntityManager entityManager;

	@Autowired
	EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaexapleApplication.class, args);
	}
	@PostConstruct
	public void start() {
//		Employee employee = new Employee();
//		employee.setAge(20);
//		employee.setName("Foo Bar");
//		employee.setSsn("1234");
//		employee.setDob(new Date());
//
//		EntityManager entityManager = enf.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(employee);
//		entityTransaction.commit();
//		entityManager.close();


		Optional<Employee> employee = employeeRepository.findById(1);  // may or may not exist
		if(employee.isPresent()) {
			System.out.println(employee.get());
			updateEmployee(employee.get());
		}

	}

	private void updateEmployee(Employee employee) {
		employee.setName("updated name");
		employeeRepository.save(employee);

	}

}
