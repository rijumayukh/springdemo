package com.employee.springproj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.employee.springproj.dao.rowmapper.EmployeeModelRowMapper;
import com.employee.springproj.model.EmployeeModel;

@Repository
@Primary
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<EmployeeModel> getAllEmployees(){
		final String SQL_GET_ALL_EMPLOYEES = "select * from EMPLOYEE_DETAILS";
		List<EmployeeModel> results = jdbcTemplate.query(SQL_GET_ALL_EMPLOYEES, new EmployeeModelRowMapper());
		return results;

	}
	
	public EmployeeModel getEmployeeById(Long empId){
		final String SQL_GET_EMPLOYEE_BY_ID = "select * from EMPLOYEE_DETAILS where EMPID = :EMPID";
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("EMPID", empId);
		List<EmployeeModel> results = namedParameterJdbcTemplate.query(SQL_GET_EMPLOYEE_BY_ID, parameters, new EmployeeModelRowMapper());
		if(null != results && !results.isEmpty()){
			return results.get(0);
		}
		return null;
		
	}
	
	public void insertEmplyee(EmployeeModel employeeModel){
		final String INSERT_SQL = "INSERT INTO EMPLOYEE_DETAILS(FIRST_NAME,LAST_NAME) VALUES(:FIRSTNAME , :LASTNAME)";
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("FIRSTNAME", employeeModel.getFirstName());
		parameters.put("LASTNAME", employeeModel.getLastName());
		namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
	
	}
	
	public void updateEmplyeeFirstName(EmployeeModel employeeModel){
		final String INSERT_SQL = "UPDATE EMPLOYEE_DETAILS set first_name=:FIRSTNAME where empID = :EMPID";
		Map<String, Object> parameters= new HashMap<>();
		parameters.put("FIRSTNAME", employeeModel.getFirstName());
		parameters.put("EMPID", employeeModel.getEmpId());
		namedParameterJdbcTemplate.update(INSERT_SQL, parameters);
	}
}

