package com.solutions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.utils.Utilities;

/**
 * This class implements a solution to finding all permutations of a given string.
 * @author rakuma
 *
 */
public class StringPermutationsProblem implements IProblemSolutions{

	protected String inputString = "";
	
	private ArrayList<String> permutationsList;
	
	public StringPermutationsProblem()
	{
		permutationsList = new ArrayList<String>();
	}
	/**
	 * Constructor
	 * @param input string
	 */
	public StringPermutationsProblem (String input)
	{
		inputString = input;
		permutationsList = new ArrayList<String>();
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
		System.out.printf("Input string with parenthesis is %s\n", inputString);
	}
	
	/**
	 * Solution without recursion
	 * @throws Exception
	 */
	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		System.out.printf("Method1: Without recursion");
		Run_No_Recursion();
		displayResult();
		System.out.printf("Method1: With recursion");
		Run_Recursion(inputString);
		displayResult();
	}
	
	/**
	 * Solution without recursion
	 */
	private void Run_No_Recursion()
	{
		for (int charIndex = 0; charIndex < inputString.length(); charIndex++)
		{
			char c = inputString.charAt(charIndex);
			if (permutationsList.size() == 0)
			{
				permutationsList.add(Character.toString(c));				
			}
			else
			{
				ArrayList<String> tempList = new ArrayList<String>();
				for (String str: permutationsList)
				{
					tempList.addAll(InsertAtAllPositions(str, c));
				}
				permutationsList = tempList;
			}
		}
		
	}
	
	/**
	 * Solution with recursion
	 */
	public ArrayList<String> Run_Recursion(String permString) throws Exception
	{	
		ArrayList<String> tempList = new ArrayList<String>();
		if (permString.length() == 1)
		{
			permutationsList.add(permString);
		}
		else
		{
			char firstChar = permString.charAt(0);
			String restOfString = permString.substring(1);
			for (String newString: Run_Recursion(restOfString))
			{
				tempList = InsertAtAllPositions(newString, firstChar);
			}			
		}
		permutationsList = tempList;
		return tempList;
	}
	
	/**
	 * Helper method to insert the char at all locations in string to generate combinations
	 * @param string
	 * @param c
	 * @return
	 */
	private ArrayList<String> InsertAtAllPositions(String string, char c)
	{
		ArrayList<String> tempList = new ArrayList<String>();
		int strLength = string.length();
		for(int strIndex = 0; strIndex < strLength+1; strIndex++)
		{
			String newStr = string.substring(0, strIndex) + c + string.substring(strIndex);
			tempList.add(newStr);
		}
		return tempList;
	}
	
	/**
	 * Display all permutations of this string
	 */
	private void displayResult()
	{
		System.out.println("Given input string: " + inputString);
		for (String str:permutationsList)
		{
			System.out.printf("%s, ", str);
		}
		System.out.println("\nNumber of permutations: " + permutationsList.size());
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
