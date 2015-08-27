package com.solutions.helpers;

public class TreesHelperFunction {
	
	/**
	 * Create a Binary tree given Pre order and inorder traversals. 
	 * @param inorder
	 * @param preorder
	 * @param start
	 * @param end
	 * @return Root of binray tree
	 */
	static int preOrderIndex = 0;
	public static <T> TreeNode<T> createTreeFromArray(T[] inorder, T[] preorder, int start, int end)
	{
		if (start > end)
		{
			return null;
		}
		
		T data = preorder[preOrderIndex];
		preOrderIndex++;
		TreeNode<T> newNode = new TreeNode<T>(data);
		
		// find this data in inorder array
		int inOrderIndex = indexInArray(inorder, data);
		
		newNode.left = createTreeFromArray(inorder, preorder, start, inOrderIndex -1 );
		newNode.right = createTreeFromArray(inorder, preorder, inOrderIndex + 1, end);
		return newNode;
	}
	
	public static <T> void displayTree(TreeNode<T> root)
	{
		System.out.print("In-order traversal: ");
		displayTreeInorder(root);
		System.out.println();
		
		System.out.print("Pre-order traversal: ");
		displayTreePreorder(root);
		System.out.println();
		
		System.out.print("Inorder traversal: ");
		displayTreePostorder(root);
		System.out.println();
	}
	
	/**
	 * Display tree using inorder traversal
	 * @param <T>
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	public static <T> void displayTreeInorder(TreeNode<T> root)
	{
		if (root == null)
		{			
			return;
		}
		displayTreeInorder(root.left);
		System.out.print(root.data + " ");
		displayTreeInorder(root.right);
	}
	
	/**
	 * Display tree using pre order traversal
	 * @param <T>
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	public static <T> void displayTreePreorder(TreeNode<T> root)
	{
		if (root == null)
		{
			return;
		}
		System.out.print(root.data + " ");
		displayTreePreorder(root.left);		
		displayTreePreorder(root.right);
	}
	
	/**
	 * Display tree using post-order traversal
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	public static <T> void displayTreePostorder(TreeNode<T> root)
	{
		if (root == null)
		{
			return;
		}
		
		displayTreePostorder(root.left);		
		displayTreePostorder(root.right);
		System.out.print(root.data + " ");
	}
	
	/**
	 * Display data at current node & data at its left and right nodes
	 * @param n
	 */
	public static<T> void displayTreeNode(TreeNode<T> n)
	{
		if (n == null)
		{
			return;
		}
		System.out.println("Current node: " + n.data);
		if (n.left != null)
			System.out.println("Left node " + n.left.data);
		if (n.right != null)
			System.out.println("Current node: " + n.right.data);
	}
	
	/**
	 * Check if given data is present in the tree. Return the first match
	 * @param root
	 * @param data
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> boolean isPresentInTree(TreeNode<T> root, T data)
	{
		if (root == null)
		{
			return false;			
		}
		
		if (root.data.equals(data))
		{
			return true;
		}
		return (isPresentInTree(root.left, data) || isPresentInTree(root.right, data));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> TreeNode<T> getNodeInTree(TreeNode<T> root, T data)
	{
		if (root == null)
		{
			return null;
		}
		
		if (root.data.equals(data))
		{
			return root;
		}
		
		TreeNode<T> inLeft = getNodeInTree(root.left, data);
		if (inLeft != null)
		{
			return inLeft;
		}
		return getNodeInTree(root.right, data);		
	}
	
	/**
	 * Display tree using post order traversal
	 * @param <T>
	 * @param arr
	 * @param data
	 * @return
	 */
	private static <T> int indexInArray(T arr[], T data)
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
