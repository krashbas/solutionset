package com.solutions.problems;

import java.util.Arrays;

import com.solutions.utils.ProblemDescription;

@ProblemDescription (
		author = "RRR",
		description = "This class implements a solution to rotate a given matrix by 90 degrees.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class RotateMatrixBy90Problem extends BaseProblemSolutions {
	protected int matrixSize;
	protected int[] inputMatrixArray;
	
	private int[][] inputMatrix;
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Size of the matrix is: %d\n", matrixSize);
		System.out.printf("Input matrix is: %s\n", Arrays.toString(inputMatrixArray));
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		createMatrix();
		displayMatrix();
		
		/* Rotate the matrix by 90 degrees */
		for (int level = 0; level < matrixSize/2; level++)
		{
			int first = level;
			int last = matrixSize - 1 - level;
			
			for (int i = first; i < last; i++)
			{
				int offset = i - first;
				
//				int top = inputMatrix[first][i];
//				int left = inputMatrix[last-offset][first];
//				int bottom = inputMatrix[last][last-offset];
//				int right = inputMatrix[i][last];
				
				int temp = inputMatrix[first][i];
				inputMatrix[first][i] = inputMatrix[last-offset][first];
				inputMatrix[last-offset][first] = inputMatrix[last][last-offset];
				inputMatrix[last][last-offset] = inputMatrix[i][last];
				inputMatrix[i][last] = temp;				
			}
		}
		
		System.out.println("Matrix after 90 deg rotation:");
		displayMatrix();
	}
	
	/**
	 * Display matrix
	 */
	private void displayMatrix()
	{		
		for (int i = 0; i < matrixSize; i++)
		{
			for (int j = 0; j < matrixSize; j++)
			{
				System.out.printf("%d ", inputMatrix[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Create matrix from array
	 * @throws Exception
	 */
	private void createMatrix() throws Exception
	{
		inputMatrix = new int[matrixSize][matrixSize];
		if (inputMatrixArray.length < (matrixSize * matrixSize))
		{
			throw new Exception("Not enough numbers in input array to create a NxN matrix");
		}
		int k = 0;
		for (int i = 0; i < matrixSize; i++)
		{
			for (int j = 0; j < matrixSize; j++)
			{
				inputMatrix[i][j] = inputMatrixArray[k++]; 
			}			
		}
	}
}
