import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * The Class JobScheduler.
 */
public class JobScheduler {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * this method calculate wait time.
	 *
	 * @param process represent the list of processes
	 * @return the waitTime array as each process at each index
	 */
	public static Integer[] calculateWaitTime(ArrayList<Integer[]> process) {
		int n= process.size();
		Integer[] waitTime = new Integer[n];
		
		waitTime[0]=0;
		
		for(int iterator = 1; iterator < n; iterator++ ){
			int wt=process.get(iterator-1)[1]-process.get(iterator)[0];
			if (wt <0 ){
				waitTime[iterator]=0;
			}else{
				waitTime[iterator]=wt;
			}
		}
		return waitTime;
	}
	
	/**
	 * this method calculate average waiting time
	 *
	 * @param waitTime represent array of wait time of each process
	 * @return the average waiting time of type double
	 */
	public static Double averageWaitingTime(Integer[] waitTime){
		int sum=0;
		int len = waitTime.length;
		for(int iterator = 0; iterator < len; iterator++){
			sum+=waitTime[iterator];
		}
		return (double) (sum/len) ;
		
	}
	
	/**
	 * this method calculate completion time.
	 *
	 * @param process represent the list of processes
	 * @return array of completion time of each process
	 */
	public static Integer [] calculateCompletionTime(ArrayList<Integer[]> process){
		int len = process.size();
		
		Integer[] completionTime = new Integer[len];
		
		completionTime[0] = process.get(0)[1]+process.get(0)[0];
		
		for(int iterator = 1; iterator < len; iterator++ ) {
				if(process.get(iterator)[0] <	completionTime[iterator-1]){
					completionTime[iterator] = completionTime[iterator-1]+ process.get(iterator)[1];
				}else{
					completionTime[iterator] = process.get(iterator)[0] + process.get(iterator)[1];
				}
		}
		return completionTime;
	}
	
	/**
	 * this method calculate turn around time.
	 *
	 * @param process represent the list of processes
	 * @param completionTime present the completion time of each process
	 * @return the turn around time of each process
	 */
	public static Integer[] calculateTurnAroundTime(ArrayList< Integer [] >process, Integer[] completionTime) {
		int len  = process.size();
		Integer[] turnAroungTime = new Integer[len];
		for(int iterator = 0; iterator < len; iterator++ ){	
		turnAroungTime[iterator]= completionTime[iterator] - process.get(iterator)[0];
		}
		return turnAroungTime;
		
	}
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		ArrayList< Integer []> process = new ArrayList<Integer []>();
		
		/*
		 * waitTime represents the wait time of each process
		 * completionTime represents the completion time of each process
		 * turnAroundTime represents the turn around time of each process
		 * */
		Integer[] waitTime = null,completionTime=null, turnAroundTime=null;
		boolean flag = true;
		while(flag){
			System.out.println("Menu \n"
					+ "1) Add process\n"
					+ "2) Calculate completion time\n"
					+ "3) Calculate waiting time\n"
					+ "4) Average waiting time\n"
					+ "5) Turn around time\n"
					+ "6) Maximum waiting time period\n"
					+ "7) Exit"
					+ "Enter your choice");
			int choice = sc.nextInt();
		
			switch(choice){
			case 1:
					System.out.println("Enter the arrival time");
					Integer arrivalTime = sc.nextInt();
					
					System.out.println("Enter the execution time");
					Integer executionTime = sc.nextInt();
					/* proc represent each process */
					Integer[] proc = new Integer[]{arrivalTime,executionTime};
					process.add(proc);
					
					break;
			
			case 2:
					completionTime = new Integer[process.size()];
					completionTime = calculateCompletionTime(process);
					
					for(int iterator = 0 ; iterator < completionTime.length; iterator++ ) {
						System.out.print(completionTime[iterator] + ", ");
					}
					
					break;
			
			case 3:
					waitTime= new Integer[process.size()];
					waitTime= calculateWaitTime(process);
					
					for(int iterator = 0 ;iterator < waitTime.length;iterator++ ) {
						System.out.print(waitTime[iterator] + ", ");
					}
					
					break;
			
			case 4:	
					Double avgTime = averageWaitingTime(waitTime);
					System.out.println("Average Waiting Time :- "+ avgTime);
					
					break;
			
			case 5:	
					int max = Collections.max(Arrays.asList(waitTime));
					System.out.println("Maximum Waiting Time : "+max);
				 	break;
					
			case 6:
					turnAroundTime = new Integer[process.size()];
					turnAroundTime = calculateTurnAroundTime(process, completionTime);
					for(int iterator = 0; iterator < waitTime.length; iterator++ ) {
						System.out.print(turnAroundTime[iterator] + ", ");
					}
					break;
					
			case 7: System.exit(0);
					break;
			}
		}	
	}
}
