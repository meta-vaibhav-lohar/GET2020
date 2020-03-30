package ques1;

public class Employee {

	private int employeeId;
	private String employeeName;
	private String employeeAddress;
	
	/**
	 * Constructor to initialize the data members
	 * @param employeeId is the Employee id
	 * @param employeeName is the Employee Name
	 * @param employeeAddress is the Employee Name
	 */
	Employee(int employeeId, String employeeName, String employeeAddress)
	{
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}

	/**
	 * This method returns the Employee Id
	 * @return {int} Employee Id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * This method returns the Employee Name
	 * @return {String} Employee Name
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * This method returns the Employee Address
	 * @return {String} Employee Address
	 */
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	
	
}