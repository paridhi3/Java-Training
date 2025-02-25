package com.ems.EMS.model;

public class Payroll {

	private int empID;
	private double baseSalary;
	private double bonuses;
	private double deductions;
	
	public Payroll() {
		super();
	}
	
	public Payroll(int empID, double baseSalary, double bonuses, double deductions) {
		super();
		this.empID = empID;
		this.baseSalary = baseSalary;
		this.bonuses = bonuses;
		this.deductions = deductions;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getBonuses() {
		return bonuses;
	}

	public void setBonuses(double bonuses) {
		this.bonuses = bonuses;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}
	
	public double calcSalary() {
		return baseSalary+bonuses-deductions;
	}

	@Override
	public String toString() {
		return "Payroll [empID=" + empID + ", baseSalary=" + baseSalary + ", bonuses=" + bonuses + ", deductions="
				+ deductions + "]";
	}
	
	
	
}
