package com.solutions.problems;

import java.util.Arrays;

import com.solutions.utils.ProblemDescription;
@ProblemDescription (
		author = "RRR",
		description = "This class implements a solution to the quick sort.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class QuickSortProblem extends BaseProblemSolutions {

	protected int[] inputArray;
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input unsorted array is: %s\n", Arrays.toString(inputArray));
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Sort input array using quick sort");
		
		quickSort(inputArray, 0, inputArray.length-1);
		
		System.out.printf("Sorted input array using ***Quick Sort***: %s\n", Arrays.toString(inputArray));
	}
	
	/**
	 * Recursive quick sort algorithm
	 * @param array
	 * @param start
	 * @param end
	 */
	private void quickSort(int[] array, int start, int end)
	{
		int p = partition(array, start, end);
		
		System.out.printf("Partition index: %d, Partially Sorted input array using ***Quick Sort***: %s\n", p, Arrays.toString(inputArray));
		if (start < p-1)
		{
			quickSort(array, start, p-1);
		}
		
		if (p < end)
		{
			quickSort(array,p, end);
		}
	}
	
	/**
	 * Find partition for quick sort
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	private int partition(int[] array, int start, int end)
	{
		int mid = (start+end)/2;
		int pivotValue = array[mid];
		
		while (start <= end)
		{
			//Find a element on left of pivot that should be on its right (coz it is larger than pivot)
			while (array[start] < pivotValue)
				start++;
			
			// Find a element on right of pivot that should be on its left (coz it is smaller than pivot)
			while (array[end] > pivotValue)
				end--;
			
			if (start <= end)
			{
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}	
		}
		return start;		
	}
	

}
