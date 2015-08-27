package com.solutions.helpers;

/**
 * Generic tree data structure
 * @author rakuma
 *
 * @param <T>
 */
public class TreeNode<T> {
	public T data;
	public TreeNode left;
	public TreeNode right;
	
	TreeNode(T d)
	{
		this.data = d;
		this.left = null;
		this.right = null;
	}
}
