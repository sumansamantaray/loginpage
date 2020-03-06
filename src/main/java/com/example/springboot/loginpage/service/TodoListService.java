/**
 * 
 */
package com.example.springboot.loginpage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.loginpage.model.TodoTask;

/**
 * @author samasu5
 *
 */
@Service
public class TodoListService {

	List<TodoTask> todoTaskList = new ArrayList<>();

	public List<TodoTask> getTaskList() {
		
		TodoTask todoTask = new TodoTask();
		todoTask.setTaskId(1);
		todoTask.setTaskName("A");
		todoTask.setTaskPriority("1");
		todoTask.setTaskTime("1PM EST");
		todoTaskList.add(todoTask);
		
		todoTask = new TodoTask();
		todoTask.setTaskId(2);
		todoTask.setTaskName("B");
		todoTask.setTaskPriority("2");
		todoTask.setTaskTime("2PM EST");
		todoTaskList.add(todoTask);
		
		todoTask = new TodoTask();
		todoTask.setTaskId(3);
		todoTask.setTaskName("C");
		todoTask.setTaskPriority("10");
		todoTask.setTaskTime("3PM EST");
		todoTaskList.add(todoTask);
		
		return todoTaskList;
	}
	
}
