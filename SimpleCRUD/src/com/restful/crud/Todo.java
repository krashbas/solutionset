package com.restful.crud;

import java.time.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo {
  private String id;
  private String summary;
  private String description;
  private String completeByDate;
  
  public Todo(){
    
  }
  
  public Todo (String id, String summary, String d){
    this.id = id;
    this.summary = summary;
    this.completeByDate = d;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getSummary() {
    return summary;
  }
  public void setSummary(String summary) {
    this.summary = summary;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public void setCompletedByDate(String d) {
	  this.completeByDate = d;
  }
  public String getCompletedByDate()  {
	  return completeByDate;
  }
  
} 