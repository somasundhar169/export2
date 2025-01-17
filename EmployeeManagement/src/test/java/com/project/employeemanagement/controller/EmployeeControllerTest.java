package com.project.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.project.employeemanagement.service.EmployeeService;

@WebMvcTest
public class EmployeeControllerTest {

	@MockBean
	private EmployeeService employeeService;
	
	private EmployeeController employeeController;
	
	@Autowired
	private MockMvc mockMvc;
	
	
}
