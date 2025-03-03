package com.ems.EMS.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.ems.EMS.*")
@PropertySource("classpath:application.properties")
public class EmsAppConfig {

//    @Bean
//    public Address address() {
//        Address address = new Address();
//        address.setStreet("123 Main St.");
//        address.setCity("London");
//        address.setState("UK");
//        address.setZipCode("123456");
//        return address;
//    }
//
//    @Bean
//    public Department dept() {
//        Department dept = new Department();
//        dept.setDeptID(101);
//        dept.setDeptName("IT");
//        return dept;
//    }
//
//    @Bean
//    public List<String> skills() {
//        return Arrays.asList("Java", "SQL");
//    }
//
//    @Bean
//    public Employee employee() {
//        Employee emp = new Employee();
//        emp.setEmpID(1);
//        emp.setEmpName("John Doe");
//        emp.setEmail("john.doe@example.com");
//        emp.setPhone("123-456-7890");
//        emp.setSalary(75000);
//        emp.setDesignation("Software Engineer");
//        emp.setAddress(address());
//        emp.setDepartment(dept());
//        emp.setSkills(skills());
//        return emp;
//    }
//
////    @Bean
////    public Employee employee2() {
////        Employee emp = new Employee();
////        emp.setEmpID(2);
////        emp.setEmpName("Jane Smith");
////        emp.setEmail("jane.smith@example.com");
////        emp.setPhone("987-654-3210");
////        emp.setSalary(85000);
////        emp.setDesignation("Senior Developer");
////        emp.setAddress(address());
////        emp.setDepartment(dept());
////        emp.setSkills(Arrays.asList("Python", "Django", "JavaScript"));
////        return emp;
////    }
//
//    @Bean
//    public Payroll payroll() {
//        Payroll payroll = new Payroll();
//        payroll.setEmpID(1);
//        payroll.setBaseSalary(75000);
//        payroll.setBonuses(5000);
//        payroll.setDeductions(1000);
//        return payroll;
//    }
//    
//    @Bean
//    public Performance performance() {
//        Performance performance = new Performance();
//        performance.setEmpID(1);
//        performance.setRating(4.5);
//        performance.setFeedback("Excellent performance throughout the year");
//        performance.setProjectsHandled(Arrays.asList("Project Alpha", "Project Beta", "Project Gamma"));
//        performance.setEligibleForPromotion(true);
//        return performance;
//    }
//    
//    @Bean
//    public Map<Integer, Employee> empRecords() {
//        Map<Integer, Employee> rec = new HashMap<>();
//        rec.put(1, employee());
////        rec.put(2, employee2());
//        return rec;
//    }
//
//    @Bean
//    public HR hr() {
//        HR hr = new HR();
//        hr.setEmpRecords(empRecords());
//        return hr;
//    }
	
	//Address Bean
	@Value("${address.street}")
	private String street;
	@Value("${address.city}")
	private String city;
	@Value("${address.state}")
	private String state;
	@Value("${address.zipcode}")
	private String zipcode;

	@Bean
	public Address address() {
      Address address = new Address();
      address.setStreet(street);
      address.setCity(city);
      address.setState(state);
      address.setZipCode(zipcode);
      return address;
	}
	
	//Department Bean
	@Value("${department.id}")
	private int id;
	@Value("${department.name}")
	private String name;

	@Bean
	public Department dept() {
		Department dept = new Department();
        dept.setDeptID(id);;
        dept.setDeptName(name);;
        return dept;
	}

	
	// employee bean
	@Value("${employee.id}")
	private int empid;
	@Value("${employee.name}")
	private String empname;
	@Value("${employee.email}")
	private String email;
	@Value("${employee.phone}")
	private String phone;
	@Value("${employee.salary}")
	private double salary;
	@Value("${employee.designation}")
	private String designation;
//	@Value("${employee.skills}")
//	private String skillsString;
	
	// list of skills for employee
	@Value("${employee.skills}")
	private String skillsString;
	
	@Bean
	public List<String> skills() {
		return Arrays.asList(skillsString.split(","));
	}

	@Bean
	public Employee employee() {
	  Employee employee = new Employee();
	  employee.setEmpID(empid);
	  employee.setEmpName(empname);
	  employee.setEmail(email);
	  employee.setPhone(phone);
	  employee.setSalary(salary);
	  employee.setDesignation(designation);
	  employee.setAddress(address());
	  employee.setDepartment(dept());
	  employee.setSkills(skills());
	  return employee;
	}	
	
	
	// hr bean
	@Bean
	public Map<Integer, Employee> empRecords() {
	    Map<Integer, Employee> rec = new HashMap<>();
	    rec.put(empid, employee());
	    return rec;
	}
	
	@Bean
	public HR hr() {
	    HR hr = new HR();
	    hr.setEmpRecords(empRecords());
	    return hr;
	}
	
	
    // Payroll Bean
    @Value("${payroll.baseSalary}")
    private double baseSalary;
    @Value("${payroll.bonuses}")
    private double bonuses;
    @Value("${payroll.deductions}")
    private double deductions;

    @Bean
    public Payroll payroll() {
        Payroll payroll = new Payroll();
        payroll.setBaseSalary(baseSalary);
        payroll.setBonuses(bonuses);
        payroll.setDeductions(deductions);
        return payroll;
    }
    
    // Performance Bean
    @Value("${performance.employeeId}")
    private int performanceEmployeeId;
    @Value("${performance.rating}")
    private double rating;
    @Value("${performance.feedback}")
    private String feedback;
    @Value("${performance.projectsHandled}")
    private String projectsHandledString;
    @Value("${performance.eligibleForPromotion}")
    private boolean eligibleForPromotion;

    @Bean
    public List<String> projectsHandled() {
        return Arrays.asList(projectsHandledString.split(","));
    }

    @Bean
    public Performance performance() {
        Performance performance = new Performance();
        performance.setEmpID(performanceEmployeeId);
        performance.setRating(rating);
        performance.setFeedback(feedback);
        performance.setProjectsHandled(projectsHandled());
        performance.setEligibleForPromotion(eligibleForPromotion);
        return performance;
    }
	
}
