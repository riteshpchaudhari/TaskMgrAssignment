package com.task.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.springboot.entity.Task;
import com.task.springboot.repository.TaskManagerRepository;
import com.task.springboot.service.TaskManagerService;

@Service
public class TaskManagerServiceImpl implements TaskManagerService{

	@Autowired
	private TaskManagerRepository taskManagerRepository;
	
	public void setTaskManagerRepository(TaskManagerRepository taskManagerRepository) {
		this.taskManagerRepository = taskManagerRepository;
	}
	
	public List<Task> retriveTasks(){
		List<Task> tasks = taskManagerRepository.findAll();
		return tasks;
	}

	public void updateTask(Task task) {
		taskManagerRepository.save(task);
	}
	
	public Task getTask(Long taskid) {
		Optional<Task> optTask = taskManagerRepository.findById(taskid);
		return optTask.get();
	}
}
