import java.util.Arrays;

public final class Matrix {
	private final static int MAX_ELEMENT=20;
	private final static int ARRAY_COLUMNS=3;
	private final int[][] MatrixArray;
	private int row;
	private int column;
	public Matrix(int[][] MatrixArray,int row,int column) {
		if(MatrixArray.length==0) {
			throw new AssertionError();
		}
		this.MatrixArray=MatrixArray;
		this.row=row;
		this.column=column;
	}
	/**
	 * add two sparse matrices in row-column-value model
	 * @param Matrix
	 * @return addition of two sparse matrices
	 */
	public Matrix addMatrice(Matrix Matrix) {
		//Complexity: O(n) and using merge concept of merge sort
		int[][] MatrixArray=new int[MAX_ELEMENT][ARRAY_COLUMNS];
		int iterator1=0,iterator2=0,iterator3=0;
		if(Matrix.row==row && Matrix.column==column) {
			while( iterator1<this.MatrixArray.length  
					&& iterator2<Matrix.MatrixArray.length) {
				//matrice1.row<matrice2.row or matrice1.column<matrice2.column
				if((this.MatrixArray[iterator1][0]<Matrix.MatrixArray[iterator2][0])
						||( this.MatrixArray[iterator2][0]==Matrix.MatrixArray[iterator2][0] 
								&& this.MatrixArray[iterator1][1]<Matrix.MatrixArray[iterator2][1])){
					MatrixArray[iterator3][0]=this.MatrixArray[iterator1][0];
					MatrixArray[iterator3][1]=this.MatrixArray[iterator1][1];                                                                 
					MatrixArray[iterator3][2]=this.MatrixArray[iterator1][2];
					iterator1++;
					iterator3++;
					
				}
				//matrice1.row>matrice2.row or matrice1.column>matrice2.column
				else if((this.MatrixArray[iterator1][0]>Matrix.MatrixArray[iterator2][0])
						|| (this.MatrixArray[iterator1][0]==Matrix.MatrixArray[iterator2][0] 
								&& this.MatrixArray[iterator1][1]>Matrix.MatrixArray[iterator2][1])) {
					MatrixArray[iterator3][0]=Matrix.MatrixArray[iterator2][0];
					MatrixArray[iterator3][1]=Matrix.MatrixArray[iterator2][1];
					MatrixArray[iterator3][2]=Matrix.MatrixArray[iterator2][2];
					iterator2++;
					iterator3++;
				}
				//row and column both are equal
				else {
					MatrixArray[iterator3][2]=this.MatrixArray[iterator1][2]+Matrix.MatrixArray[iterator2][2];
					if(MatrixArray[iterator3][2]!=0) {
						MatrixArray[iterator3][0]=Matrix.MatrixArray[iterator2][0];
						MatrixArray[iterator3][1]=Matrix.MatrixArray[iterator2][1];
						iterator1++;
						iterator2++;
						iterator3++;
					}
				}
				
			}
			if(iterator1<this.MatrixArray.length) {
				while(iterator1<this.MatrixArray.length) {
					MatrixArray[iterator3][0]=this.MatrixArray[iterator1][0];
					MatrixArray[iterator3][1]=this.MatrixArray[iterator1][1];
					MatrixArray[iterator3][2]=this.MatrixArray[iterator1][2];
					iterator1++;
					iterator3++;
				}
			}
			else {
				while(iterator2<Matrix.MatrixArray.length) {
					System.out.println(iterator3);
					MatrixArray[iterator3][0]=Matrix.MatrixArray[iterator2][0];
					MatrixArray[iterator3][1]=Matrix.MatrixArray[iterator2][1];
					MatrixArray[iterator3][2]=Matrix.MatrixArray[iterator2][2];
					iterator2++;
					iterator3++;
					
				}
			}
		}
		else {
			throw new AssertionError("Both matrice should be of same size");
		}
		int[][] MatrixArray1=new int[iterator3][3];
		for(int x=0;x<iterator3;x++) {
			MatrixArray1[x][0]=MatrixArray[x][0];
			MatrixArray1[x][1]=MatrixArray[x][1];
			MatrixArray1[x][2]=MatrixArray[x][2];
		}
		return new Matrix(MatrixArray1,row,column);
	}
	/**
	 * obtain transpose of given sparse matrix.
	 * @return sparse matrix
	 */
	public Matrix transpose() {
		// complexity: O(n) and counting sort
		int[] count=new int[column+1];
		int[][] MatrixTransposeArray=new int[MatrixArray.length][3];
		for(int iterator=1;iterator<=column;iterator++) {
			count[iterator]=0;
		}
		for(int iterator=0;iterator<MatrixArray.length;iterator++) {
			count[this.MatrixArray[iterator][1]]++;
		}
		//counter for position 
		for(int iterator=2;iterator<=column;iterator++){
			count[iterator]=count[iterator-1]+count[iterator];
		}
		System.out.println(Arrays.toString(count));
		for(int iterator=MatrixArray.length-1;iterator>=0;iterator--){
			MatrixTransposeArray[count[MatrixArray[iterator][1]]-1][0]=MatrixArray[iterator][1];
			MatrixTransposeArray[count[MatrixArray[iterator][1]]-1][1]=MatrixArray[iterator][0];
			MatrixTransposeArray[count[MatrixArray[iterator][1]]-1][2]=MatrixArray[iterator][2];
			count[MatrixArray[iterator][1]]--;
		}
		System.out.println(Arrays.deepToString(MatrixTransposeArray));
		return new Matrix(MatrixTransposeArray,this.row,this.column);
	}
	/**
	 * checks whether that sparse matrix is symmetric or not
	 * @return true if matrix is symmetric otherwise false
	 */
	public boolean isSymmetric(){
		int[][] transposeMatrice=transpose().getarray();
		System.out.println(Arrays.deepToString(MatrixArray));
		System.out.println(Arrays.deepToString(transposeMatrice));
		for(int iterator=0;iterator<MatrixArray.length;iterator++){
			if(MatrixArray[iterator][0]!=transposeMatrice[iterator][0] 
					|| MatrixArray[iterator][1]!=transposeMatrice[iterator][1] ||  MatrixArray[iterator][2]!=transposeMatrice[iterator][2] ){
				return false;
			}
		}
		return true;
	}
	/**
	 * converts matrix from normal form to row-column-value
	 * @param inputMatrice
	 * @return converted matrix
	 * @throws AssertionError
	 */
	 int[][] convertMatrice(int[][] inputMatrice) throws AssertionError
	    {
	        //Complexity: O(n^2)
	        if(inputMatrice.length == 0)
	        {
	            throw new AssertionError("Empty Matrix");
	        }
	        int[][] nonZeroMatrice;
	        int nonZeroValuesCounter = 0;
	        for(int iterator=0; iterator<inputMatrice.length; iterator++)
	        {
	            for(int iterator2=0; iterator2<inputMatrice[iterator].length; iterator2++)
	            {
	                if(inputMatrice[iterator][iterator2] != 0)
	                {
	                    nonZeroValuesCounter++;
	                }
	            }
	        }
	        nonZeroMatrice = new int[nonZeroValuesCounter][3];
	        nonZeroValuesCounter = 0;
	        for(int iterator=0; iterator<inputMatrice.length; iterator++)
	        {
	            for(int iterator2=0; iterator2<inputMatrice[iterator].length; iterator2++)
	            {
	                if(inputMatrice[iterator][iterator2] != 0)
	                {
	                    nonZeroMatrice[nonZeroValuesCounter][0] = iterator+1;
	                    nonZeroMatrice[nonZeroValuesCounter][1] = iterator2+1;
	                    nonZeroMatrice[nonZeroValuesCounter][2] = inputMatrice[iterator][iterator2];
	                    nonZeroValuesCounter++;
	                }
	            }
	        }
	        return nonZeroMatrice;
	}
	 /**
	  * multiplies two matrices 
	  * @param Matrix second matrix 
	  * @return sparse matrix
	  */
	public Matrix multiply(Matrix Matrix) {
		if(this.column!=Matrix.row) {
			throw new AssertionError();
		}
		int[][] productMatrix = new int[this.row][Matrix.column];
		System.out.println(this.MatrixArray.length);
		   for(int iterator=0; iterator<this.MatrixArray.length; iterator++)
	        {    System.out.println(iterator);
	            for(int iterator2=0; iterator2<Matrix.MatrixArray.length; iterator2++)
	            {
	                //for column number of matrix 1 equal to row number of matrix 2
	                if(this.MatrixArray[iterator][1] == Matrix.MatrixArray[iterator2][0])
	                {
	                    productMatrix[this.MatrixArray[iterator][0]-1][Matrix.MatrixArray[iterator2][1]-1] +=  
	                            this.MatrixArray[iterator][2] * Matrix.MatrixArray[iterator2][2];
	                }
	            }
	            
	            
	        }
		   System.out.println(Arrays.deepToString(productMatrix));
		   
		   return new Matrix(convertMatrice(productMatrix),this.row,Matrix.column);
	
	}
	/**
	 * @return sparse matrix in array format
	 */
	public int[][] getarray(){
		return MatrixArray;
	}
}