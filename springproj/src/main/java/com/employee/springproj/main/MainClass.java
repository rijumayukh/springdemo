package com.employee.springproj.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.employee.springproj.service.EmployeeServiceImpl;
import com.employee.springproj.service.IEmploeeService;

@Component
public class MainClass 
{
	@Autowired
	IEmploeeService iEmploeeService;

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       /* ApplicationContext context = new ClassPathXmlApplicationContext(
        		"applicationContext.xml");
        IEmploeeService iEmploeeService = context.getBean("EmployeeService", EmployeeServiceImpl.class);*/
        
        ApplicationContext context = new ClassPathXmlApplicationContext(
        		"applicationContext.xml");
        MainClass objMainClass = context.getBean(MainClass.class);
        objMainClass.iEmploeeService.getEmployee(123L);
    }
}
