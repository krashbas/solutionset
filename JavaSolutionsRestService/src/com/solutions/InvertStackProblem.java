package com.solutions;

import com.solutions.utils.MyGenericStack;

/**
 * Invert a given stack using recursion
 * @author rakuma
 *
 */
public class InvertStackProblem {
	
	void ReverseStack(MyGenericStack<Integer> s)
	{
		if (!s.Empty())
		{
			int top = s.pop();
			ReverseStack(s);
			
			InsertAtBottom(s, top);
		}
		return;
	}
	
	void InsertAtBottom(MyGenericStack<Integer> s, int data)
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
	
	public void Run() throws Exception
	{
		MyGenericStack<Integer> numStack = new MyGenericStack<Integer>();
		numStack.push(1);
		numStack.push(2);
		numStack.push(3);
		numStack.push(4);
		
		System.out.println("Original stack: ");
		numStack.Display();
		
		ReverseStack(numStack);
		
		System.out.println("Inverted stack: ");
		numStack.Display();
	}
	
}
