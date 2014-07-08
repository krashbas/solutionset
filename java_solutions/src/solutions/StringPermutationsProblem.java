package solutions;

import java.util.ArrayList;

/**
 * This class implements a solution to finding all permutations of a given string.
 * @author rakuma
 *
 */
public class StringPermutationsProblem {

	public String inputString = "";	
	ArrayList<String> permutationsList;
	
	/**
	 * Constructor
	 * @param input string
	 */
	public StringPermutationsProblem (String input)
	{
		inputString = input;
		permutationsList = new ArrayList<String>();
	}
	
	/**
	 * Solution without recursion
	 * @throws Exception
	 */
	public void Run() throws Exception
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
	
	public void DisplayResult()
	{
		System.out.println("Given input string: " + inputString);
		for (String str:permutationsList)
		{
			System.out.printf("%s, ", str);
		}
		System.out.println("\nNumber of permutations: " + permutationsList.size());
	}
}
