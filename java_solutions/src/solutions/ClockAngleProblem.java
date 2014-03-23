package solutions;

import java.lang.Math;
/**
 * This class implements a solution to the problem of finding the angle between the hour hand and minute hand for a given time
 * @author Rashmi
 *
 */
public class ClockAngleProblem {
	/**
	 * Time for which to find the angle
	 */
	String inputTime;
	
	/**
	 * Private variables to store the hour and minute values from parsing the given input string
	 */
	private int hourValue;
	private int minValue;
	
	/**
	 * Contructor 
	 * @param time at which to find the angle in format hh:mm
	 */
	public ClockAngleProblem(String time)
	{
		this.inputTime = time;
	}
	
	/**
	 * Parse the given time string and find the angle between the hour and min hands
	 * @return Angle between hour and minute hand
	 */
	public int Run() throws Exception
	{
		System.out.println("Run solution for " + this.getClass().getName());
		
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
		
		return hourMinAngle;
	}
	
}
