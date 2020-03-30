package ques1;

import java.util.Comparator;

public class SortOnName implements Comparator<Employee> {

	//Overriding the method
	@Override
	public int compare(Employee employee1, Employee employee2) {
		
		return employee1.getEmployeeName().compareTo(employee2.getEmployeeName());
	}

}