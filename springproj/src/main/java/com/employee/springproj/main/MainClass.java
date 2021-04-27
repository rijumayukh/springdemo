package com.employee.springproj.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.employee.springproj.controller.EmployeeController;
import com.employee.springproj.model.EmployeeModel;

@Component
public class MainClass 
{
	@Autowired
	EmployeeController employeeController;
	
	

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    
        ApplicationContext context = new ClassPathXmlApplicationContext(
       		"applicationContext.xml");
        MainClass objMainClass = context.getBean(MainClass.class);
        /*EmployeeModel employeeModel = objMainClass.employeeController.getEmployeeById(1L);
        System.out.println(employeeModel);
        */
        EmployeeModel newEmp = new EmployeeModel();
        newEmp.setFirstName("qwe");
        newEmp.setLastName("rty");
        
        objMainClass.employeeController.insertEmplyee(newEmp);
        
       /* EmployeeModel updateEmp = new EmployeeModel();
        updateEmp.setFirstName("XYZ");
        updateEmp.setEmpId(21L);
        objMainClass.employeeController.updateEmplyeeFirstName(updateEmp);
       */ 
        List<EmployeeModel> results = objMainClass.employeeController.getAllEmployees();
        System.out.println(results);
        
    }

	
    
}
