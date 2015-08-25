package com.solutions.services;

import java.util.HashMap;
import java.util.List;

import com.solutions.problems.IProblemSolutions;
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
		List<String> allProblems = Utilities.getStringListExtendingClass(IProblemSolutions.class, IProblemSolutions.class.getPackage().getName());
		int idIndex = 0;
		for (String p: allProblems)
		{
			ProblemsInfo pi = new ProblemsInfo(idIndex, p);
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
