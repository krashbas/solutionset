package solutions;

import utils.*;

public class PartitionListAroundXProblem {
	public LinkedListNode<Integer> CreateList(int[] data)
	{
		LinkedListNode<Integer> head = null;
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
		return head;
	}
	
	public void DisplayList (LinkedListNode<Integer> head)
	{	
		while (head != null)
		{
			System.out.printf("%d ", head.data);
			head = head.next;
		}
	}
	
	public LinkedListNode<Integer> Run(LinkedListNode<Integer> node, int x) {
		LinkedListNode<Integer> beforeStart = null;
		LinkedListNode<Integer> beforeEnd = null;
		LinkedListNode<Integer> afterStart = null;
		LinkedListNode<Integer> afterEnd = null;
		
		LinkedListNode<Integer> xNode = null;
		/* Partition list */
		while (node != null) {
			LinkedListNode<Integer> next = node.next;
			node.next = null;
			if (node.data < x) {
			 /* Insert node into end of before list */
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				 } 
				else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} 
			else if (node.data == x)
			{
				xNode = node;
			}
			else {
				/* Insert node into end of after list */
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} 
				else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		 }
		
		 if (beforeStart == null) {
			 xNode.next = afterStart;
			 return xNode;
		 }
		
		 /* Merge before list and after list */
		 beforeEnd.next = xNode;
		 xNode.next = afterStart;
		 return beforeStart;
	}
	
	public LinkedListNode<Integer> Run1(LinkedListNode<Integer> node, int x) {
		LinkedListNode<Integer> beforeStart = null;
		LinkedListNode<Integer> afterStart = null;
		
		LinkedListNode<Integer> xNode = null;
		/* Partition list */
		while (node != null) {
			LinkedListNode<Integer> next = node.next;
			node.next = null;
			if (node.data < x) {
			 /* Insert node into end of before list */
				node.next = beforeStart;
				beforeStart = node;
			} 
			else if (node.data == x)
			{
				xNode = node;
			}
			else {
				/* Insert node into end of after list */
				node.next = afterStart;
				afterStart = node;
			}
			node = next;
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
