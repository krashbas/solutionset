package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.utils.Utilities;

public class RansomNoteProblem implements IProblemSolutions {
        
	protected String magazine;
	protected String ransomNote;
	
	/**
	 * Default constructor 
	 */
	public RansomNoteProblem()
	{
		
	}
	
	/**
	 * Constructor With arguments
	 * @param magazine
	 * @param ransomNote
	 */
	public RansomNoteProblem(String magazine, String ransomNote)
	{
		this.magazine = magazine;
		this.ransomNote = ransomNote;
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
		System.out.printf("Input magazine content: %s\n", magazine);
		System.out.printf("Input ransom note: %s\n", ransomNote);
	}

	/**
	 * Check if the words in ransom note can be formed by the words in magazine                                                                              
	 * @return true or false
	 * @throws Exception
	 */
	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		boolean result = false;
		
		HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
		// traverse through the magazine and keep track of words
		for (String word:magazine.split(" "))
		{
			Integer currentCount = wordFrequency.get(word); 
			if (currentCount == null)
			{
				currentCount = 1;
			}
			else
			{
				currentCount += 1;
			}
			wordFrequency.put(word, currentCount);
		}
		
		// traverse through the given ransom note and compare occurrences with the given magazine
		
		for (String word: ransomNote.split(" "))
		{
			Integer currentCount = wordFrequency.get(word);
			
			if (currentCount == null)
			{
				System.out.printf("Word %s not found in magazine. Return failure\n", word);
				result = false;
			}
			else
			{
				currentCount -= 1;
				if (currentCount < 0)
				{
					System.out.printf("Not enough occurrences of word %s. Return failure\n", word);
					result = false;
				}
				wordFrequency.put(word, currentCount);
			}
		}
		
		result = true;
		String resultString = (result)?"can":"cannot";
		System.out.printf("RansomNoteProblem: Ransom note --\"%s\"-- %s be formed from magazine --\"%s\"--\n", ransomNote, resultString, magazine);
	}

	/**
	 * Get all the fields in class with protected modifier
	 * @return
	 */
	public ArrayList<Field> getInputFields()
	{
		return Utilities.getProtectedFields(this.getClass());
	}
}