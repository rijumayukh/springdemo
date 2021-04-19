package com.employee.springproj.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.springproj.service.EmployeeServiceImpl;

public class MainClass 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext(
        		"applicationContext.xml");
        EmployeeServiceImpl EmployeeServiceImpl = context.getBean("EmployeeService", EmployeeServiceImpl.class);
        EmployeeServiceImpl.getEmployee(123L);
    }
}
