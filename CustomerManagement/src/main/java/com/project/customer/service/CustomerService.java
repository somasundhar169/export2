package com.project.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.customer.entity.Customer;
import com.project.customer.enums.Roles;
import com.project.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	public Customer addCustomer(Customer customer) {
		List<Roles> role=new ArrayList<>();
		role.add(Roles.CUSTOMER);
		customer.setRoles(role);	
		customer.setPassword(encoder.encode(customer.getPassword()));
		return customerRepo.save(customer);
	}

	public Customer getCustomerById(Long id) {
		return customerRepo.findById(id).get();
	}
	

}
