package com.solutions.problems;

import java.util.ArrayList;
import java.util.Collections;

import com.solutions.helpers.PersonHW;
import com.solutions.utils.ProblemDescription;

@ProblemDescription (
		author = "RRR",
		description = "This class implements solution to increasing pairs problem to find a way to stack people on atop another such that each person above is smaller in height and weight than the person below.",
		revision = "1.0",
		lastModifiedDate = "9/25/2015"
	)
public class IncreasingSequencePairsProblem extends BaseProblemSolutions {
	/**
	 * String in format n1,m1#n2,m2,n3,m4....
	 * Will be parsed into an ArrayList<Pairs> where pairs class has n and m variables
	 */
	protected String numberPairsString;
		
	private ArrayList<PersonHW> array = null;

	protected String description = "Base class for all problem solutions";
	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.printf("Input number pairs is %s\n", numberPairsString);		
	}

	@Override
	public void run() throws Exception {
		// TODO Auto-generated method stub
		generatePersonHWObjects();
		displayHWPairs(array);
		
		Collections.sort(array);
		ArrayList<PersonHW> solutions[] = new ArrayList[array.size()];
		findLongestSequence(array, solutions, 0);
		
		ArrayList<PersonHW> best_seq = null;
		for (int i = 0; i < array.size(); i++)
		{
			best_seq = seqWithMaxLength(best_seq, solutions[i]);
		}
		
		System.out.println("Best sequence of persons is:");
		displayHWPairs(best_seq);
		
	}
	
	/**
	 * Recursively find the longest sequence possible with the given input ht wt pairs
	 * @param input
	 * @param solutions
	 * @param index
	 */
	ArrayList<PersonHW> findLongestSequence(ArrayList<PersonHW> input, ArrayList<PersonHW>[] solutions, int index)
	{
		if (index >= input.size() || index < 0)
		{
			return null;
		}
		
		ArrayList<PersonHW> best_seq = null;
		PersonHW cur = input.get(index);
		for (int i = 0 ; i < index; i++)
		{
			if (input.get(i).before(cur))
			{
				best_seq = seqWithMaxLength(best_seq, solutions[i]);
			}
		}
		
		ArrayList<PersonHW> new_sol = new ArrayList<PersonHW>();
		
		if (best_seq != null)
			new_sol.addAll(best_seq);
		
		new_sol.add(cur);
		solutions[index] = new_sol;
		
		return findLongestSequence(input, solutions, index+1);
	}
	
	/**
	 * Given two arraylists return the list with the most values
	 * @param a
	 * @param b
	 * @return
	 */
	private ArrayList<PersonHW> seqWithMaxLength(ArrayList<PersonHW> a, ArrayList<PersonHW> b)
	{
		if (a == null)
			return b;
		if (b == null)
			return a;
		return (a.size() > b.size()?a:b);
	}
	
	private void generatePersonHWObjects()
	{
		String[] hwpairs = numberPairsString.split("#");
		
		array = new ArrayList<PersonHW>();		
		for (String hwpair: hwpairs)
		{
			String[] hw = hwpair.split(",");
			PersonHW p = new PersonHW(Integer.parseInt(hw[0]), Integer.parseInt(hw[1]));
			array.add(p);
		}
	}
	
	private void displayHWPairs(ArrayList<PersonHW> input)
	{		
		for (PersonHW p: input)
		{
			System.out.printf("H:%d & W:%d   ",p.getHeight(), p.getWeight());
		}
		System.out.println();
	}

}
