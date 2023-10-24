package com.project1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.project1.beans.Student;

public class StudentService {
	
	public void addStudent() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Student s1 = new Student(2,"Tom",12);
		transaction.begin();
		manager.persist(s1);
		transaction.commit();
		
	}
	
	public void readStudent() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		Student s1 = manager.find(Student.class, 1);
		System.out.println(s1);
		
	}
	
	public void delete() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.remove(manager.find(Student.class, 2));
		transaction.commit();
	}
	
	public void update() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Student s1 = manager.find(Student.class, 1);
		s1.setAge(15);
		transaction.begin();
		manager.persist(s1);
		transaction.commit();
	}
	
	public void readAllStudents() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Student");
		
		List students =  query.getResultList();
		
		for(Object student : students) {
			System.out.println(student);
		}
	}
	
	public void getStudentByAge() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Student where age = 15");
		List students = query.getResultList();
		
		for(Object student : students) {
			System.out.println(students);
		}
	}
	
	/*public void getNameByRoll() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("select name from Student where roll = 1");
		List students = query.getResultList();
		
		for(Object student : students) {
			System.out.println(students);
		}
		
	} */
	public void getNameByRoll(int roll) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("student_db");
		EntityManager manager = factory.createEntityManager();
		
		Query query = manager.createQuery("from Student where roll = :id "); //NAMED PARAMETER
		
		query.setParameter("id", roll);
		List student = query.getResultList();
		
		System.out.println(student);	
	}
}

