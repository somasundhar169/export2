package com.project.employeemanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsResponse {
	private Long id;
	private String username;
	private String password;
	private String roles;
}
