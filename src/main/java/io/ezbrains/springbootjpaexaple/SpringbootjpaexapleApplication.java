package io.ezbrains.springbootjpaexaple;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringbootjpaexapleApplication {

//	@PersistenceUnit
//	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager entityManager;


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


		Employee employee = entityManager.find(Employee.class,1);
		System.out.println(employee);
	}

}
