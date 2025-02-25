package com.ems.EMS.model;

import java.util.Map;

public class HR {
	
	private Map<Integer, Employee> empRecords;
	
	public HR() {
		super();
	}

	public HR(Map<Integer, Employee> empRecords) {
		super();
		this.empRecords = empRecords;
	}

	public Map<Integer, Employee> getEmpRecords() {
		return empRecords;
	}

	public void setEmpRecords(Map<Integer, Employee> empRecords) {
		this.empRecords = empRecords;
	}
	
	public void displayEmpRecords() {
		for(Employee emp : empRecords.values()) {
			System.out.println(emp);
		}
	}
	
}
