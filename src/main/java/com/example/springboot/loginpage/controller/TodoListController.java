/**
 * 
 */
package com.example.springboot.loginpage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.springboot.loginpage.model.TodoTask;
import com.example.springboot.loginpage.service.TodoListService;

/**
 * @author samasu5
 *
 */
@Controller
@SessionAttributes("name")
public class TodoListController {
	
	@Autowired
	TodoListService todoListService;

	@RequestMapping(value = "/todo-list", method = RequestMethod.GET)
	public String todoTaskList (ModelMap model) {
		
		/*String userName = model.get("name").toString();
		if ("Suman".equals(userName)) {
			List<TodoTask> todoTaskList = todoListService.getTaskList();
			model.put("todoTaskList", todoTaskList);
		} else {
			model.put("errorMessage", "Unauthorized Access");
		}*/
		List<TodoTask> todoTaskList = todoListService.getTaskList();
		model.put("todoTaskList", todoTaskList);
		return "todo-list";
	}
}
