package com.solutions.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Utilities {
	
	public static ArrayList<Field> getProtectedFields(Class<?> inputClass)
	{
		ArrayList<Field> retFields = new ArrayList<Field>();
	
		Field[] allFields = inputClass.getDeclaredFields();
		
		
		for (Field f: allFields)
		{
			if (Modifier.isProtected(f.getModifiers()))
				retFields.add(f);
		}
		return retFields;
	}

}
