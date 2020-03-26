package ques1;
public class MyStack implements MyStackInterface {
	
	int top = -1;
	int STACK_MAX_SIZE = 100;
	String[] stack = new String[STACK_MAX_SIZE];
	
	/**
	 * This method pushes an element to the stack
	 * @param element is the element to be pushed
	 */
	public void push(String element)
	{
		if(top == -1)
		{
			top = 0;
		}
		else
		{
			top++;
		}
		stack[top] = element;
	}
	
	/**
	 * This method pops an element from the stack
	 */
	public String pop()
	{
		String poppedString;
		if(top == -1)
		{
			throw new AssertionError();
		}
		else
		{
			poppedString = stack[top];
			top--;
		}
		return poppedString;
	}

	/**
	 * This method returns the element which is at the top of the stack
	 * @return {char} element at the top of the stack
	 */
	public String peek()
	{
		if(top == -1)
		{
			throw new AssertionError();
		}
		else
		{
			return stack[top];
		}
	}
	
	/**
	 * This method checks whether the stack is empty or not
	 * @return {boolean}
	 */
	public boolean isEmpty()
	{
		if(top == -1)
			return true;
		return false;
	}
	
	/**
	 * This methods empties the stack
	 */
	public void emptyStack()
	{
		top = -1;
	}
}