package com.project.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeemanagement.entity.Credentials;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

}
