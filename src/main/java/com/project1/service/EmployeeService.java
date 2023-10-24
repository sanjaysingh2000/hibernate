package com.project1.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.project1.beans.Employee;

public class EmployeeService {
	
	public void addEmployee() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Employee e1 = new Employee(0,"sanjay",5000,"Developer","spuranbisht987@gmail.com");
		transaction.begin();
		manager.persist(e1);
		transaction.commit();
		
	}
	
	public void readEmployee() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		Employee e1 = manager.find(Employee.class, 1);
		System.out.println(e1);
	}
	
	public void delete() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Employee e1 = manager.find(Employee.class, 1);
		transaction.begin();
		manager.remove(e1);
		transaction.commit();
	}
	
	public void update() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Employee e1 = manager.find(Employee.class, 1);
		e1.setDesignation("Senior Java Developer");
		transaction.begin();
		manager.persist(e1);
		
		transaction.commit();
	}
	
	public void getEmoloyeeById() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		//Employee e1 =manager.find(Employee.class, 1);//eager loading
		
		Employee e1= manager.getReference(Employee.class, 1); //lazy loading
		
		System.out.println(e1.getName());
		
		
	}
	
	public void employeeInfoByMail() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		String email = sc.next();
		Query query =manager.createQuery("from Employee where email =: id");
		query.setParameter("id", email);
		List employee = query.getResultList();
		System.out.println(employee);
	}
	

}
