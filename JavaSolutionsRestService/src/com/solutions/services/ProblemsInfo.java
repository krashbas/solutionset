package com.solutions.services;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class with information for each problem
 * @author rakuma
 *
 */
@XmlRootElement
public class ProblemsInfo {
	Integer problemID;
	String problemName;
	String description = "";
	
	public ProblemsInfo()
	{
		
	}
	public ProblemsInfo(int ID, String name)	
	{
		this.problemID = new Integer(ID);
		this.problemName = name;		
	}
	
	public ProblemsInfo(int ID, String name, String desc)
	{
		this.problemID = new Integer(ID);
		this.problemName = name;		
		this.description = desc;
	}
	
	public String getProblemName() {
		return problemName;
	}
	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getProblemID() {
		return problemID;
	}
	
}
