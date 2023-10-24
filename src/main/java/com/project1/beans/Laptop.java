package com.project1.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	
	@Id
	private int laptopid;
	private String brand;
	private int price;
	
	@OneToOne(mappedBy="laptop")
	private Employee1 employee;
	
	
	public Laptop() {
		
	}


	public Laptop(int laptopid, String brand, int price, Employee1 employee) {
		super();
		this.laptopid = laptopid;
		this.brand = brand;
		this.price = price;
		this.employee = employee;
	}


	public int getLaptopid() {
		return laptopid;
	}


	public void setLaptopid(int laptopid) {
		this.laptopid = laptopid;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	


	public Employee1 getEmployee() {
		return employee;
	}


	public void setEmployee(Employee1 employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Laptop [laptopid=" + laptopid + ", brand=" + brand + ", price=" + price + ", employee=" + employee
				+ "]";
	}
	
}
