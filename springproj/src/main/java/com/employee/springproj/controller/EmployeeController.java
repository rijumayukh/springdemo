package com.employee.springproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.springproj.model.EmployeeModel;
import com.employee.springproj.service.IEmploeeService;

@Component
public class EmployeeController {
	
	@Autowired
	IEmploeeService iEmploeeService;
	
	public List<EmployeeModel> getAllEmployees(){
		return iEmploeeService.getAllEmployees();
	}
	
	public EmployeeModel getEmployeeById(Long empId){
		return iEmploeeService.getEmployeeById(empId);
	}
	
	public void insertEmplyee(EmployeeModel employeeModel) {
		iEmploeeService.insertEmplyee(employeeModel);
	}

	public void updateEmplyeeFirstName(EmployeeModel employeeModel) {
		iEmploeeService.updateEmplyeeFirstName(employeeModel);
	}


}
