package com.project1.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.project1.beans.Employee;
import com.project1.beans.Employee1;
import com.project1.beans.Laptop;

public class EmployeeService1 {
	
	public void addEmployee() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		
		Laptop lap = new Laptop();
		Employee1 e1 = new Employee1();
		
		
		lap.setBrand("Dell");
		lap.setPrice(45000);
		lap.setLaptopid(1);
		lap.setEmployee(e1);
		
		
		
		e1.setEmpid(1);
		e1.setLaptop(lap);;
		e1.setDesignation("Ase");
		e1.setName("Rahul");
		
		transaction.begin();
//		manager.persist(e1);
		//manager.persist(lap);
		transaction.commit();
		
//		transaction.begin();
//		manager.persist(e1);
//		manager.persist(lap);
//		transaction.commit();
	
	}
	
	public void fetchDetailOfEmployeeByLaptopid() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		Laptop laptopid = manager.find(Laptop.class, 1);
		System.out.println(laptopid);
		
		Query query = manager.createQuery("from Employee where laptopid=:lp");
		query.setParameter("lp", laptopid);
		
		List employee=query.getResultList();
		System.out.println(employee);
		
	}

}
