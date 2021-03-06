package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.solutions.helpers.LinkedListNode;
import com.solutions.utils.*;

@ProblemDescription (
		author = "RRR",
		description = "This class implements a solution to partition a list around an input index such that elements before this index and less than and elements after this index are greater than value at index.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class PartitionListAroundXProblem extends BaseProblemSolutions {
	
	/**
	 * Input array to use in list
	 */
	protected int[] inputArray;
	/**
	 * Index to partition the list around
	 */
	protected int partitionIndex = 0;
	
	
	private LinkedListNode<Integer> head = null;
	
	/**
	 * Create a list from the given input array
	 */
	public void createList()
	{
		head = null;
		LinkedListNode<Integer> last = null;
		for (int d: inputArray)
		{
			LinkedListNode<Integer> temp = new LinkedListNode<Integer>();
			temp.data = d;
			temp.next = null;
			if (head == null)
			{
				head = temp;
				last = head;
			}
			else
			{
				last.next = temp;
				last = temp;
			}
		}
	}

	/**
	 * Display all inputs
	 */
	public void displayInput()
	{
		System.out.printf("Input Linked list: ");
		displayList(head);
		System.out.println("Parition list around " + partitionIndex);
	}
	
		
	/**
	 * Solve the problem using 2 methods
	 */
	public void run() throws Exception {		
		System.out.println("-------METHOD 1-----------\n");
		runMethod1();
		System.out.println("-------METHOD 2-----------\n");
		runMethod2();
	}

	
	/**
	 * Display elements in list
	 * @param node
	 */
	private void displayList (LinkedListNode<Integer> node)
	{	
		while (node != null)
		{
			System.out.printf("%d ", node.data);
			node = node.next;
		}
		System.out.println();
	}

	/**
	 * Solve problem using 2 lists with 2 pointers per list.
	 * @throws Exception
	 */
	private void runMethod1() throws Exception {
		LinkedListNode<Integer> beforeStart = null;
		LinkedListNode<Integer> beforeEnd = null;
		LinkedListNode<Integer> afterStart = null;
		LinkedListNode<Integer> afterEnd = null;
		
		LinkedListNode<Integer> xNode = null;
		/* Partition list */
		while (head != null) {
			LinkedListNode<Integer> next = head.next;
			head.next = null;
			if (head.data < partitionIndex) {
			 /* Insert node into end of before list */
				if (beforeStart == null) {
					beforeStart = head;
					beforeEnd = beforeStart;
				 } 
				else {
					beforeEnd.next = head;
					beforeEnd = head;
				}
			} 
			else if (head.data == partitionIndex)
			{
				xNode = head;
			}
			else {
				/* Insert node into end of after list */
				if (afterStart == null) {
					afterStart = head;
					afterEnd = afterStart;
				} 
				else {
					afterEnd.next = head;
					afterEnd = head;
				}
			}
			head = next;
		 }
		
		 if (beforeStart == null) {
			 xNode.next = afterStart;
			 
			 displayList(xNode);
		 }
		
		 /* Merge before list and after list */
		 beforeEnd.next = xNode;
		 xNode.next = afterStart;
		 displayList(beforeStart);
	}
	
	/**
	 * Solve problem using 2 lists, 1 pointer each
	 * @return
	 */
	private LinkedListNode<Integer> runMethod2 () {
		LinkedListNode<Integer> beforeStart = null;
		LinkedListNode<Integer> afterStart = null;
		
		LinkedListNode<Integer> xNode = null;
		/* Partition list */
		while (head != null) {
			LinkedListNode<Integer> next = head.next;
			head.next = null;
			if (head.data < partitionIndex) {
			 /* Insert node into end of before list */
				head.next = beforeStart;
				beforeStart = head;
			} 
			else if (head.data == partitionIndex)
			{
				xNode = head;
			}
			else {
				/* Insert node into end of after list */
				head.next = afterStart;
				afterStart = head;
			}
			head = next;
		 }
		 
		 if (beforeStart == null) {
			 xNode.next = afterStart;
			 return xNode;
		 }
		 
		 LinkedListNode<Integer> beforeEnd = beforeStart;
		 
		 while (beforeEnd.next != null)
		 {
			 beforeEnd = beforeEnd.next;
		 }
		 /* Merge before list and after list */
		 beforeEnd.next = xNode;
		 xNode.next = afterStart;
		 return beforeStart;
	}
}
