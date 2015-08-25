package com.solutions.utils;

public class Box {
	int width;
	int height;
	int depth;
	
	public Box(int h, int d, int w)
	{
		this.height = h;
		this.width = w;
		this.depth = d;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Test if current box can be above input box
	 * @param b
	 * @return
	 */
	public boolean canBeAbove(Box b)
	{
		if (b.getHeight() > this.height &&
				b.getDepth() > this.depth &&
				b.getWidth() > this.width)
		{
			return true;
		}
		return false;
	}
	
	public void displayBox()
	{
		System.out.printf("Height: %d, Width: %d, Depth: %d\n", height, width, depth);
	}
	
}
