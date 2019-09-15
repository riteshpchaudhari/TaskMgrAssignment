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
	 @Column(name="taskid")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long taskid;
	 
	 @Column(name="taskname")
	 private String taskname;
	 
	 @Column(name="startdate")
	 private String startdate;
	 
	 @Column(name="enddate")
	 private String enddate;
	 
	 @Column(name="priority")
	 private String priority;
	 
	 @Column(name="status")
	 private String status;
	 
	 @ManyToOne(cascade={CascadeType.MERGE})
	 @JoinColumn(name="parenttaskid", insertable = true, updatable = true)
	 private Task parenttask;
	 
	 public Task getParentTask() {
		return parenttask;
	 }
	 public void setParentTask(Task parenttask) {
		this.parenttask = parenttask;
	 }
	
	 public Task() {
		 
	 }
	 
	 public Task(String taskname, String startdate, String enddate, String priority, String status) {
		 this.taskname = taskname;
		 this.startdate = startdate;
		 this.enddate = enddate;
		 this.priority = priority;
		 this.status = status;
	 }
	 
		public Long getTaskId() {
			return taskid;
		}
		public void setTaskId(Long taskid) {
			this.taskid = taskid;
		}
		public String getTaskName() {
			return taskname;
		}
		public void setTaskName(String taskname) {
			this.taskname = taskname;
		}
		public String getStartDate() {
			return startdate;
		}
		public void setStartDate(String startdate) {
			this.startdate = startdate;
		}
		public String getEndDate() {
			return enddate;
		}
		public void setEndDate(String enddate) {
			this.enddate = enddate;
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
