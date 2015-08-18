package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.solutions.utils.MyGenericStack;
import com.solutions.utils.Utilities;

/**
 * Invert a given stack using recursion
 * @author rakuma
 *
 */
public class InvertStackProblem implements IProblemSolutions {
	
	/**
	 * Input array of numbers to initiate the stack with
	 */
	protected int[] inputArray;
	
	/**
	 * Default constructor
	 */
	public InvertStackProblem()
	{
		
	}
	
	@Override
	public void setInput(HashMap<String, String> input) {
		// TODO Auto-generated method stub
		for (Field f: getInputFields())
		{
			try
			{
				String iArray =  input.get(f.getName());
				inputArray = Arrays.stream(iArray.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();				
			}
			catch (Exception ex)
			{}
		}
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Given input array of numbers to use: %s\n" , Arrays.toString(inputArray));
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		MyGenericStack<Integer> numStack = new MyGenericStack<Integer>();
		for (int i: inputArray)
		{
			numStack.push(i);
		}
		
		System.out.println("Original stack: ");
		numStack.Display();
		
		ReverseStack(numStack);
		
		System.out.println("Inverted stack: ");
		numStack.Display();
	}

	/**
	 * Get all the fields in class with protected modifier
	 * @return
	 */
	public ArrayList<Field> getInputFields()
	{
		return Utilities.getProtectedFields(this.getClass());
	}
	
	/**
	 * Helper function to insert a value at the bottom of a stack using recursion
	 * @param s
	 * @param data
	 */
	private void InsertAtBottom(MyGenericStack<Integer> s, int data)
	{
		if (s.Empty())
		{
			s.push(data);
		}
		else
		{
			int temp = s.pop();
			InsertAtBottom(s, data);
			
			s.push(temp);
		}
	}
	
	/** 
	 * Recursive function to reverse given stack in place
	 * @param s
	 */
	private void ReverseStack(MyGenericStack<Integer> s)
	{
		if (!s.Empty())
		{
			int top = s.pop();
			ReverseStack(s);
			
			InsertAtBottom(s, top);
		}
		return;
	}
	
}
