/*
 * @author Vaibhav Lohar
 * @date 15-01-2020
 */

import java.util.Scanner;


/**
 * The Class Area.
 */
public class Area {
	
	/** The sc. */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Gets the int.
	 * @
	 * @return the int
	 */
	public static Integer getInt(){
		
		while (true) {
			try {
					return sc.nextInt();
				}
			catch (Exception ex) {
					System.out.println("Enter integer value only :");
					sc.next();
				}
			}
	}
	
	/**
	 * Area triangle.
	 *
	 * @param base represents the base length of triangle
	 * @param height represents the height of triangle
	 * @return the area of triangle of type double
	 * @throws ArithmeticException when inputs are negative
	 */
	public static Double areaTriangle(Double base, Double height) throws ArithmeticException{
		if( base < 0  || height < 0){
			throw new ArithmeticException("Lengths can't be negative");
		}
		return ((0.5)*base*height);
	}
	
	/**
	 * Area rectangle.
	 *
	 * @param length represents the length of rectangle
	 * @param breadth represents the breadth of rectangle
	 * 
	 * @return the area of rectangle of type double
	 * @throws ArithmeticException when inputs are negative
	 */
	public static Double areaRectangle(Double length, Double breadth) throws ArithmeticException{
		if( length < 0  || breadth < 0){
			throw new ArithmeticException("Length can't be negative");
		}
		return (length * breadth);
	}
	
	/**
	 * Area square.
	 *
	 * @param side represents the side of square
	 * @return the area of square of type double
	 * @throws ArithmeticException when inputs are negative
	 */
	public static Double areaSquare(Double side) throws ArithmeticException{
		if( side < 0 ){
			throw new ArithmeticException("Length or breadth can't be negative");
		}
		return (4*side);
	}
	
	/**
	 * Area circle.
	 *
	 * @param radius the radius
	 * @return the are of circle of type double
	 * @throws ArithmeticException when inputs are negative
	 */
	public static Double areaCircle(Double radius) throws ArithmeticException{
		if(radius < 0){
			throw new ArithmeticException("Radius can't be negative");
		}
		return (3.14 * radius * radius);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main( String[] args){
		
		while(true){
			System.out.println("Menu\n"
					+ "1) Area of Triangle\n"
					+ "2) Area of Rectangle\n"
					+ "3) Area of Square\n"
					+ "4) Area of Circle\n"
					+ "5) Exit \n"
					+ "Enter your choice ....");
			
			int choice = sc.nextInt();
			switch(choice){
				case 1:
						System.out.println("Enter the Base length");
						Double base = sc.nextDouble();
						System.out.println("Enter the Height length");
						Double height = sc.nextDouble();
						Double areaTriangle = areaTriangle(base,height);
						System.out.println("Area of triangle :- "+ areaTriangle);
						break;
				case 2:
						System.out.println("Enter the Length");
						Double length = sc.nextDouble();
						System.out.println("Enter the Breadth");
						Double breadth = sc.nextDouble();
						Double areaRectangle = areaRectangle(length,breadth);
						System.out.println("Area of Rectangle :- "+ areaRectangle);
						break;	
				case 3:
						System.out.println("Enter the Side length");
						Double side = sc.nextDouble();
						Double areaSquare = areaSquare(side);
						System.out.println("Area of Square :- "+ areaSquare);
						break;
				case 4:
						System.out.println("Enter the Radius length");
						Double radius = sc.nextDouble();
						Double areaCircle = areaCircle(radius);
						System.out.println("Area of triangle :- "+ areaCircle);
						break;
				case 5:
						System.exit(0);
			}
		}
	}
}
