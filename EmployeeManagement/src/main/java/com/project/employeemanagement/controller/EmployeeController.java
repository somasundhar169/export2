package com.project.employeemanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemanagement.dto.EmployeeRequest;
import com.project.employeemanagement.dto.EmployeeResponse;
import com.project.employeemanagement.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;

	@PostMapping("/")
public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest){
	return new ResponseEntity<EmployeeResponse>(employeeService.createEmployee(employeeRequest),HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id){
	return new ResponseEntity<EmployeeResponse>(employeeService.getEmployeeById(id),HttpStatus.OK);
}
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeResponse>> findAllEmployees(){
		return new ResponseEntity<List<EmployeeResponse>>(employeeService.findAllEmployees(),HttpStatus.OK);
	}
	
	@PatchMapping("/")
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeRequest employeeRequest){
		return new ResponseEntity<EmployeeResponse>(employeeService.updateEmployee(employeeRequest),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		return new ResponseEntity<String>(employeeService.deleteEmployee(id),HttpStatus.OK);
	}
	
	
}
