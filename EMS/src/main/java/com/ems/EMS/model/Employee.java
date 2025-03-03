package com.ems.EMS.model;

import java.util.List;

public class Employee {

	private int empID;
	private String empName;
	private String email;
	private String phone;
	private double salary;
	private String designation;
	private Address address;
	private Department department;
	private List<String> skills;
	
	public Employee() {
		super();
	}
	
	public Employee(int empID, String empName, String email, String phone, double salary, String designation,
			Address address, Department department, List<String> skills) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.designation = designation;
		this.address = address;
		this.department = department;
		this.skills = skills;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", email=" + email + ", phone=" + phone
				+ ", salary=" + salary + ", designation=" + designation + ", address=" + address + ", department="
				+ department + ", skills=" + skills + "]";
	}
	
	
	
}
