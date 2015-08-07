package com.solutions;

import com.solutions.utils.*;

public class PartitionListAroundXProblem {
	
	LinkedListNode<Integer> head = null;
	
	public int partitionIndex = 0;
	
	public void createList(int[] data)
	{
		head = null;
		LinkedListNode<Integer> last = null;
		for (int d: data)
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
	
	public void displayInput()
	{
		System.out.printf("Input Linked list: ");
		displayList(head);
		System.out.println("Parition list around " + partitionIndex);
	}
	
	public void displayList (LinkedListNode<Integer> node)
	{	
		while (node != null)
		{
			System.out.printf("%d ", node.data);
			node = node.next;
		}
		System.out.println();
	}
	
	public void run() throws Exception {		
		System.out.println("-------METHOD 1-----------");
		runMethod1();
		System.out.println("-------METHOD 2-----------");
		runMethod2();
	}
	
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
