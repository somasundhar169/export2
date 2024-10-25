package com.project.employeemanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeResponse {
	private Long id;
	private String name;
	private String company;
	private String email;
}
