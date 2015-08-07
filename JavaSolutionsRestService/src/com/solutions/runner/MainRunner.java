package com.solutions.runner;

import java.util.Set;

import org.reflections.Reflections;

import com.solutions.IProblemSolutions;

public class MainRunner {
	
	public static void main(String[] args) {
		
		try
		{	
			Reflections reflections = new Reflections("com.solutions");
			Set<Class<? extends IProblemSolutions>> allSolutions = reflections.getSubTypesOf(IProblemSolutions.class);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	
	}
}
