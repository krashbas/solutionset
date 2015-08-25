package com.solutions.problems;

import java.util.Arrays;

public class MergeSortProblem extends IProblemSolutions {
	
	protected int[] inputArray;
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input unsorted array is: %s\n", Arrays.toString(inputArray));
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Sort input array using mergesort");
		
		int[] tempArray = new int[inputArray.length];
		mergeSort(inputArray, tempArray, 0, inputArray.length -1);
		
		System.out.printf("Sorted input array after ***Merge Sort*** : %s\n", Arrays.toString(inputArray));
	}
	
	/**
	 * Recursive merge sort algorithm
	 * @param array
	 * @param tArray
	 * @param start
	 * @param end
	 */
	private void mergeSort(int[] array, int[] tArray, int start, int end)
	{
		if (end > start)
		{
			return;
		}
		int mid = (start+end)/2;
		mergeSort(array, tArray, start, mid);
		mergeSort(array, tArray, mid+1, end);
		merge(array, tArray, start, mid, end);	
	}
	
	/**
	 * Merge two halves of an array using a temp array
	 * @param array
	 * @param tarray
	 * @param start
	 * @param mid
	 * @param end
	 */
	private void merge(int[] array, int[] tarray, int start, int mid, int end)
	{
		for (int i = start; i <= end; i++)
		{
			tarray[i] = array[i];
		}
		
		int leftstart = start;
		int rightstart = mid+1;
		
		int cur = start;
		
		while (leftstart <= mid && rightstart <= end)
		{
			if (tarray[leftstart] < tarray[rightstart])
			{
				array[cur] = tarray[leftstart];
				leftstart++;
			}
			else
			{
				array[cur] = tarray[rightstart];
				rightstart++;
			}
			cur++;
		}
		
		while (leftstart <= mid)
		{
			array[cur++] = tarray[leftstart++];
		}
		
		// Right half is already in array, so don't need to copy it over again
	}

}
