package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.utils.ProblemDescription;
import com.solutions.utils.Utilities;

@ProblemDescription (
		author = "RRR",
		description = "This class implements a solution to reverse a given char string without using inbuilt methods.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class ReverseStringProblem extends BaseProblemSolutions{
	/**
	 * Input string to reverse
	 */
	protected String inputString;
	
	/**
	 * Default constructor
	 */
	public ReverseStringProblem()
	{
		
	}
	
	/**
	 * Constructor with arguments
	 * @param inputString
	 */
	public ReverseStringProblem(String inputString)
	{
		this.inputString = inputString;
	}
		
	@Override
	public void setInput(HashMap<String, String> input) {
		// TODO Auto-generated method stub
		for (Field f: getInputFields())
		{
			try
			{
				f.set(this, input.get(f.getName()));
			}
			catch (IllegalAccessException ex)
			{}
		}
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input string to reverse: %s\n", inputString);
	}

	/**
	 * Reverse string in place using a char array
	 */
	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		char[] inputArray = inputString.toCharArray();
		
		for (int charIndex = 0; charIndex < inputArray.length/2; charIndex++)
		{
			swapCharsInArray(inputArray, charIndex, inputArray.length - charIndex - 1);
		}
		
		String reversedString = new String(inputArray);
		
		System.out.printf("ReverseStringProblem: Original String: %s, Reversed String: %s\n", inputString, reversedString);
	}
	
	/** 
	 * Swap characters in given positions in array
	 * @param iArray
	 * @param firstIndex
	 * @param secondIndex
	 */
	private void swapCharsInArray(char[] iArray, int firstIndex, int secondIndex)
	{
		char temp = iArray[firstIndex];
		iArray[firstIndex] = iArray[secondIndex];
		iArray[secondIndex] = temp;
	}
	
	
}
