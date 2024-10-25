package com.project.employeemanagement.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.employeemanagement.entity.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	Employee employee;
	
@BeforeEach
void setUp(){
employee=new Employee(1L,"Sundhar","Hexaware","sundhar@gmail.com");
employeeRepository.save(employee);
}

@AfterEach
void tearDown() {
	employee=null;
	employeeRepository.deleteAll();
}

@Test
public void testFindAll() {
 Employee employee2=new Employee(2L,"Anandhi","Amazon","anandhi@gmail.com");	
 employeeRepository.save(employee2);
 assertThat(employeeRepository.findAll().size()).isEqualTo(2);
}

@Test
public void testUpdateCustomer() {
	Employee employee2=new Employee(1L,"Anandhi","Hexaware","anandhi@gmail.com");
	Employee employeeUpdated=employeeRepository.save(employee2);
	assertThat(employeeRepository.findAll().size()).isEqualTo(1);
	assertThat(employeeRepository.findById(1L).get().getEmail()).isEqualTo(employeeUpdated.getEmail());
}

@Test
public void testDeleteCustomer() {
employeeRepository.deleteById(1L);
Optional<Employee> foundEmployee=employeeRepository.findById(1L);
assertThat(foundEmployee.isPresent()).isFalse();
}
	
}
