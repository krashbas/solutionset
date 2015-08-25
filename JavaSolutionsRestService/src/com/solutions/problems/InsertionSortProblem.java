package com.solutions.problems;
import java.util.Arrays;

import com.solutions.problems.IProblemSolutions;

public class InsertionSortProblem extends IProblemSolutions {
	
	protected int[] inputArray;
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input unsorted array is: %s\n", Arrays.toString(inputArray));
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Sort input array using Insertion Sort");
				
		for (int i = 1; i <= inputArray.length - 1 ; i++)
		{
			int j = i;
			int cur = inputArray[i];
			while (j > 0 && inputArray[j-1] > cur)
			{
				inputArray[j] = inputArray[j-1];
				j--;
			}
			inputArray[j] = cur;
		}
		
		System.out.printf("Sorted input array after ***Insertion Sort*** : %s", Arrays.toString(inputArray));
	}

}
