package com.solutions.helpers;

public class PersonHW implements Comparable<PersonHW> {
	int height;
	int weight;
	
	public PersonHW(int h, int w)
	{
		this.height = h;
		this.weight = w;
	}

	/**
	 * Compare to method to aid in sorting using height and then weight (if heights are equal)
	 */
	@Override
	public int compareTo(PersonHW o) {
		// TODO Auto-generated method stub
		if (this.height != o.height)
		{
			return new Integer(this.weight).compareTo(new Integer(o.weight));
		}
		else
		{
			return new Integer(this.height).compareTo(new Integer(o.height));
		}
	}
	
	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	/**
	 * Check if the current object comes before the input object
	 * @param p
	 * @return
	 */
	public boolean before(PersonHW p)
	{
		return (this.height < p.height && this.weight < p.weight);
	}
	
	
}
