package com.project.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.customer.entity.Customer;
import com.project.customer.enums.Roles;
import com.project.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	//@PreAuthorize("hasRole('CUSTOMER')")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole(Roles.CUSTOMER)")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/info")
	public String getCustomer() {
		return "Customer-1,phon";
	}
}
