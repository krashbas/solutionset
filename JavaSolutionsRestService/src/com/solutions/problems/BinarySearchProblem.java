package com.solutions.problems;

import java.util.Arrays;

import com.solutions.utils.ProblemDescription;

@ProblemDescription (
		author = "RRR",
		description = "This class implements a solution to the binary search problem.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class BinarySearchProblem extends BaseProblemSolutions {

	/** Input array 
	 * 
	 */
	protected int[] inputArray;
	/**
	 * Number to search in inputArray
	 */
	protected int inputNumber;
	
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input sorted array is: %s\n", Arrays.toString(inputArray));
		System.out.printf("Element to find in inputarray is: %d\n", inputNumber);
		
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Binary search using recursive method");		
		binarySearchRecursive(inputArray, 0, inputArray.length - 1);
		
		System.out.println("Binary search using iterative method");		
		binarySearchIterative(inputArray, 0, inputArray.length - 1);
	}
	
	/**
	 * Perform binary search using recursion
	 * @param array
	 * @param start
	 * @param end
	 */
	private void binarySearchRecursive(int[] array, int start, int end)
	{
		if (end < start)
		{
			return;			
		}
		
		int mid = (start+end)/2;
		if (inputNumber == array[mid])
		{
			System.out.printf("Found %d in input array at position %d\n", inputNumber, mid);
			return;
		}
		else if (inputNumber < array[mid])
		{
			binarySearchRecursive(array, start, mid - 1);
		}
		else
		{
			binarySearchRecursive(array, mid + 1, end);
		}
	}
	
	/**
	 * Perform binary search using iterative method
	 */
	private void binarySearchIterative(int[] array, int start, int end)
	{
		while (start <= end)
		{
			int mid = (start+end)/2;
			if (inputNumber == array[mid])
			{
				System.out.printf("Found %d in input array at position %d\n", inputNumber, mid);
				return;
			}
			
			if (inputNumber < array[mid])
			{
				end = mid - 1;
			}
			else
			{
				start = mid + 1;
			}
		}
	}

	
}
