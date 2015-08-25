package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

import com.solutions.utils.TreeNode;
import com.solutions.utils.TreesHelperFunction;

public class LeastCommonAncestorInBT extends IProblemSolutions {

	protected Integer[] inorderArray;
	protected Integer[] preorderArray;
	protected Integer inputNodeP;
	protected Integer inputNodeQ;
	
	private TreeNode<Integer> root = null;
	
	@Override
	public void setInput(HashMap<String, String> input)
	{
		for (Field f: getInputFields())
		{
			try
			{				
				String value =  input.get(f.getName());
				if (value != null)
				{
					if (f.getType().isArray())
					{
						f.set(this, Arrays.stream(value.split(",")).map(String::trim).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new ));
						System.out.println("");
					}
					else if (f.getType().isAssignableFrom(Integer.class))
					{						
						f.set(this, new Integer(value));
					}
				}
			}
			catch (Exception ex)
			{}
		}
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input Inorder array: %s\n", Arrays.toString(inorderArray));
		System.out.printf("Input Preorder array: %s\n", Arrays.toString(preorderArray));
		System.out.printf("Find Least Common Ancestor of %d and %d\n", inputNodeP, inputNodeQ);
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub		
		initTree(); 
		if (!(TreesHelperFunction.isPresentInTree(root, inputNodeP) && TreesHelperFunction.isPresentInTree(root, inputNodeQ)))
		{
			System.out.printf("There is no common ancestor for the given nodes %d and %d", inputNodeP, inputNodeQ);
			return;
		}
		
		TreeNode<Integer> p = TreesHelperFunction.getNodeInTree(root, inputNodeP);
		TreeNode<Integer> q = TreesHelperFunction.getNodeInTree(root, inputNodeQ);
		
		TreeNode<Integer> lca = findLeastCommonAncestor(root, p, q);	
		System.out.println("--------P node--------");
		TreesHelperFunction.displayTreeNode(p);
		System.out.println("---------Q node-------");
		TreesHelperFunction.displayTreeNode(q);
		System.out.println("-------LCA node-------");
		TreesHelperFunction.displayTreeNode(lca);
	}
	
	private TreeNode<Integer> findLeastCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q)
	{
		if (root == null)
		{
			return null;
		}
				
		if (root == p && root == q)
		{
			return root;
		}
		
		TreeNode<Integer> l = findLeastCommonAncestor(root.left, p, q);
		TreeNode<Integer> r = findLeastCommonAncestor(root.right, p, q);
			
		if (l != null)
		{
			System.out.println("l is " + l.data);
		}
		
		if (r!= null)
		{
			System.out.println("r is " + r.data);
		}
		
		if (l != null && l != p && l != q)	
		{ // Found a LCD in left subtree that is not one of the input nodes, return this
			return l;
		}
		if (r != null && r != p && r != q)
		{ // Found a LCD in right subtree that is not one of the input nodes, return this
			return r;
		}
		
		if (l != null && r != null)
		{ // l and r are in separate subtrees, return root of that subtree
			return root;
		}
		else if (root == p || root == q)
		{ // root is one of the inputs, return that as the LCA
			return root;
		}
		else
		{
			System.out.println("return l or r that is not null");
			return (l == null)? r: l;
		}
		
	}
	
	/**
	 * Initialize the tree using the given inorder and pre order arrays
	 */
	private void initTree()
	{
		root = TreesHelperFunction.createTreeFromArray(inorderArray, preorderArray, 0, inorderArray.length-1);
		TreesHelperFunction.displayTree(root);
	}

	

}
