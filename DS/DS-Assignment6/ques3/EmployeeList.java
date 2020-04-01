package ques3;

public class EmployeeList {
	
	EmployeeNode listHead;
	EmployeeNode listTail;
	int listSize;
	
	/**
	 * Constructor to initialize the data memvers of the class
	 */
	EmployeeList() 
	{
		listHead = null;
		listTail = null;
		this.listSize = 0;
	}

	/**
	 * This method adds a Employee to the Employee List
	 * @param employeeName is the name of the employee
	 * @param employeeAge is the age of the employee
	 * @param employeeSalary is the salary of the employee
	 */
	void addNodeToList(String employeeName, int employeeAge, double employeeSalary)
	{
		EmployeeNode employee = new EmployeeNode(employeeName, employeeAge, employeeSalary);
		if(listHead == null)
		{
			listHead = employee;
			listTail = employee;
		}
		else
		{
			listTail.nextNode = employee;
			listTail = employee;
		}
		this.listSize++;
	}
	
	/**
	 * This method calls the quick sort method
	 */
	void sortEmployeeList()
	{
		quickSort(0, this.listSize - 1);
	}

	/**
	 * Recursive method to sort the linked list using quick sort method
	 * @param low is the first index of the list
	 * @param high is the last index of the list
	 */
	void quickSort(int low, int high) 
	{
		
		if(low < high)
		{ 
            int pivotIndex = partition(low, high); 
            quickSort(low, pivotIndex - 1); 
            quickSort(pivotIndex+1, high); 
        } 
	}

	/**
	 * This method partitions the list according to the pivot element
	 * @param low is the first index of the list
	 * @param high is the last index of the list
	 * @return {int} the index at which the list is partitioned
	 */
	int partition(int low, int high) 
	{
		EmployeeNode pivot = getEmployee(high);
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			//check any employee has salary greater than pivot
			if (getEmployee(j).getEmployeeSalary() >= pivot.getEmployeeSalary()) {
				//if salary is same than compare age
				if((getEmployee(j).getEmployeeSalary() == pivot.getEmployeeSalary()) && (getEmployee(j).getEmployeeAge() > pivot.getEmployeeAge()))
					continue;
				i++;
				//swap data of employees
				String name = getEmployee(i).getEmployeeName();
				int age = getEmployee(i).getEmployeeAge();
				double salary = getEmployee(i).getEmployeeSalary();
				getEmployee(i).setEmployeeData(getEmployee(j).getEmployeeName(), getEmployee(j).getEmployeeAge(), getEmployee(j).getEmployeeSalary());
				getEmployee(j).setEmployeeData(name, age, salary);
			}
		}
		// set pivot employee on his correct position
		String name = getEmployee(i + 1).getEmployeeName();
		int age = getEmployee(i + 1).getEmployeeAge();
		double salary = getEmployee(i + 1).getEmployeeSalary();
		getEmployee(i + 1).setEmployeeData(getEmployee(high).getEmployeeName(), getEmployee(high).getEmployeeAge(), getEmployee(high).getEmployeeSalary());
		getEmployee(high).setEmployeeData(name, age, salary);
		
//		System.out.println("Intermediate list");
//		printEmployeeList();
		return (i + 1);
	}
	
	/**
	 * Utility method to find an employee at a particular index
	 * @param index is the index at which the employee is to be found
	 * @return {EmployeeNode} employee on that index
	 */
	private EmployeeNode getEmployee(int index) {
		//check index is valid or not
		if (index < listSize) {
			EmployeeNode currentNode = listHead;
			for (int i = 0; i < index; i++)
				currentNode = currentNode.nextNode;
			
			return currentNode;
		} 
		else
			throw new AssertionError("Invalid employee Index");
	}
	
	/**
	 * This method prints the employee list
	 */
	void printEmployeeList()
	{
		int i = 0;
		EmployeeNode temporarayNode = listHead;
		while(temporarayNode != null)
		{
			System.out.println("Employee " + (++i));
			System.out.println("\tName = " + temporarayNode.getEmployeeName() + 
					"\n\tAge = " + temporarayNode.getEmployeeAge() + "\n\tSalary = " + 
					temporarayNode.getEmployeeSalary());
			temporarayNode = temporarayNode.nextNode;
		}
	}
}