package ques31;

public class BowlersDetails {
	String name;
	int Balls;
	
	/**
	 * @param ele
	 * @param balls
	 */
	public BowlersDetails(String name,int balls){
		this.name=name;
		this.Balls=balls;
	}
	
	/**
	 * @return name of the bowler
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return no. of balls remaining
	 */
	public int getPriority(){
		return Balls;
	}
	
	/**
	 * @param balls
	 * set the balls 
	 */
	public void setBowlerBall(int balls){
		this.Balls = balls;
	}

}