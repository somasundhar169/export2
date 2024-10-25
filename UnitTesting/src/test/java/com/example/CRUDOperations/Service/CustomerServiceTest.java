package com.example.CRUDOperations.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.CRUDOperations.Entity.Customer;
import com.example.CRUDOperations.Exception.CustomerNotFoundException;
import com.example.CRUDOperations.Repository.CustomerRepository;


public class CustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerService customerService;
	
	Customer customer;
	AutoCloseable autoCloseable;
	
	@BeforeEach
	void setUp() {
		autoCloseable=MockitoAnnotations.openMocks(this);
		customer=new Customer(1,"ravi","ravi@gmail.com");
		customerService=new CustomerService(customerRepository);
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
	void testAddCustomer() {
		when(customerRepository.save(any(Customer.class))).thenReturn(customer);
		assertThat(customerService.addCustomer(customer).getId()).isEqualTo(customer.getId());
	}
	
    @Test
	void testFindById() {
	when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
	 assertThat(customerService.findById(customer.getId()).getEmail()).isEqualTo(customer.getEmail());
	}
    
    @Test
	void testFindByIdException() {
	when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
	assertThrows(Exception.class,()->{customerService.findById(2);});
	}
    
    @Test
    void testDeleteCustomer() {
    	doNothing().when(customerRepository).deleteById(anyInt());
    	
    }
    
    
}
