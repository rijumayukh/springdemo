package com.employee.springproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.employee.springproj.dao.IEmployeeDAO;
import com.employee.springproj.model.EmployeeModel;

@Primary
//@Qualifier("iEmploeeService")
@Service
public class EmployeeServiceImpl implements IEmploeeService {

	@Autowired
	IEmployeeDAO iEmployeeDAO;
	
	
	public EmployeeModel getEmployeeById(Long empId){
		return iEmployeeDAO.getEmployeeById(empId);
	}

	public List<EmployeeModel> getAllEmployees() {
		return iEmployeeDAO.getAllEmployees();
	}
	
	public void insertEmplyee(EmployeeModel employeeModel) {
		iEmployeeDAO.insertEmplyee(employeeModel);
	}

	public void updateEmplyeeFirstName(EmployeeModel employeeModel) {
		iEmployeeDAO.updateEmplyeeFirstName(employeeModel);
	}

}
