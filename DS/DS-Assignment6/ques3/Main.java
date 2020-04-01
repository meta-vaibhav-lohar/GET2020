package ques3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		EmployeeList employees = new EmployeeList();
		Scanner inputScanner = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("\n1. Add employee");
			System.out.println("2. Sort the employee list");
			System.out.println("3. Print the employee list");
			System.out.println("4. Exit");
			System.out.print("\nEnter your choice : ");
			choice = inputScanner.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.print("\nEnter the name of the employee : ");
				String employeeName = inputScanner.nextLine();
				employeeName = inputScanner.nextLine();
				System.out.print("Enter the Age of the employee : ");
				int employeeAge = inputScanner.nextInt();
				System.out.print("Enter the Salary of the employee : ");
				double employeeSalary = inputScanner.nextDouble();
				employees.addNodeToList(employeeName, employeeAge, employeeSalary);
				System.out.println("\nEmployee Added!!!");
				break;
				
			case 2:
				employees.sortEmployeeList();
				System.out.println("\nThe sorting has been performed on the list.");
				break;
				
			case 3 : 
				System.out.println("\nThe list is : ");
				employees.printEmployeeList();
				break;
				
			default:
				System.out.println("Enter a valid choice");
			}
		}while(choice != 4);
	}

}