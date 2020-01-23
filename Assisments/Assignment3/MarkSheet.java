/*
 * @author Vaibhav Lohar
 * @date 15-10-2020
 */
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The Class MarkSheet.
 */
public class MarkSheet {
	
	/** The sc. */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Gets the int.
	 *
	 * @return the int
	 */
	public static Integer getInt(){
		
		while (true) {
			try {
					return sc.nextInt();
				}
			catch (Exception ex) {
					System.out.println("Enter Integer value only :");
					sc.next();
				}
			}
	}
	
	/**
	 * This method calculates average grades of student.
	 *
	 * @param grades represents array list of grades of students
	 * @return the averageGrade
	 * @throws ArithmeticException when number of students are zero
	 */
	public static Double averageGrades(ArrayList<Integer> grades) throws ArithmeticException{
		Double averageGrades=0.00;
		
		Integer sum = 0 ;
		for(Integer grade: grades){
			sum += grade;
			}
		
		if (grades.size() == 0) {
			throw new ArithmeticException("Number of students can't be zero.");
		}
		else{
		averageGrades = ((double)sum/grades.size());
		}
		return averageGrades;
	}
	
	/**
	 * This method calculates maximum grade of all.
	 *
	 * @param grades represents array list of grades of students
	 * @return the maximum grade
	 */
	public static Integer maxGrade(ArrayList<Integer> grades){
		int max =0;
		for(Integer grade: grades){
			if( max < grade)
				max=grade;
		}
		return max;
	}
	
	/**
	 * This method calculates minimum grade of all.
	 *
	 * @param grades represents array list of grades of students
	 * @return the minimum grade
	 */
	public static Integer minGrade(ArrayList<Integer> grades){
		int min = 100;
		for(Integer grade: grades){
			if( min > grade)
				min = grade;
		}
		return min;
	}
	
	
	/**
	 * This method calculates percentage of passed students .
	 *
	 * @param grades represents array list of grades of students
	 * @return the percentage of passed students
	 * @throws ArithmeticException when number of students are zero
	 */
	public static Double passedPercentage(ArrayList<Integer> grades) throws ArithmeticException{
		
		if(grades.size() == 0){
			throw new ArithmeticException("Number of students can't be zero");
		}
		
		Integer count =0;
		Double passedPercentage=0.0;
		for(Integer grade: grades){
			if( grade >= 40 )
				count++;
		}
		
		
		passedPercentage =  ((double)(count * 100) /grades.size());
		
		
		return passedPercentage;
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<Integer> studentGrades = new ArrayList<Integer>();
		while(true){
			System.out.println("\n\nMenu\n"
					+ "1) Add Student \n"
					+ "2) Average Grade \n"
					+ "3) Maximum Grade \n"
					+ "4) Minimun Grade \n"
					+ "5) Percentage of passed Students\n"
					+ "6) Exit\n"
					+ "Enter your choice ...");
			int choice = getInt();
			
			switch(choice){
				case 1:
						System.out.println("Enter Student grades between 0 to 100");
						studentGrades.add(getInt());
						break;
				case 2:	
						Double average = null;
						System.out.println("Average Grade of Students");
						try{
							
							average = averageGrades(studentGrades);
							System.out.println("Average :- "+ average);

						}catch(ArithmeticException ex){
							
							System.out.println(ex.getMessage());
						
						}
						break;
				case 3:	
						Integer maxGrade = maxGrade(studentGrades);
						System.out.println("Maximum Grade :- "+maxGrade);
						break;
				case 4:
						Integer minGrade = minGrade(studentGrades);
						System.out.println("Minimum Grade :- "+minGrade);
						break;
				case 5: 
						Double passedPercentage = null;
						try{
	
							passedPercentage = passedPercentage(studentGrades);
							System.out.println("Percentage of passed students "+ passedPercentage);

						}
						catch(ArithmeticException ex){
							System.out.println(ex.getMessage());
						}
						break;
				case 6: System.exit(0);
						break;
				default: 
						System.out.println("Invalid Input");
						break;
			}
		}
	}	
}
