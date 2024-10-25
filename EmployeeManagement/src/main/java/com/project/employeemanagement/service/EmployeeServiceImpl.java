package com.project.employeemanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.employeemanagement.dto.EmployeeRequest;
import com.project.employeemanagement.dto.EmployeeResponse;
import com.project.employeemanagement.entity.Employee;
import com.project.employeemanagement.exception.EmployeeNotFoundException;
import com.project.employeemanagement.repository.EmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	private ObjectMapper objectMapper;
	
	public Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest) {
		return objectMapper.convertValue(employeeRequest, Employee.class);
	}
	
	public EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee) {
		return objectMapper.convertValue(employee, EmployeeResponse.class);
	}
	
	@Override
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
		Employee employee=mapEmployeeRequestToEmployee(employeeRequest);
		Employee employeeResult=employeeRepository.save(employee);
		return mapEmployeeToEmployeeResponse(employeeResult);
	}

	@Override
	public EmployeeResponse getEmployeeById(Long id) {
		Employee employeeResult=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with Id :"+id+" Not Found."));
		return mapEmployeeToEmployeeResponse(employeeResult);
	}

	@Override
	public List<EmployeeResponse> findAllEmployees() {
		 List<Employee> employeeList=employeeRepository.findAll();
		return employeeList.stream().map(this::mapEmployeeToEmployeeResponse).collect(Collectors.toList());
	}

	@Override
	public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {
		Employee employee=mapEmployeeRequestToEmployee(employeeRequest);
		Employee employeeResult=employeeRepository.save(employee);
		return mapEmployeeToEmployeeResponse(employeeResult);	
	}

	@Override
	public String deleteEmployee(Long id) {
		employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with Id :"+id+" Not Found."));
		employeeRepository.deleteById(id);
		return "Successfully Deleted";
	}

}
