package com.task.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {

	 @Id
	 @Column(name="taskId")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long taskId;
	 
	 @Column(name="taskName")
	 private String taskName;
	 
	 @Column(name="startDate")
	 private String startDate;
	 
	 @Column(name="endDate")
	 private String endDate;
	 
	 @Column(name="priority")
	 private String priority;
	 
	 @Column(name="status")
	 private String status;
	 
	 @ManyToOne(cascade={CascadeType.MERGE})
	 @JoinColumn(name="parentTaskId", insertable = true, updatable = true)
	 private Task parentTask;
	 
	 public Task getParentTask() {
		return parentTask;
	 }
	 public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	 }
	
	 public Task() {
		 
	 }
	 
	 public Task(String taskName, String startDate, String endDate, String priority, String status) {
		 this.taskName = taskName;
		 this.startDate = startDate;
		 this.endDate = endDate;
		 this.priority = priority;
		 this.status = status;
	 }
	 
		public Long getTaskId() {
			return taskId;
		}
		public void setTaskId(Long taskId) {
			this.taskId = taskId;
		}
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getPriority() {
			return priority;
		}
		public void setPriority(String priority) {
			this.priority = priority;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}

}
