package io.ezbrains.springbootjpaexaple.repository;

import io.ezbrains.springbootjpaexaple.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
