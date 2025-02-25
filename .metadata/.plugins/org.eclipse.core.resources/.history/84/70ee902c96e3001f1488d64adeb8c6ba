package EmpMgmt;

public class Manager extends FTE implements BonusProvider{

	public Manager(String empName, int empID, String dept, double baseSalary, int leaveBalance, double bonus) {
		super(empName, empID, dept, baseSalary, leaveBalance, bonus);
	}

	@Override
	public double calBonus(double salary) {
		return salary*bonusPercentage;
	}
	
}
