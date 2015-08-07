package com.solutions;

/**
 * This class implements a solution to check if two given strings are permutations of each other. Questions to ask: String is ASCII or Uicode, is it case sensitive, and significance of spaces
 * @author rakuma
 *
 */
public class StringAnagramProblem {
	private String firstString;
	private String secondString;
	
	public StringAnagramProblem(String first, String second)
	{
		this.firstString = first;
		this.secondString = second;
	}
	
	public Boolean Run ()
	{
		if (firstString.length() != secondString.length())
		{
			System.out.println("Two strings are not of same length");
			return false;
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
				return false;
			}			
		}
		
		return true;
	}
	
	
	
}
