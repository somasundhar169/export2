package com.project.employeemanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsRequest {
	private String username;
	private String password;
	private String roles;
}
