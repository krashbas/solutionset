package solutions;

import java.util.HashMap;

public class RansomNoteProblem {
        
	public String magazine;
	public String ransomNote;
	
	public RansomNoteProblem(String magazine, String ransomNote)
	{
		this.magazine = magazine;
		this.ransomNote = ransomNote;
	}
	
	/**
	 * Check if the words in ransom note can be formed by the words in magazine                                                                              
	 * @return true or false
	 * @throws Exception
	 */
	public Boolean Run() throws Exception
	{
		
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
				return false;
			}
			else
			{
				currentCount -= 1;
				if (currentCount < 0)
				{
					System.out.printf("Not enough occurrences of word %s. Return failure\n", word);
					return false;
				}
				wordFrequency.put(word, currentCount);
			}
		}
		System.out.printf("Ransom Note \n---%s---\n can be formed from magazine: \n---%s---\n", ransomNote, magazine);
		return true;
	}
}
