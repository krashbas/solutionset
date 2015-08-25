package com.solutions.runner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import com.solutions.problems.IProblemSolutions;

import oracle.jrockit.jfr.parser.ParseException;

public class MainRunner {
	
	static final String PACKAGE_NAME = "com.solutions.problems";
	
	public static String RunProblemCaptureStdout(String problemName, String inputArguments)
	{
		PrintStream curPrintStream = System.out;
		try
	    {
			ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
		    PrintStream newPrintStream = new PrintStream(byteArrayStream);
		    System.setOut(newPrintStream);
			
		    if (problemName != null)
			{
				HashMap<String, String> inputArgs = new HashMap<String, String>();
				if (inputArguments != null)
				{
					String[] inputs = inputArguments.split(";");
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
				inputProblem.displayInput();
				inputProblem.run();
				return byteArrayStream.toString();
			}
	    }
	    catch (Exception ex)
		{
			System.out.println(ex);
		}
	    finally
	    {
	    	System.setOut(curPrintStream);
	    }
	    
		return "";
	}
	public static void main(String[] args) {
		
		try
		{
			//ArrayList<Class<?>> classesInterface = Utilities.getClassesImplementingInterface(IProblemSolutions.class, IProblemSolutions.class.getPackage().getName());
			Options options = new Options();
			options.addOption("problemName", true, "Name of the problem to execute");
			options.addOption("inputArguments", true, "Key value pair of all inputs to the problem separated by a ,");
			
			CommandLineParser parser = new DefaultParser();
			CommandLine cmdOptions = parser.parse(options, args);
			String problemName = cmdOptions.getOptionValue("problemName");
			String problemArgs = cmdOptions.getOptionValue("inputArguments");
			String solutionStdout = RunProblemCaptureStdout(problemName, problemArgs);

		    System.out.println("########Output of problem#########\n" + solutionStdout.toString());
		}
		catch (Exception ex)
		{
			System.out.println("Command line parsing failed. Error: " + ex.getMessage());
		}
		
		
			
				
	
	}
}
