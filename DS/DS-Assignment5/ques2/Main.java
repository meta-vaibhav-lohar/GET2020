package ques2;
public class Main {

	public static void main(String[] args) {
		
		EmployeeList employeeList = new EmployeeList();
		
		employeeList.addNode(20000, 30, "A");
		employeeList.addNode(30000, 40, "B");
		employeeList.addNode(30000, 25, "C");
		employeeList.addNode(10000, 22, "D");
		
		System.out.println("List before sorting : ");
		employeeList.printList(employeeList.linkedListHead);
		
		employeeList.sortEmployeeList();
		
		System.out.println("\nList after sorting : ");
		employeeList.printList(employeeList.sortedLinkedListHead);

	}

}