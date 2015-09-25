package com.solutions.services;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.problems.BaseProblemSolutions;
import com.solutions.utils.ProblemDescription;
import com.solutions.utils.Utilities;

/**
 * Data access object to access all the Solutions
 * @author rakuma
 *
 */
public enum ProblemsInfoDao {
	instance;
	
	private HashMap<Integer, ProblemsInfo> problemMap = new HashMap<Integer, ProblemsInfo>();

	private ProblemsInfoDao()
	{
		//Initialize the solution info map with the existing solutions. ID is just increasing sequence of numbers
		ArrayList<Class<?>> allProblems = Utilities.getClassesExtendingClass(BaseProblemSolutions.class, BaseProblemSolutions.class.getPackage().getName());
		int idIndex = 0;
		for (Class<?> p: allProblems)
		{
			String name = p.getSimpleName();
			String description = "";
			Annotation[] a = p.getAnnotations();
			if (p.isAnnotationPresent(ProblemDescription.class))
			{
				Annotation ae = p.getAnnotation(ProblemDescription.class);
				ProblemDescription pd = (ProblemDescription)ae;
				description = pd.description();
			}
			ProblemsInfo pi = new ProblemsInfo(idIndex, name, description);
			problemMap.put(idIndex++, pi);
		}
	}
	
	public  HashMap<Integer, ProblemsInfo> getSolutionMap() {
		return problemMap;
	}
	
	public int getProblemCount()
	{
		return problemMap.size();
	}
	

}
