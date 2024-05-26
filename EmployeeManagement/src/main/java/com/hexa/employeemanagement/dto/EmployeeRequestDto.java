package com.hexa.employeemanagement.dto;

import java.time.LocalDate;

import com.hexa.employeemanagement.entity.Employee;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequestDto {

	private String firstName;
	private String lastName;
	private String emailId;
	private Boolean active;
}
