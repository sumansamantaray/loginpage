/**
 * 
 */
package com.example.springboot.loginpage.model;

/**
 * @author samasu5
 *
 */
public class TodoTask {

	private int taskId;
	
	private String taskName;
	
	private String taskPriority;
	
	private String taskTime;

	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the taskPriority
	 */
	public String getTaskPriority() {
		return taskPriority;
	}

	/**
	 * @param taskPriority the taskPriority to set
	 */
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	/**
	 * @return the taskTime
	 */
	public String getTaskTime() {
		return taskTime;
	}

	/**
	 * @param taskTime the taskTime to set
	 */
	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TodoTask [taskId=" + taskId + ", taskName=" + taskName + ", taskPriority=" + taskPriority
				+ ", taskTime=" + taskTime + "]";
	}
	
	
}
