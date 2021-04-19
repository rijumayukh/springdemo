package com.employee.springproj.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
//@Qualifier("iEmploeeService")
@Component
public class EmployeeServiceImpl implements IEmploeeService {

	/* (non-Javadoc)
	 * @see com.employee.springproj.service.IEmploeeService#getEmployee(java.lang.Long)
	 */
	public void getEmployee(Long empId){
		System.out.println("get employee called");
	}
}
