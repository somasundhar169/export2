package com.example.CRUDOperations.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.example.CRUDOperations.Entity.Customer;
import com.example.CRUDOperations.Exception.CustomerNotFoundException;
import com.example.CRUDOperations.Repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {
	
	private CustomerRepository repo;

	@Autowired
	public CustomerService(CustomerRepository repo) {
		super();
		this.repo = repo;
	}

	public Customer addCustomer(Customer customer) {
		log.info("Entered CustomerService - Save()");
				return repo.save(customer);
				
	}

	public Customer findById(Integer id) {
		log.info("Entered CustomerService - FindById()");
		
		return repo.findById(id).orElseThrow(()->new CustomerNotFoundException("CustomerNotFound"));
	}

	public List<Customer> findByName(String name) {
		log.info("Entered CustomerService - findByName()");
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	public List<Customer> findAll() {
		log.info("Entered CustomerService - findAll()");
		return repo.findAll();
	}

	public Customer updateCustomer(Customer customer) {
		log.info("Entered CustomerService - Update Method");
		return repo.save(customer);
	}

	public String deleteCustomer(Integer id) {
		log.info("Entered CustomerService - delete()");
		repo.findById(id).orElseThrow(()->new CustomerNotFoundException("CustomerNotFound"));
		repo.deleteById(id);
		return "Customer Deleted Successfully";
	}
	
	

}
