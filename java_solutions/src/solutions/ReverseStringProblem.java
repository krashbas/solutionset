package solutions;

/**
 * This class implements a solution to reverse a given char string without using inbuilt methods
 * @author rakuma
 *
 */
public class ReverseStringProblem {
	public String inputString;
	
	
	public ReverseStringProblem(String inputString)
	{
		this.inputString = inputString;
	}
	
	public String Run() throws Exception
	{
		char[] inputArray = inputString.toCharArray();
		
		for (int charIndex = 0; charIndex < inputArray.length/2; charIndex++)
		{
			swapCharsInArray(inputArray, charIndex, inputArray.length - charIndex - 1);
		}
		
		return new String(inputArray);
	}	
	
	private void swapCharsInArray(char[] iArray, int firstIndex, int secondIndex)
	{
		char temp = iArray[firstIndex];
		iArray[firstIndex] = iArray[secondIndex];
		iArray[secondIndex] = temp;
	}
}
