package com.solutions;

import java.lang.Math;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.solutions.utils.*;

/**
 * This class implements a solution to the problem of finding the angle between the hour hand and minute hand for a given time
 * @author Rashmi
 *
 */
public class ClockAngleProblem implements IProblemSolutions{
	/**
	 * Protected variable to save inputs: Time for which to find the angle
	 */
	protected String inputTime;
	
	/**
	 * Private variables to store the hour and minute values from parsing the given input string
	 */
	private int hourValue;
	private int minValue;

	/**
	 * Default constructor. Used to instantiate class on demand
	 */
	public ClockAngleProblem()
	{
	
	}
	/**
	 * Contructor 
	 * @param time at which to find the angle in format hh:mm
	 */
	public ClockAngleProblem(String time)
	{
		this.inputTime = time;
	}
	
	
	
	@Override
	public void setInput(HashMap<String, String> input) {
		// TODO Auto-generated method stub
		for (Field f: getInputFields())
		{
			try
			{
				f.set(this, input.get(f.getName()));
			}
			catch (IllegalAccessException ex)
			{}
		}
	}

	@Override
	public void displayInput() {
		// TODO Auto-generated method stub
		System.out.println("##### CLOCK ANGLE PROBLEM #####");
		System.out.printf("ClockAngleProblem: Input time is " + inputTime);
	}
	
	/**
	 * Parse the given time string and find the angle between the hour and min hands	  
	 */
	@Override
	public void run() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Run solution for " + this.getClass().getSimpleName());
		
		if (inputTime == null)
		{
			throw new Exception("No input time specified");
		}
		
		/* Parse the input string */
		String[] timeValues = inputTime.split(":");
		if (timeValues.length != 2)
		{
			throw new Exception("Input time not specified in the correct format");
		}
		hourValue = Integer.parseInt(timeValues[0]);
		minValue = Integer.parseInt(timeValues[1]);
		
		System.out.printf("Hour = %d, Minute = %d\n", hourValue, minValue);
		
		// Angle between hour and 12'0 clock = 30(h%12) + m/2
		int hourAngle = 30 * (hourValue % 12) + (minValue/2);
		
		// Angle between minute and 12'0 clock = 6m
		int minAngle = 6 * minValue;
		
		System.out.printf("Hour Angle = %d, Minute Angle = %d\n", hourAngle, minAngle);
		
		int hourMinAngle = Math.abs(hourAngle - minAngle);		
		
		System.out.printf("ClockAngleProblem: Time between hour and minute hands for time %s = %d degrees\n", inputTime, hourMinAngle);
	}
	
	public ArrayList<Field> getInputFields()
	{
		return Utilities.getProtectedFields(this.getClass());
	}
	
}
