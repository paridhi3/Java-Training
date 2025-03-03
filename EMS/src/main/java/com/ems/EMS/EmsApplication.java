package com.ems.EMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ems.EMS.model.Employee;
import com.ems.EMS.model.EmsAppConfig;
//import com.ems.EMS.model.HR;
//import com.ems.EMS.model.Payroll;
//import com.ems.EMS.model.Performance;
import com.ems.EMS.service.EmployeeService;
import com.ems.EMS.service.HRService;
import com.ems.EMS.service.PayrollService;
import com.ems.EMS.service.PerformanceService;

@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EmsApplication.class, args);
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("emsConfiguration.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
//		
//		Employee emp = context.getBean("employee", Employee.class);
//		Payroll payroll = context.getBean("payroll", Payroll.class);
//		Performance performance = context.getBean("performance", Performance.class);
//		HR hr = context.getBean("hr", HR.class);
//		
//		System.out.println(emp);
//		System.out.println("Calculated Salary: "+payroll.calcSalary());
//		System.out.println(performance);
//		hr.displayEmpRecords();
		
//		Employee emp1 = context.getBean("employee", Employee.class);
//		Payroll payroll1 = context.getBean("payroll", Payroll.class);
//		Performance performance1 = context.getBean("performance", Performance.class);
//		
//
//		System.out.println(emp1);
//		System.out.println("Calculated Salary for Employee 1: " + payroll1.calcSalary());
//		System.out.println(performance1);
//		
//		System.out.println("------------------------------------------------------------------------");
//		
//		Employee emp2 = context.getBean("employee2", Employee.class);
//		Payroll payroll2 = context.getBean("payroll2", Payroll.class);
//		Performance performance2 = context.getBean("performance2", Performance.class);
//
//		System.out.println(emp2);
//		System.out.println("Calculated Salary for Employee 2: " + payroll2.calcSalary());
//		System.out.println(performance2);
//		
//		System.out.println("------------------------------------------------------------------------");
//		
//		HR hr = context.getBean("hr", HR.class);
//		hr.displayEmpRecords();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(EmsAppConfig.class);
		
		System.out.println("Employee service");
		EmployeeService empService = context.getBean(EmployeeService.class);
		empService.printEmpDetails();
		System.out.println(empService.calcAnnualSalary());
		System.out.println(empService.getEmpSkills());
		
		System.out.println("--------------------------------------------");
		
		System.out.println("HR service");
		HRService hrService = context.getBean(HRService.class);
		System.out.println(hrService.getEmpById(2));
		
		System.out.println("--------------------------------------------");
		
		System.out.println("Payroll service");
		PayrollService payrollService = context.getBean(PayrollService.class);
		System.out.println(payrollService.calAnnualbonus());
		System.out.println(payrollService.calAnnualdeduction());
		System.out.println(payrollService.toString());
		
		System.out.println("--------------------------------------------");
		
		System.out.println("Performance service");
		PerformanceService performanceService = context.getBean(PerformanceService.class);
		System.out.println(performanceService.IsEligibleForProject());
		System.out.println(performanceService.displayProjectList());
		
		System.out.println("--------------------------------------------");
		
	}

}
