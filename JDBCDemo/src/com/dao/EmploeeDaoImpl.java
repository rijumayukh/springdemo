package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.domain.EmployeeDomain;

public class EmploeeDaoImpl implements EmployeeDao {

	@Override
	public List<EmployeeDomain> getAllEmployees() {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from EMPLOYEE_DETAILS");
			
			if(null !=rs){
				List<EmployeeDomain> list = new ArrayList<EmployeeDomain>();
				while (rs.next()) {
					EmployeeDomain emp = new EmployeeDomain();
					emp.setEmpId(rs.getLong("EMPID"));
					emp.setFirstName(rs.getString("FIRST_NAME"));
					emp.setLastName(rs.getString("LAST_NAME"));
					list.add(emp);
				}
				return list;
			}
		} catch (SQLException e) {

		} finally {
			if (null != rs) {
				System.out.println("closing result set");
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				System.out.println("closing statement");
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				System.out.println("closing connection");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void insertEmployee(EmployeeDomain emp) {

		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
			String query = "INSERT INTO EMPLOYEE_DETAILS(FIRST_NAME,LAST_NAME) VALUES(? , ?)";
	//		query = query.replaceFirst("name1", "'"+emp.getFirstName()+"'");
	//		query = query.replaceFirst("name2", "'"+ emp.getLastName()+ "'");
			stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getFirstName());	
			stmt.setString(2, emp.getLastName());
			stmt.executeUpdate();
		} catch (SQLException e) {

		} finally {
			if (null != stmt) {
				System.out.println("closing prepared statement");
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
			if (null != conn) {
				System.out.println("closing connection");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	}

	@Override
	public void updateEmployee(EmployeeDomain emp) {


		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
			stmt = conn.prepareStatement("update EMPLOYEE_DETAILS set FIRST_NAME= ? where EMPID =?");
			stmt.setString(1, emp.getFirstName());	
			stmt.setLong(2, emp.getEmpId());
			stmt.executeUpdate();
		} catch (SQLException e) {

		} finally {
			if (null != stmt) {
				System.out.println("closing prepared statement");
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
			if (null != conn) {
				System.out.println("closing connection");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	
	}

}
