package com.solutions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.utils.Utilities;

/**
 * This class implements a solution to check if two given strings are permutations of each other. Questions to ask: String is ASCII or Uicode, is it case sensitive, and significance of spaces
 * @author rakuma
 *
 */
public class StringAnagramProblem implements IProblemSolutions {
	protected String firstString;
	protected String secondString;

	/**
	 * Default constructor
	 */
	public StringAnagramProblem()
	{
	
	}
	
	/**
	 * Constructor with arguments
	 * @param first
	 * @param second
	 */
	public StringAnagramProblem(String first, String second)
	{
		this.firstString = first;
		this.secondString = second;
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
		System.out.printf("First input string: %s\n", firstString);
		System.out.printf("Second input string: %s\n", secondString);
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		
		if (firstString.length() != secondString.length())
		{
			System.out.println("Two strings are not of same length");
			result = false;
		}
		
		int[] charsCount = new int[256];
		
		char[] firstCharArray = firstString.toCharArray();
		
		for (char ch: firstCharArray)
		{
			charsCount[ch]++; // Java: default int value is 0
		}
		
		char[] secondCharArray = secondString.toCharArray();
		
		for (char ch: secondCharArray)
		{
			if (--charsCount[ch] < 0)
			{
				System.out.println("Found non matching characters");
				result = false;
			}			
		}
		
		result = true;
		String resultString = (result)?"are":"are not";
		System.out.printf("StringAnagramProblem: The given string %s and %s %s anagrams.\n", firstString, secondString, resultString);		
	}
	
	/**
	 * Get all the fields in class with protected modifier
	 * @return
	 */
	private ArrayList<Field> getInputFields()
	{
		return Utilities.getProtectedFields(this.getClass());
	}
	
}
