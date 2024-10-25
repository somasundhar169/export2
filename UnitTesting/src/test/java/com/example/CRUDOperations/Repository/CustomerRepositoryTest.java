package com.example.CRUDOperations.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.CRUDOperations.Entity.Customer;

@DataJpaTest
class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	Customer customer;
	
	@BeforeEach
	void setUp() {
		customer =new Customer(1,"rajini","rajini@gmail.com");
		customerRepository.save(customer);
	}
	
	@AfterEach
	void tearDown() {
		customer=null;
	}
	
	
	@Test
	void testSave() {
	Customer newCustomer=customerRepository.save(customer);
	assertThat(newCustomer.getId()).isEqualTo(customer.getId());
//	assertThat(newCustomer.getId()).isNotNull();
	}
	
	
	@Test
	void testFindById() {
		assertThat(customerRepository.findById(customer.getId()).get()).isNotNull();
		assertThat(customerRepository.findById(customer.getId()).get().getId()).isEqualTo(customer.getId());
	}
	
	@Test
	void testFindAll() {
		Customer newCustomer=customerRepository.save(new Customer(2,"Raja","raja@gmail.com"));
		assertThat(customerRepository.findAll().get(1).getEmail()).isEqualTo(newCustomer.getEmail());
	}
	
	@Test
	void testUpdateCustomer() {
		Customer newCustomer=customerRepository.save(new Customer(1,"Raj","raj@gmail.com"));
		assertThat(customerRepository.findById(1).get().getEmail()).isNotEqualTo("rajini@gmail.com");
	}
	
	@Test
	void testDeleteCustomer() {
		customerRepository.save(new Customer(2,"Raj","raj@gmail.com"));
		customerRepository.deleteById(2);
		Optional<Customer> customer=customerRepository.findById(2);
		assertThat(customer).isEmpty();
	}
	
	@Test
	void testFindByName() {
		Customer newCustomer=customerRepository.save(new Customer(2,"Raj","raj@gmail.com"));
		List<Customer> customers=customerRepository.findByName(newCustomer.getName());
		assertThat(customers.get(0).getId()).isEqualTo(newCustomer.getId());
	}
	
}
