package ques1;

public class ExpressionEvaluation {

	String infixExpression;
	MyStack stack = new MyStack();

	/**
	 * Constructor to initialize the infixExpression and the size of the stack
	 * @param infixExpression is the infix expression
	 */
	ExpressionEvaluation(String infixExpression) {
		this.infixExpression = infixExpression;
	}

	/**
	 * This method converts the infix expression to postfix expression
	 * @return {String} postfix expression
	 */
	String infixToPostfixConversion() {
		StringBuilder postfixExpression = new StringBuilder();
		String infixArray[] = infixExpression.split(" ");
		
		for (int i = 0; i < infixArray.length; i++) {
			if (!isOperator(infixArray[i])) {
				postfixExpression.append(infixArray[i]);
				postfixExpression.append(" ");
			} 
			else if ("(".equals(infixArray[i])) {
				stack.push(infixArray[i]);
			} 
			else {
				if (")".equals(infixArray[i])) {
					while (!("(".equals(stack.peek()))) {
						postfixExpression.append(stack.pop());
						postfixExpression.append(" ");
					}
					if (
							"(".equals(stack.peek())) {
						stack.pop();
					}
				}
				else {
					if (isOperator(infixArray[i])) {
						if (stack.isEmpty()) {
							stack.push(infixArray[i]);
						} 
						else {
							if (((getPrecedence(infixArray[i])) > (getPrecedence(stack.peek())))) {
								stack.push(infixArray[i]);
							} 
							else {
								while ((getPrecedence(infixArray[i]) <= getPrecedence(stack.peek())) && !("(".equals(stack.peek()))) {
									postfixExpression.append(stack.pop());
									postfixExpression.append(" ");
								}
								stack.push(infixArray[i]);
							}
						}
					} 
				}
			}
		}
		//Append the remaining operators from the stack to the postfix expression
		while (!(stack.isEmpty())) {
			postfixExpression.append(stack.pop());
			postfixExpression.append(" ");
		}
		
		return postfixExpression.toString();
	}

	int evaluateExpression(String expression)
	{
		stack.emptyStack();
		Integer value1, value2, answer;
		if(expression == null || expression == "")
			throw new AssertionError("Expression is empty");
		
		String[] expressionArray = expression.split(" ");
		for(int i = 0; i < expressionArray.length; i++)
		{
			if(!isOperator(expressionArray[i]))
			{
				stack.push(expressionArray[i]);
			}
			else
			{
				switch(expressionArray[i])
				{
				case "*":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					answer = value1 * value2;
					stack.push(answer.toString());
					break;
				case "/":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					answer = value1 / value2;
					stack.push(answer.toString());
					break;
				case "+": 
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					answer = value1 + value2;
					stack.push(answer.toString());
					break;
				case "-":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					answer = value1 - value2;
					stack.push(answer.toString());
					break;
				case "%":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					answer = value1 % value2;
					stack.push(answer.toString());
					break;
				case "<":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					if(value2 < value1) answer = 1;
					else answer =0;
					stack.push(answer.toString());
					break;
				case ">":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					if(value2 > value1) answer = 1;
					else answer =0;
					stack.push(answer.toString());
					break;
				case "<=":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					if(value2 <= value1) answer = 1;
					else answer =0;
					stack.push(answer.toString());
					break;
				case ">=":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					if(value2 >= value1) answer = 1;
					else answer =0;
					stack.push(answer.toString());
					break;
				case "==":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					if(value2 == value1) answer = 1;
					else answer =0;
					stack.push(answer.toString());
					break;
				case "!=":
					value1 = Integer.parseInt(stack.pop());
					value2 = Integer.parseInt(stack.pop());
					if(value2 != value1) answer = 1;
					else answer =0;
					stack.push(answer.toString());
					break;
				case "&&":
				case "||":

				}
			}
		}
		if(stack.isEmpty())
			return 0;
		
		return Integer.parseInt(stack.pop());
		
	}
	/**
	 * This method checks whether the given character is operator or not
	 * @param character is the character to be checked
	 * @return {boolean}
	 */
	boolean isOperator(String character) {
		switch (character) {
		case "!":
		case "*":
		case "%":
		case "/":
		case "+":
		case "-":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "==":
		case "!=":
		case "&&":
		case "||":
		case "(":
		case ")":
			return true;
		default:
			return false;
		}
	}

	/**
	 * This method calculates the precedence of a operator
	 * @param operator is the operator whose precedence is to be determined
	 * @return {int} precedence of the operator
	 */
	int getPrecedence(String operator) {
		switch (operator) {
		case "!":
			return 1;
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 3;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 4;
		case "==":
		case "!=":
			return 5;
		case "&&":
			return 6;
		case "||":
			return 7;
		}
		return -1;
	}
	
}
