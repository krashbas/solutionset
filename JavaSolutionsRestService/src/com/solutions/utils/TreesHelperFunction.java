package com.solutions.utils;

public class TreesHelperFunction {
	
	/**
	 * Create a Binray tree given Pre order and inorder traversals. 
	 * @param inorder
	 * @param preorder
	 * @param start
	 * @param end
	 * @return Root of binray tree
	 */
	static int preOrderIndex = 0;
	public static TreeNode createTreeFromArray(int[] inorder, int[] preorder, int start, int end)
	{
		if (start > end)
		{
			return null;
		}
		preOrderIndex = start;
		int data = preorder[preOrderIndex];
		preOrderIndex++;
		TreeNode newNode = new TreeNode(data);
		
		// find this data in inorder array
		int inOrderIndex = indexInArray(inorder, data);
		
		newNode.left = createTreeFromArray(inorder, preorder, start, inOrderIndex -1 );
		newNode.right = createTreeFromArray(inorder, preorder, inOrderIndex + 1, end);
		return newNode;
	}
	
	private static int indexInArray(int arr[], int data)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == data)
			{
				return i;
			}
		}
		return -1;
	}
}
