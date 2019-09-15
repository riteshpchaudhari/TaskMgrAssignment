package com.task.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.springboot.entity.Task;
import com.task.springboot.service.TaskManagerService;

@RestController
public class TaskManagerController {
	
	@Autowired
	private TaskManagerService taskManagerService;
	
	public void setTaskManagerService(TaskManagerService taskManagerService) {
		this.taskManagerService = taskManagerService;
	}
	
	@GetMapping("/hometest")
	public String testHome() {
		return "TaskManager";
	}
	
	@GetMapping("/api/tasks")
	public List<Task> getTasks() {
		List<Task> tasks = taskManagerService.retriveTasks();
		return tasks;
	}
	
	@GetMapping("/api/tasks/{taskid}")
	public Task getTask(@PathVariable(name="taskid") Long taskid) {
		Task task = taskManagerService.getTask(taskid);
		return task;
	}
	
	@PostMapping(path = "/api/tasks", consumes = "application/json", produces = "application/json")
	public boolean saveTask(@RequestBody Task task) {
		try {
			taskManagerService.updateTask(task);
		}catch(Exception e)
		{
			System.out.println("Not able to save : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	@PutMapping("/api/tasks/{taskid}")
	public boolean updateTask(@RequestBody Task task, @PathVariable(name="taskid") Long taskid) {
		try {
			Task taskRetrived = taskManagerService.getTask(taskid);
			if(taskRetrived != null) {
				taskManagerService.updateTask(task);
			}else {
				System.out.println("notask for task id : " + taskid);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Updation failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	@DeleteMapping("/api/tasks/{taskid}")
	public boolean deleteTask(@PathVariable(name="taskid") Long taskid) {
		try {
			Task taskRetrived = taskManagerService.getTask(taskid);
			if(taskRetrived != null) {
				taskRetrived.setStatus("I");
				taskManagerService.updateTask(taskRetrived);
			}else {
				System.out.println("deleteTask: No task for task id : " + taskid);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Deletion Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
}
