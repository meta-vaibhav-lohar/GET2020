package ques1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeCollections {
	
	private List<Employee> employeeList;
	
	public EmployeeCollections() {
		employeeList = new ArrayList<>();
	}

	List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	/**
	 * This method adds an employee to the employee list given it satisfies some conditions
	 * @param employeeId is Id of the employee to be added
	 * @param employeeName is Name of the employee to be added
	 * @param employeeAddress is Address of the employee to be added
	 * @return {boolean}
	 */
	boolean addEmployee(int employeeId, String employeeName, String employeeAddress)
	{
		boolean isEmployeeAdded = false;
		if((employeeId > 0) && isEmployeeUnique(employeeId) && isEmployeeNameValid(employeeName) && employeeAddress != null)
		{
			Employee employee = new Employee(employeeId, employeeName, employeeAddress);
			employeeList.add(employee);
			isEmployeeAdded = true;
		}
		else
		{
			System.out.println("There was an error while adding the employee because of invalid parameters");
		}
		return isEmployeeAdded;
	}
	
	/**
	 * This method sorts the employees in ascending order according to their employee id
	 * @return {List<Employee>} sort employee list
	 */
	List<Employee> sortEmployeeById()
	{
		List<Employee> sortedEmployees = this.employeeList;
		Collections.sort(sortedEmployees, new SortOnId());
		return sortedEmployees;
	}
	
	/**
	 * This method sorts the employees in ascending order according to their name
	 * @return {List<Employee>} sort employee list
	 */
	List<Employee> sortEmployeeByName()
	{
		List<Employee> sortedEmployees = this.employeeList;
		Collections.sort(sortedEmployees, new SortOnName());
		return sortedEmployees;
	}
	/**
	 * This method checks whether an employee is unique by checking its employee id
	 * @param employeeId is the employee Id of the employee to be checked
	 * @return {boolean}
	 */
	boolean isEmployeeUnique(int employeeId)
	{
		boolean answer = true;
		for(Employee employee :  employeeList)
		{
			if(employee.getEmployeeId() == employeeId)
			{
				answer = false;
			}
		}
		return answer;
	}

	/**
	 * This method checks whether an employee name is valid
	 * @param employeeName is the employee Name of the employee to be validated
	 * @return {boolean}
	 */
	boolean isEmployeeNameValid(String employeeName)
	{
		boolean isValid = true;
		for(int i = 0; i < employeeName.length(); i++)
		{
			if(!(((employeeName.charAt(i) >= 'A') && (employeeName.charAt(i) <= 'Z')) || ((employeeName.charAt(i) >= 'a') && (employeeName.charAt(i) <= 'z'))))
			{
				isValid = false;
			}
		}
		return isValid;
	}
}