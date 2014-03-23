package main;

import solutions.ClockAngleProblem;

public class MainProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/***********************************************CLOCK ANGLE PROBLEM************************************************************/
		String time = "2:30";
		try
		{
			System.out.println("##### CLOCK ANGLE PROBLEM #####");
			ClockAngleProblem cap = new ClockAngleProblem(time);
			int result = cap.Run();
			System.out.printf("ClockAngleProblem: Time between hour and minute hands for time %s = %d degrees", time, result);
		}
		catch (Exception ex)
		{
			System.out.printf("Failed to find the angle for time %s with error %s",time, ex.getMessage());
		}
		/*****************************************************************************************************************************/
	}

}
