package com.employee.springproj.service;

import java.util.List;

import com.employee.springproj.model.EmployeeModel;

public interface IEmploeeService {

	EmployeeModel getEmployeeById(Long empId);
	
	List<EmployeeModel> getAllEmployees();
	
	void insertEmplyee(EmployeeModel employeeModel);
	
	void updateEmplyeeFirstName(EmployeeModel employeeModel);

}