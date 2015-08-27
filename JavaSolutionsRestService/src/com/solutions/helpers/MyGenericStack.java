package com.solutions.helpers;

import java.util.ArrayList;
public class MyGenericStack<T> {
	ArrayList<T> myList;
	
	public MyGenericStack()
	{
		myList = new ArrayList<T>();
	}
	
	/**
	 * Get the size of the list
	 * @return Stack length
	 */
	public int Length()
	{
		return myList.size();
	}
	
	public Boolean Empty()
	{
		return (this.Length() == 0);
	}
	
	/**
	 * Push or insert element at the end of the stack
	 * @param element
	 */
	public void push(T element)
	{
		try
		{
			System.out.println("Insert " + element.toString() + " to stack");
			myList.add(element);
		}
		catch (Exception ex)
		{
			System.out.printf("Exception when inserting into stack: " + ex.getMessage());
		}
	}
	
	/**
	 * Get the last element in the stack
	 * @return last element
	 */
	public T pop()
	{
		try
		{
			T element = myList.remove(this.Length() - 1);
			System.out.println("Remove element " + element.toString() + " from stack");
			return element;
		}
		catch (Exception ex)
		{
			System.out.println("Exception when removing from stack: " + ex.getMessage());
		}
		return null;
	}
	
	/**
	 * Display all elements in stack
	 */
	public void Display()
	{
		for (T element: myList)
		{
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
