package com.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	private static final String DRIVER_CLASS_NAME="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "system";
	private static final String PASSWORD="123456";


	public static Connection getConnection(){
		try {
			Driver myDriver =  (Driver) Class.forName(DRIVER_CLASS_NAME).newInstance();
			DriverManager.registerDriver(myDriver);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			}catch(IllegalAccessException ex) {
			   System.out.println("Error: access problem while loading!");
			}catch(InstantiationException ex) {
			   System.out.println("Error: unable to instantiate driver!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
}
