package com.solutions;

import com.solutions.utils.MyGenericStack;

/**
 * This class implements solution to check if a given string with parenthesis is valid and also calculates the max distance between the { and }. 
 * @author rakuma
 *
 */
public class ParenthesisMatchProblem {
	public String inputString;
	
	/**
	 * Stack to save the indices of the braces as the input string is traversed to determine validity
	 */
	private MyGenericStack<Integer> indexStack; 
	public int maxDistanceBetweenBraces;
	
	public ParenthesisMatchProblem (String input)
	{
		this.inputString = input;
		indexStack = new MyGenericStack<Integer>();
	}
	
	/**
	 * Check if braces match. Also find the maximum distance 
	 * @return
	 * @throws Exception
	 */
	public Boolean Run () throws Exception
	{
		int stringIndex = 0;
		maxDistanceBetweenBraces = 0;
		while (stringIndex < inputString.length())
		{
			char c = inputString.charAt(stringIndex);
			switch (c)
			{
				case '{':
					indexStack.push(stringIndex);
					break;
				case '}':
					Integer lastIndex = indexStack.pop();
					if (lastIndex == null)
					{
						// Failed to pop from stack, the string is not matched
						maxDistanceBetweenBraces = 0;
						return false;
					}
					int distanceBetweenBraces = stringIndex - lastIndex;
					if (distanceBetweenBraces > maxDistanceBetweenBraces)
					{
						maxDistanceBetweenBraces = distanceBetweenBraces;
					}
					break;
				default:
					throw new Exception("Unknown character in the string");
			}
			stringIndex++;
		}
		if (indexStack.Empty())
		{
			return true;
		}
		return false;
	}

}
