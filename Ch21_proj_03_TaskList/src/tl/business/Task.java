package tl.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import tl.utility.StringUtils;

public class Task {


	private int id;					
	private String task; 				
	private boolean isCompleted;
	private LocalDateTime completeBy;
	
	public Task(int id, String task,LocalDateTime completeBy) {
		this.id = id;
		this.task = task;
		this.completeBy = completeBy;
	}
	public Task(String task,LocalDateTime completeBy) {
		this.task = task;
		this.completeBy = completeBy;
	}
	@Override
	public String toString() {
		//sets up the dateformat to Standard Time, Day of the week shortened, month, day, year
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a, EEE, dd MMM, YYYY ");
		return StringUtils.padWithSpaces("      "  + id, 25) + StringUtils.padWithSpaces(task, 52) +
				StringUtils.padWithSpaces(completeBy.format(dtf), 32) + "\n";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public LocalDateTime getCompleteBy() {
		return completeBy;
	}
	public void setCompleteBy(LocalDateTime completeBy) {
		this.completeBy = completeBy;
	}
}
