package com.solutions.problems;

import com.solutions.utils.ProblemDescription;

@ProblemDescription (
		author = "RRR",
		description = "This class implements a solution to count number of zeroes in factorial.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class CountZeroesInFactorialProblem extends BaseProblemSolutions {
	
	protected int inputNumber = 0;
	protected String description = "Base class for all problem solutions";
	
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.println("Input number to use to calculate number of zeroes in its factorial is " + inputNumber);
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
				
		if (inputNumber < 0)
		{
			System.out.println("Invalid input " + inputNumber);
		}
		for (int i = 5; (inputNumber / i) > 0; i = i*5)
		{
			count += inputNumber/i;
		}
		
		System.out.printf("Factorial of %d = %d, Number of zeroes in factorial = %d\n", inputNumber, factorial(inputNumber), count);
	}
	
	private int factorial(int n)
	{
		if (n == 1)
		{
			return n;
		}
		else 
		{
			return n * factorial (n - 1);
		}
	}

}
