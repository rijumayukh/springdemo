package com.main;

import com.dao.EmploeeDaoImpl;
import com.dao.EmployeeDao;
import com.jdbc.domain.EmployeeDomain;

public class MainClass {

	public static void main(String[] args) {
		EmployeeDao empDao = new EmploeeDaoImpl();
		//System.out.println(empDao.getAllEmployees());
		
		
		EmployeeDomain emp = new EmployeeDomain();
		emp.setEmpId(102L);
		emp.setFirstName("Mayukh");
		emp.setLastName("xyzz");
		empDao.updateEmployee(emp);
	}

}
