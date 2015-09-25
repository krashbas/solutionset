package com.solutions.problems;

import java.util.Arrays;

import com.solutions.utils.ProblemDescription;

@ProblemDescription (
		author = "RRR",
		description = "This class implements a solution to selection sort problem.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class SelectionSortProblem extends BaseProblemSolutions {

	protected int[] inputArray;
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Unsorted input array: %s\n", Arrays.toString(inputArray));
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Sort input array using Selection sort");
		
		for (int i = 0; i < inputArray.length; i++)
		{
			int min = i;
			for (int j = i+1; j < inputArray.length; j++)
			{
				if (inputArray[j] < inputArray[min])
				{
					min = j;
				}
			}
			int temp = inputArray[i];
			inputArray[i] = inputArray[min];
			inputArray[min] = temp;
		}
		
		System.out.printf("Sorted input array after ***Selection Sort***: %s", Arrays.toString(inputArray));
		
	}

}
