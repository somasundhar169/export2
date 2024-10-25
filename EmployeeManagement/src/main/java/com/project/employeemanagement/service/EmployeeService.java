package com.project.employeemanagement.service;

import java.util.List;

import org.springframework.http.HttpStatusCode;

import com.project.employeemanagement.dto.EmployeeRequest;
import com.project.employeemanagement.dto.EmployeeResponse;

public interface EmployeeService {

	EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

	EmployeeResponse getEmployeeById(Long id);

	List<EmployeeResponse> findAllEmployees();

	EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

	String deleteEmployee(Long id);

	

	

}
