package com.project.employeemanagement.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.employeemanagement.dto.EmployeeRequest;
import com.project.employeemanagement.entity.Employee;
import com.project.employeemanagement.repository.EmployeeRepository;

public class EmployeeServiceTest {

	@Mock
    private EmployeeRepository employeeRepository;	
	@InjectMocks
	private EmployeeService employeeService;
	AutoCloseable autoCloseable;
	EmployeeRequest employeeRequest;
	Employee employee;
	
	@BeforeEach
	void setUp() {
	  autoCloseable=MockitoAnnotations.openMocks(this);
	  employeeRequest=new EmployeeRequest("Rajitha","Qualcomn","rajitha@gmail.com");
	}
	
	@AfterEach
	void tearDown() {
		try {
			autoCloseable.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateEmployee() {
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
		assertThat(employeeService.createEmployee(employeeRequest).getEmail()).isEqualTo(employeeRequest.getEmail());
	}
	
	
	
	
	
	
	
}
