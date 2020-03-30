package ques2;

public class EmployeeList {
	
	Node linkedListHead;
	Node linkedListTail;
	
	Node sortedLinkedListHead; //Head for sorted linked list
	
	/**
	 * Constructor to initialize an empty list
	 */
	public EmployeeList()
	{
		linkedListHead = null;
		linkedListTail = null;
		sortedLinkedListHead = null;
	}

	/**
	 * This method adds a node in the linked list
	 * @param employeeId is the data part of the node
	 */
	public void addNode(double employeeSalary, int employeeAge, String employeeName) {       
        Node newNode = new Node(employeeSalary, employeeAge, employeeName);    
        
        if(linkedListHead == null) {    
        	linkedListHead = newNode;    
        	linkedListTail = newNode;    
        }    
        else {    
        	linkedListTail.next = newNode;    
        	linkedListTail = newNode;    
        }    
    }
	
	/**
	 * This method sorts the given employee list with the insertion sort method.
	 */
	void sortEmployeeList()
	{
		Node currentNode = linkedListHead;
		while(currentNode != null)
		{
			Node nextNode = currentNode.next;
			if((sortedLinkedListHead == null) || 
					(sortedLinkedListHead.getEmployeeSalaray() <= currentNode.getEmployeeSalaray()))
			{
				if(sortedLinkedListHead == null)
				{
					currentNode.next = sortedLinkedListHead;
					sortedLinkedListHead = currentNode;
				}
				else if(sortedLinkedListHead.getEmployeeSalaray() < currentNode.getEmployeeSalaray())
				{
					currentNode.next = sortedLinkedListHead;
					sortedLinkedListHead = currentNode;
				}
				else if((sortedLinkedListHead.getEmployeeSalaray() == currentNode.getEmployeeSalaray()) && 
						(sortedLinkedListHead.getEmployeeAge() > currentNode.getEmployeeAge()))
				{
					currentNode.next = sortedLinkedListHead;
					sortedLinkedListHead = currentNode;
				}
				else
				{
					Node temporary = sortedLinkedListHead;
					while((temporary.next != null) && (temporary.next.getEmployeeSalaray() == currentNode.getEmployeeSalaray()) && 
							(temporary.next.getEmployeeAge() < currentNode.getEmployeeAge()))
					{
						temporary = temporary.next;
					}
					currentNode.next = temporary.next;
					temporary.next = currentNode;
				}
			}
			else
			{
				Node temporaryNode = sortedLinkedListHead;
				while((temporaryNode.next != null) && 
						(temporaryNode.next.getEmployeeSalaray() >= currentNode.getEmployeeSalaray()))
				{
					if((temporaryNode.next.getEmployeeSalaray() == currentNode.getEmployeeSalaray()) &&
							temporaryNode.next.getEmployeeAge() < currentNode.getEmployeeAge())
					{
						temporaryNode = temporaryNode.next;
					}
					else if(temporaryNode.next.getEmployeeSalaray() > currentNode.getEmployeeSalaray())
					{
						temporaryNode = temporaryNode.next;
					}
				}
				
				temporaryNode.next = currentNode;
				temporaryNode.next.next = null;
			}
			currentNode = nextNode;
		}
		
	}
	
	/**
	 * This method prints the linked list
	 */
	public void printList(Node head)
	{
		Node temporaryNode = head;
		int i = 1;
		while(temporaryNode != null)
		{
			System.out.println("Employee : " + i);
			System.out.print("Employee Name : " + temporaryNode.getEmployeeName() + 
					"  Employee Salaray : " + temporaryNode.getEmployeeSalaray() + 
					"  Employee Age : " + temporaryNode.getEmployeeAge());
			temporaryNode = temporaryNode.next;
			i++;
			System.out.println();
		}
	}
}