package ques3;

import java.util.ArrayList;
import java.util.List;

public class Term {
	
	int termCoefficient;
	List<Variable> variableList = new ArrayList<>();

	/**
	 * Constructor to initialize the data members of the class
	 * @param termCoefficient is the term's coefficient
	 * @param variableList is list of variables in the term
	 */
	Term(int termCoefficient, List<Variable> variableList)
	{
		this.termCoefficient = termCoefficient;
		this.variableList = variableList;
	}
}