package com.employee.springproj.dao;

import java.util.List;

import com.employee.springproj.model.EmployeeModel;

public interface IEmployeeDAO {
	
	List<EmployeeModel> getAllEmployees();
	
	EmployeeModel getEmployeeById(Long empId);
	
	void insertEmplyee(EmployeeModel employeeModel);
	
	void updateEmplyeeFirstName(EmployeeModel employeeModel);
}
