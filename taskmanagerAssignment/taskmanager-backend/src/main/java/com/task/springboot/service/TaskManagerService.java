package com.task.springboot.service;

import java.util.List;

import com.task.springboot.entity.Task;

public interface TaskManagerService {
	
	public List<Task> retriveTasks();
	
	public void updateTask(Task task);
	
	public Task getTask(Long taskId);

}
