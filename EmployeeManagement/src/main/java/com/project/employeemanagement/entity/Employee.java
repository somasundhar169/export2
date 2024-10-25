package com.project.employeemanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Employee {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Long id;
	private String name;
	private String company;
	private String email;
}
