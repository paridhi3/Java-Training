package com.ems.EMS.model;

public class Department {

	private int deptID;
	private String deptName;
	
	public Department() {
		super();
	}
	
	public Department(int deptID, String deptName) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
	}
	
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", deptName=" + deptName + "]";
	}
	
	
}
