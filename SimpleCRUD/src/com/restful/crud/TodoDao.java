package com.restful.crud;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.time.*;

public enum TodoDao {
  instance;
  
  private Map<String, Todo> contentProvider = new HashMap<>();
  
  private TodoDao() {
    
	LocalDateTime cur = LocalDateTime.now();
	cur = cur.plusDays(2);
    Todo todo = new Todo("1", "Learn REST", cur.toString());
    todo.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
    contentProvider.put("1", todo);
    todo = new Todo("2", "Do something", cur.toString());
    todo.setDescription("Read complete http://www.vogella.com");
    contentProvider.put("2", todo);
    
  }
  public Map<String, Todo> getModel(){
    return contentProvider;
  }
  
} 
