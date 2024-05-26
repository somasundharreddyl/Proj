package com.hexa.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.employeemanagement.dto.EmployeeRequestDto;
import com.hexa.employeemanagement.dto.EmployeeResponseDto;
import com.hexa.employeemanagement.entity.Employee;
import com.hexa.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Long createEmployee(EmployeeRequestDto employeeRequestDto) {
		Employee employee=Employee.builder().firstName(employeeRequestDto.getFirstName())
				                            .lastName(employeeRequestDto.getLastName())
				                            .emailId(employeeRequestDto.getEmailId())
				                            .active(employeeRequestDto.getActive())
				                            .build();
		Employee createdEmployee = employeeRepository.save(employee);
		return createdEmployee.getId();
	}

	@Override
	public EmployeeResponseDto findEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		ModelMapper modelMapper=new ModelMapper();
		EmployeeResponseDto employeeresponseDto = modelMapper.map(employee,EmployeeResponseDto.class);
		return employeeresponseDto;
	}

	@Override
	public EmployeeResponseDto updateEmployee(EmployeeResponseDto employeeResponseDto) {
		ModelMapper modelMapper=new ModelMapper();
		Employee employee = modelMapper.map(employeeResponseDto,Employee.class);
		Employee updatedEmployee = employeeRepository.save(employee);
		EmployeeResponseDto updatedEmployeeresponseDto = modelMapper.map(updatedEmployee,EmployeeResponseDto.class);
		return updatedEmployeeresponseDto;
	}

	@Override
	public String deleteEmployeeById(Long id) {
		
		if(employeeRepository.findById(id).get()!=null) {
			employeeRepository.deleteById(id);	
		}
		return "Employee with Id:"+id+" deleted Successfully";
	}

	@Override
	public List<EmployeeResponseDto> getEmployeeList() {
		List<Employee> empList=employeeRepository.findAll();
		ModelMapper modelMapper=new ModelMapper();
		EmployeeResponseDto employeeresponseDto=null;
		List<EmployeeResponseDto> empResList=new ArrayList<>();
		for(Employee emp:empList) {
			employeeresponseDto = modelMapper.map(emp,EmployeeResponseDto.class);
			empResList.add(employeeresponseDto);
		}
		return empResList;
	}

	
}
