package com.employee.springproj.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee.springproj.model.EmployeeModel;

public class EmployeeModelRowMapper implements  RowMapper<EmployeeModel> {

	public EmployeeModel mapRow(ResultSet resultSet, int arg1) throws SQLException {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setEmpId(resultSet.getLong("EMPID"));
		employeeModel.setFirstName(resultSet.getString("FIRST_NAME"));
		employeeModel.setLastName(resultSet.getString("LAST_NAME"));
		return employeeModel;
	}


	
}
