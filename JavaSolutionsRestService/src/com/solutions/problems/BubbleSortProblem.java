package com.solutions.problems;

import java.util.Arrays;

import com.solutions.utils.ProblemDescription;

@ProblemDescription (
		author = "RRR",
		description = "This class implements the bubble sort algorithm.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class BubbleSortProblem extends BaseProblemSolutions {

	protected int[] inputArray;
	protected String description = "Base class for all problem solutions";
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input unsorted array is: %s\n", Arrays.toString(inputArray));
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Sort input array using bubble sort");
		
		//Bubble sort loop
		for (int i = inputArray.length - 1; i >= 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (inputArray[j] > inputArray[j+1])
				{ // swap the two
					int temp = inputArray[j];
					inputArray[j] = inputArray[j+1];
					inputArray[j+1] = temp;
				}
			}
		}
		
		System.out.printf("Sorted input array after ***Bubble Sort*** : %s", Arrays.toString(inputArray));
	}

}
