package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LeastCommonAncestorInBT implements IProblemSolutions {

	protected int[] inorderArray;
	protected int[] preorderArray;
	protected int inputNode;
	
	@Override
	public void setInput(HashMap<String, String> input) {
		// TODO Auto-generated method stub
		for (Field f: getInputFields())
		{
			try
			{				
				String value =  input.get(f.getName());
				if (f.getType().isArray())
				{
					f.set(this, Arrays.stream(value.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray());
				}
				else
				{
					f.set(this, value);
				}
			}
			catch (Exception ex)
			{}
		}
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input Inorder array: %s", Arrays.toString(inorderArray));
		System.out.printf("Input Preorder array: %s", Arrays.toString(preorderArray));
		System.out.printf("Input element to find LCF of %d", inputNode);
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Field> getInputFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
