package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.solutions.utils.Box;

public class CreateStackOfBoxes extends IProblemSolutions {

	/**
	 * Box dimentions in format w1,d1,h1|w2,d2,h2|w3,d3,h3...
	 */
	protected String boxDimensions;
	
	private Box[] boxes;
	
	@Override
	public void setInput(HashMap<String, String> input) {
		// TODO Auto-generated method stub
		for (Field f: getInputFields())
		{
			try
			{				
				String value =  input.get(f.getName());
				f.set(this, value);
			}
			catch(Exception ex)
			{ }
		}
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.println("Input Box dimensions are: " + this.boxDimensions);
	}
	
	
	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		createBoxes();
		displayBoxes();
		
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		HashMap<Box, ArrayList<Box>> boxMap = new HashMap<Box, ArrayList<Box>>();
		for (int i = 0; i < boxes.length; i++)
		{	
			System.out.println("Consider box # " + i);
			ArrayList<Box> new_stack = createStack (boxes, boxes[i], boxMap);
			int new_height = calculateHeight(new_stack);
			if(new_height > max_height)
			{
				max_stack = new_stack;
				max_height = new_height;
				System.out.println("Max height is: " + max_height);
			}
		}
		
		System.out.println("Max stacks with the input boxes are : ");
		for (Box b: max_stack)
		{
			b.displayBox();
		}
		
		System.out.println("Max height of box: " + max_height);
	}
	
	private void createBoxes()
	{	
		String[] boxDimentionsArray = boxDimensions.split("#");
		
		boxes = new Box[boxDimentionsArray.length];
		
		int i = 0;
		for (String boxString: boxDimentionsArray)
		{
			String[] d = boxString.split(",");
			if (d.length == 3)
			{
				Box b = new Box(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
				boxes[i++] = b;
			}
		}
	}
	
	private void displayBoxes()
	{
		System.out.println("Boxes are: ");
		for(int i = 0; i < boxes.length; i++)
		{
			System.out.printf("Box # %d: ", i);
			boxes[i].displayBox();
		}
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Box> createStack(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> boxMap)
	{
		if (bottom != null && boxMap.containsKey(bottom))
		{
			return boxMap.get(bottom);
		}
		
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		
		for (int i = 0; i < boxes.length; i++)
		{
			System.out.println("bottom is " + bottom.getHeight() + " " + bottom.getDepth() + " " + bottom.getWidth());
			System.out.println("Current box " + boxes[i].getHeight() + " " + boxes[i].getDepth() + " " + boxes[i].getWidth());
			if (boxes[i].canBeAbove(bottom))
			{
				System.out.println("this box can be above current bottom");
				ArrayList<Box> new_stack = createStack(boxes, boxes[i], boxMap);
				int new_height = calculateHeight(new_stack);
				if (new_height > max_height)
				{
					max_height = new_height;
					max_stack = new_stack;
				}
			}
		}
		if (max_stack == null)
		{
			max_stack = new ArrayList<Box>();
		}
		
		if (bottom != null)
		{
			System.out.println("bottom is " + bottom.getHeight() + " " + bottom.getDepth() + " " + bottom.getWidth());
			max_stack.add(0, bottom);
		}
		
		boxMap.put(bottom, max_stack);
		
		return (ArrayList<Box>)max_stack.clone(); // need to send a copy so that fugure changes to max_stack doesn't affect this
	}
	
	private int calculateHeight(ArrayList<Box> stack)
	{
		int height = 0;
		for (Box b: stack)
		{
			height += b.getHeight();
		}
		
		return height;
	}

}
