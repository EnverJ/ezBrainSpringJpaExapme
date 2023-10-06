package io.ezbrains.springbootjpaexaple;

import io.ezbrains.springbootjpaexaple.models.Employee;
import io.ezbrains.springbootjpaexaple.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;


import java.sql.SQLException;
import java.util.Optional;

@SpringBootApplication
@EnableTransactionManagement
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

    //read only transaction
 //   @Transactional( readOnly = true)
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
        if (employee.isPresent()) {
            System.out.println(employee.get());
            updateEmployee(employee.get());
        }

    }
//@Transactional
//    private void updateEmployeeAndAccessCard() {
//      updateEmployee(e);
//        accessCardRepository.save(a);
//    }

  //  @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional( rollbackOn = SQLException.class)
//     @Transactional( dontRollbackOn = MyAppException.class)
    private void updateEmployee(Employee employee) {
        //GET transaction
        //start transaction
        employee.setName("updated name");
        employeeRepository.save(employee);
        //end transaction
        //handle rollback


    }

}


// Next step
/* Read Documentation
        . Build an application
        . Watch the springboot courses. */