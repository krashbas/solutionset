package main;

import solutions.*;

public class MainProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/***********************************************CLOCK ANGLE PROBLEM************************************************************/
		String time = "2:30";
		try
		{
			System.out.println("##### CLOCK ANGLE PROBLEM #####");
			ClockAngleProblem cap = new ClockAngleProblem(time);
			int result = cap.Run();
			System.out.printf("ClockAngleProblem: Time between hour and minute hands for time %s = %d degrees\n", time, result);
		}
		catch (Exception ex)
		{
			System.out.printf("Failed to find the angle for time %s with error %s\n",time, ex);
		}
		/*****************************************************************************************************************************/
		
		/*********************************************** PARANTHESIS MATCH PROBLEM ************************************************************/
		String paranthesisString = "{{{}{}}}";
		try
		{
			System.out.println("##### PARANTHESIS MATCH PROBLEM #####");
			ParenthesisMatchProblem pmp = new ParenthesisMatchProblem(paranthesisString);
			Boolean result = pmp.Run();
			String resultString = (result)?"valid":"invalid";
			System.out.printf("ParenthesisMatchProblem: Input parenthesis string %s is %s\n", paranthesisString, resultString);
			System.out.printf("ParenthesisMatchProblem: Max distance between { and } in %s = %d\n", paranthesisString, pmp.maxDistanceBetweenBraces);
		}
		catch (Exception ex)
		{
			System.out.printf("Failed to find paranthesis match for %s with error %s\n",paranthesisString, ex);
		}
		/*****************************************************************************************************************************/
		
		/*********************************************** RANSOM NOTE PROBLEM ************************************************************/
		String ransomNote = "I need this";
		String magazine = "need this for my";
		try
		{
			System.out.println("##### RANSOM NOTE PROBLEM #####");
			RansomNoteProblem rnp = new RansomNoteProblem(magazine, ransomNote);
			Boolean result = rnp.Run();
			String resultString = (result)?"can":"cannot";
			System.out.printf("RansomNoteProblem: Ransom note --\"%s\"-- %s be formed from magazine --\"%s\"--\n", ransomNote, resultString, magazine);
		}
		catch (Exception ex)
		{
			System.out.printf("Failed to find if ransom note can be formed from magazine with error %s", ex);
		}
		/*****************************************************************************************************************************/
		
		/*********************************************** UNIQUE CHARS IN STRING PROBLEM ************************************************************/
		{
			String inputString = "ABCDEF_GHIJKLMNOPQRSTUVWXYZ";
			try
			{
				System.out.println("##### UNIQUE CHARS IN STRING PROBLEM #####");
				UniqueCharsInString ucs = new UniqueCharsInString(inputString);
				Boolean result = ucs.Run();
				String resultString = (result)?"unique":"not unique";
				System.out.printf("UniqueCharsInString: The given input string %s is %s\n", inputString, resultString);
				
				Boolean result1 = ucs.Run1();
				String resultString1 = (result1)?"unique":"not unique";
				System.out.printf("UniqueCharsInString (using single integer): The given input string %s is %s\n", inputString, resultString1);
			}
			catch (Exception ex)
			{
				System.out.printf("Failed to find the unique characters in string %s with exception %s\n",inputString, ex);
			}
		}
		/*****************************************************************************************************************************/
		
		/*********************************************** ALL PERMUTATIONS OF STRING ************************************************************/
		{
			String inputString = "abc";
			try
			{
				System.out.println("##### ALL PERMUTATIONS OF STRING #####");
				StringPermutationsProblem spp = new StringPermutationsProblem(inputString);
				spp.Run();
				System.out.println("StringPermutationsProblem: Non recursion");
				spp.DisplayResult();
				
				StringPermutationsProblem sppr = new StringPermutationsProblem(inputString);
				sppr.Run_Recursion(inputString);
				System.out.println("StringPermutationsProblem: Recursion");
				spp.DisplayResult();
			}
			catch (Exception ex)
			{
				System.out.printf("Failed to find all permutations of string %s with exception %s\n",inputString, ex);
			
			}
		}
		/*****************************************************************************************************************************/
		/*********************************************** REVERSE A STRING ************************************************************/
		{
			String inputString = "abc123f";
			try
			{
				System.out.println("##### REVERSE A STRING #####");
				ReverseStringProblem rsp = new ReverseStringProblem(inputString);
				String reversedString = rsp.Run();
				System.out.printf("ReverseStringProblem: Original String: %s, Reversed String: %s\n", inputString, reversedString);				
			}
			catch (Exception ex)
			{
				System.out.printf("Failed to reverse string %s with exception %s\n",inputString, ex);
			
			}
		}
		/*****************************************************************************************************************************/
		
		/*********************************************** COMPARE STRINGS  ************************************************************/
		{
			String firstString = "abc";
			String secondString = "bac";
			try
			{
				System.out.println("##### COMPARE STRINGS #####");
				StringAnagramProblem sap = new StringAnagramProblem(firstString, secondString);
				Boolean result = sap.Run();
				String resultString = (result)?"are":"are not";
				System.out.printf("StringAnagramProblem: The given string %s and %s %s anagrams.\n", firstString, secondString, resultString);		
			}
			catch (Exception ex)
			{
				System.out.printf("Failed to check if strings %s and %s are anagrams with exception %s\n",firstString, secondString, ex);
			
			}
		}
		/*****************************************************************************************************************************/
	}

}
