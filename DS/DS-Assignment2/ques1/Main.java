package ques1;

public class Main {

	public static void main(String[] args) {
		String infixExpression = "( ( 1 + 2 ) * ( 3 + 4 ) ) <= 22";
		ExpressionEvaluation evaluationObject = new ExpressionEvaluation(infixExpression);
		String postfixExpression = evaluationObject.infixToPostfixConversion();
		
		System.out.println("Postfix conversion of " + infixExpression + " is " + "\"" + postfixExpression + "\"");
		
		System.out.println("Evaluation of " + postfixExpression + "is " +evaluationObject.evaluateExpression(postfixExpression));
	}

}