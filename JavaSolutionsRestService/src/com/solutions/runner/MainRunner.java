package com.solutions.runner;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import com.solutions.problems.IProblemSolutions;
import com.solutions.utils.Utilities;

public class MainRunner {
	
	static final String PACKAGE_NAME = "com.solutions";
	public static void main(String[] args) {
		
		try		
		{	
			ArrayList<Class<?>> classesInterface = Utilities.getClassesImplementingInterface(IProblemSolutions.class, IProblemSolutions.class.getPackage().getName());
			Options options = new Options();
			options.addOption("problemName", true, "Name of the problem to execute");
			options.addOption("inputArguments", true, "Key value pair of all inputs to the problem separated by a ,");
			
			CommandLineParser parser = new DefaultParser();
			CommandLine cmdOptions = parser.parse(options, args);
			
			String problemName = cmdOptions.getOptionValue("problemName");
			String problemArgs = cmdOptions.getOptionValue("inputArguments");
			
			if (problemName != null)
			{
				HashMap<String, String> inputArgs = new HashMap<String, String>();
				if (problemArgs != null)
				{
					String[] inputs = problemArgs.split(";");
					for (String input: inputs)
					{
						String[] keyValue = input.split("=");
						if (keyValue.length == 2)
						{
							inputArgs.put(keyValue[0], keyValue[1]);
						}						
					}
				}
				String fullClassName = PACKAGE_NAME + "." + problemName;
				
				IProblemSolutions inputProblem = (IProblemSolutions)Class.forName(fullClassName).newInstance();
				inputProblem.setInput(inputArgs);
				inputProblem.run();
			}
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
	
	}
}
