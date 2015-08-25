package com.solutions.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

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
	
	public static ArrayList<String> getStringListExtendingClass(Class<?> baseClass, String packageName)
	{
		ArrayList<Class<?>> listClasses = getClassesExtendingClass(baseClass, packageName);
		ArrayList<String> listClassNames = new ArrayList<String>();
		listClasses.forEach((c) -> {
			listClassNames.add(c.getSimpleName());
		});
		
		return listClassNames;
	}
	
	public static ArrayList<Class<?>> getClassesExtendingClass (Class<?> baseClass, String packageName)
	{
		ArrayList<Class<?>> listClasses = new ArrayList<Class<?>>();
		
		ArrayList<Class<?>> allClasses = getAllClasses(packageName);
		
		for (Class<?> aClass: allClasses)
		{
			if (aClass.equals(baseClass))
			{
				continue;
			}
			
			if (baseClass.isAssignableFrom(aClass))
			{
				listClasses.add(aClass);
			}
		}
		
		return listClasses;
		
	}
	
	public static ArrayList<Class<?>> getAllClasses(String packageName)
	{
		ArrayList<Class<?>> allClasses = new ArrayList<Class<?>>();
		
//		if (!packageName.startsWith("/"))
//		{
//			packageName = "/" + packageName;
//		}
		String packagePath = packageName.replace('.', '/');
		
		try
		{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> allResources = cl.getResources(packagePath);
		
		while (allResources.hasMoreElements())
		{
			URL resource = allResources.nextElement();
			
			String dirName = resource.getFile();
			
			allClasses.addAll(getAllClassesInDir(new File(dirName), packageName));
		}
		}
		catch (IOException ex)
		{}
		
		return allClasses;
	}

	/**
	 * Recursively get all classes in a dirname and its subdirectories
	 * @param dirName
	 * @return
	 */
	public static ArrayList<Class<?>> getAllClassesInDir(File dirName, String packageName) 
	{
		ArrayList<Class<?>> allClassInDir = new ArrayList<Class<?>>();
		
		try
		{
		for (File file: dirName.listFiles())
		{
			if (file.isDirectory())
			{
				allClassInDir.addAll(getAllClassesInDir(file, packageName));
			}
			else if (file.getName().endsWith(".class"))
			{ // only add class files
				Class<?> fileClass = Class.forName(packageName + "." + file.getName().replaceAll(".class", ""));
				allClassInDir.add(fileClass);
			}
		}
		}
		catch (ClassNotFoundException ex)
		{}
		return allClassInDir;
	}
}
