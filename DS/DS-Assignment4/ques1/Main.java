package ques1;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Employee> employeeList;
		EmployeeCollections employeeObject = new EmployeeCollections();
		Scanner inputScanner = new Scanner(System.in);
		int employeeId = 0;
		String choice;
		do
		{
			System.out.println("\n1. Add Employee");
			System.out.println("2. Display the employees");
			System.out.println("3. Sort employees according to Id");
			System.out.println("4. Sort employees according to Name");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice : ");
			choice = inputScanner.nextLine();
			switch(choice)
			{
			case "1" :
				System.out.print("\nEnter the name of the employee : ");
				String employeeName = inputScanner.nextLine();
				System.out.print("Enter the address of the employee : ");
				String employeeAddress = inputScanner.nextLine();
				if(employeeObject.addEmployee(++employeeId, employeeName, employeeAddress))
				{
					System.out.println("Employee Added");
				}
				break;
				
			case "2" :
				System.out.println("\nThe Employees are : (unsorted)");
				employeeList = employeeObject.getEmployeeList();
				Main.printList(employeeList);
				break;
				
			case "3" : 
				System.out.println("\nEmployees sorted by their id : ");
				employeeList = employeeObject.sortEmployeeById();
				Main.printList(employeeList);
				break;
				
			case "4" : 
				System.out.println("\nEmployees sorted by their name : ");
				employeeList = employeeObject.sortEmployeeByName();
				Main.printList(employeeList);
				break;
				
			case "5" : inputScanner.close();
				break;
			
			default : System.out.println("Enter valid choice"); 
			
			}
		}while(!"5".equals(choice));

	}
	
	/**
	 * This method prints the given list
	 * @param list is the list to be printed
	 */
	static void printList(List<Employee> list)
	{
		int i = 0;
		for(Employee employee : list)
		{
			System.out.println("Employee " + (++i));
			System.out.println("\tId = " + employee.getEmployeeId());
			System.out.println("\tName = " + employee.getEmployeeName());
			System.out.println("\tAddress = " + employee.getEmployeeAddress());
		}
	}

}