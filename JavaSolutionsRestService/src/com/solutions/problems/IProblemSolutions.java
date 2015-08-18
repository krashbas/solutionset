package com.solutions.problems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public interface IProblemSolutions {
	void setInput(HashMap<String, String> input);
	void displayInput();
	void run() throws Exception;
	
	ArrayList<Field> getInputFields();

}
