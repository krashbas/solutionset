package solutions;

/**
 * This class implements a solution to test if a given input string has unique characters
 * @author rakuma
 *
 */

public class UniqueCharsInString {
	/**
	 * Input string to test for unique characters
	 */
	public String inputString = "";
	
	public UniqueCharsInString(String iString)
	{
		this.inputString = iString;
	}
	
	/**
	 * Test if there are unique characters in the input string using an array of boolean values
	 * @return
	 */
	public Boolean Run()
	{
		Boolean[] charsPresent = new Boolean[256];
		if (inputString.length() > 256)
		{
			System.out.println("Invalid string");
			return false;
		}
		
		for (int index = 0; index < inputString.length(); index++)
		{
			int value = inputString.charAt(index);
			if (charsPresent[value] != null && charsPresent[value])
			{
				return false;
			}
			charsPresent[value] = true;
		}
		return true;
	}
	
	/**
	 * Check if string has unique characters using a single integer.
	 * @return
	 */
	public Boolean Run1()
	{
		int charsCheck = 0;
		
		for (int index = 0; index < inputString.length(); index++)
		{
			int charsValue = inputString.charAt(index) - 'a'; // get the actual value
			
			if ((charsCheck & 1 << charsValue) > 0)	
			{
				return false;
			}
			charsCheck |= (1 << charsValue);
		}
		return true;
	}
}
