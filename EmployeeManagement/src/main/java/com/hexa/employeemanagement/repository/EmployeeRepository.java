package com.hexa.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexa.employeemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
