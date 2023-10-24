package com.project1.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee1 {
	
	@Id
	private int empid;
	private String name;
	private String designation;
	
	//@OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	private Laptop laptop;

	public Employee1() {
		
		
	}

	

	public Employee1(int empid, String name, String designation, Laptop laptop) {
		super();
		this.empid = empid;
		this.name = name;
		this.designation = designation;
		this.laptop = laptop;
	}



	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

	public Laptop getLaptop() {
		return laptop;
	}



	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}



	@Override
	public String toString() {
		return "Employee1 [empid=" + empid + ", name=" + name + ", designation=" + designation + ", laptop=" + laptop
				+ "]";
	}



	

}
