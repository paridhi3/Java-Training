package com.ems.EMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.EMS.model.Payroll;

@Service
public class PayrollService {
	@Autowired
	private Payroll payroll;
	public double calAnnualbonus() {
		return payroll.getBonuses()*12;
	}
	public double calAnnualdeduction() {
		return payroll.getDeductions()*12;
	}
 
}
