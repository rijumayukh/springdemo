package com.dao;

import java.util.List;

import com.jdbc.domain.EmployeeDomain;

public interface EmployeeDao {

	 List<EmployeeDomain> getAllEmployees();
	
	 void  insertEmployee(EmployeeDomain emp);
	 
	 void  updateEmployee(EmployeeDomain emp);
}
