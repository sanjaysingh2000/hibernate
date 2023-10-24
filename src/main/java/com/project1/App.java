package com.project1;

import com.project1.service.EmployeeService1;

public class App {
    public static void main( String[] args )
    {
//        StudentService e1 = new StudentService();
//        e1.getNameByRoll(1);
    	
    	EmployeeService1 e1 = new EmployeeService1();
    	e1.addEmployee();
    }
}