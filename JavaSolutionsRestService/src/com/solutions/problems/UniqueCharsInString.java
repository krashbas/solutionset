package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.utils.Utilities;

/**
 * This class implements a solution to test if a given input string has unique characters
 * @author rakuma
 *
 */

public class UniqueCharsInString extends IProblemSolutions { 
	/**
	 * Input string to test for unique characters
	 */
	protected String inputString = "";
	
	/**
	 * Default constructor
	 */
	public UniqueCharsInString()
	{
	
	}
	
	/**
	 * Constructor with input
	 * @param input
	 */
	public UniqueCharsInString(String iString)
	{
		this.inputString = iString;
	}
	
	@Override
	public void setInput(HashMap<String, String> input) {
		// TODO Auto-generated method stub
		for (Field f: getInputFields())
		{
			try
			{				  
				inputString = input.get(f.getName());			
			}
			catch (Exception ex)
			{}
		}
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input string to test with is %s\n", inputString);
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		System.out.printf("---------Method1: using an input boolean array---------\n");
		runMethod1();
		System.out.printf("---------Method1: without an additional buffer array---------\n");
		runMethod2();
	}
	
	/**
	 * Test if there are unique characters in the input string using an array of boolean values
	 * @return
	 */
	public void runMethod1()
	{
		Boolean[] charsPresent = new Boolean[256];
		boolean result = true;
		
		if (inputString.length() > 256)
		{
			System.out.println("Invalid string");
			result = false;
		}
		
		for (int index = 0; index < inputString.length(); index++)
		{
			int value = inputString.charAt(index);
			if (charsPresent[value] != null && charsPresent[value])
			{
				result = false;
			}
			charsPresent[value] = true;
		}
		
		String resultString = (result)?"unique":"not unique";
		System.out.printf("UniqueCharsInString: The given input string %s is %s\n", inputString, resultString);
	}
	
	/**
	 * Check if string has unique characters using a single integer.
	 * @return
	 */
	public void runMethod2()
	{
		int charsCheck = 0;
		boolean result = true;
		for (int index = 0; index < inputString.length(); index++)
		{
			int charsValue = inputString.charAt(index) - 'a'; // get the actual value
			
			if ((charsCheck & 1 << charsValue) > 0)	
			{
				result = false;
			}
			charsCheck |= (1 << charsValue);
		}
		
		String resultString = (result)?"unique":"not unique";
		System.out.printf("UniqueCharsInString: The given input string %s is %s\n", inputString, resultString);
	}

	
	
}
