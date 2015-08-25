package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.solutions.utils.Utilities;

public abstract class IProblemSolutions {
	
	public void setInput(HashMap<String, String> input)
	{
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
				else if (f.getType() == Integer.TYPE)
				{
					f.set(this, Integer.parseInt(value));
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
	public abstract void displayInput();
	public abstract void run() throws Exception;
	
	
	final ArrayList<Field> getInputFields()
	{
		return Utilities.getProtectedFields(this.getClass());
	}

}
