package com.project.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findCustomerByUsername(String username);

}
