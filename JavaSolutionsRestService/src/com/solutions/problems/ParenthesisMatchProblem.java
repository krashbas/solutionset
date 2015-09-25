package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.helpers.MyGenericStack;
import com.solutions.utils.ProblemDescription;
import com.solutions.utils.Utilities;

@ProblemDescription (
		author = "RRR",
		description = "This class implements solution to check if a given string with parenthesis is valid and also calculates the max distance between the { and }.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class ParenthesisMatchProblem extends BaseProblemSolutions {
	protected String inputString;
	
	/**
	 * Stack to save the indices of the braces as the input string is traversed to determine validity
	 */
	private MyGenericStack<Integer> indexStack;
	
	/**
	 * Default constructor
	 */
	public ParenthesisMatchProblem()
	{
		indexStack = new MyGenericStack<Integer>();
	}
	
	/**
	 * Constructor with input
	 * @param input
	 */
	public ParenthesisMatchProblem (String input)
	{
		this.inputString = input;
		indexStack = new MyGenericStack<Integer>();
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input string with parenthesis is %s\n", inputString);
	}

	
	
	/**
	 * Check if braces match. Also find the maximum distance 
	 * @return
	 * @throws Exception
	 */
	@Override	
	public void run() throws Exception {
		// TODO Auto-generated method stub
		boolean matchStatus = false;
		int stringIndex = 0;
		int maxDistanceBetweenBraces = 0;
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
						matchStatus = false;
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
			matchStatus = true;
		}
		matchStatus = false;
		
		String resultString = (matchStatus)?"valid":"invalid";
		System.out.printf("ParenthesisMatchProblem: Input parenthesis string %s is %s\n", inputString, resultString);
		System.out.printf("ParenthesisMatchProblem: Max distance between { and } in %s = %d\n", inputString, maxDistanceBetweenBraces);
	}

	
}
