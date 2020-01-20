import java.util.Arrays;
import java.lang.Math;
/**
 * The Class NQueensProblem.
 */
public class NQueensProblem {
	
	/**
	 * Queens.
	 *
	 * @param board the board
	 * @param currentQueen the current queen
	 * @param size the size
	 * @return true, if successful
	 */
	public static boolean queens(int []board,int currentQueen,int  size){
		if(currentQueen == size){
			return true;
		}
		for( int iterator = 0; iterator < size; iterator++){
			board[currentQueen] = iterator;
			if(noConflicts(board,currentQueen)){
				boolean done = queens(board, currentQueen+1, size);
				if(done)
					return true;	
			}
		}
		return false;
	}
	
	/**
	 * No conflicts.
	 *
	 * @param board the board
	 * @param currentQueen the current queen
	 * @return true, if successful
	 */
	public static boolean noConflicts(int [] board, int currentQueen){
		for(int iterator = 0; iterator < currentQueen; iterator++){
			if( board[iterator] == board[currentQueen])
				return false;
			if( currentQueen - iterator == Math.abs(board[currentQueen] = board[iterator]))
				return false;
		}	
		return true;					
	}
	
	/**
	 * Calculate queens.
	 *
	 * @param size the size
	 * @return the board with location of queens position
	 */
	public static int[] calculateQueens(int size){
		int board [] = new int[]{};
		if (size<=3)
			throw new AssertionError("The size of the matrix should be greater than 3");
		Arrays.fill(board, -1);
		
		queens(board, 0, size);
		return board;
	}
	
	
	
}
