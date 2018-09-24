package tl.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.OptionalInt;
import tl.business.Task;
import tl.business.TaskDB;
import tl.utility.Console;

public class TaskListApp {
	private static TaskDB tdb = new TaskDB();
	public static void main(String[] args) {
		System.out.println("Welcome to the Task List App");
			
		int command = 0;
		while(command != 8) {
			displayMenu();
			command = Console.getInt("Enter Command: ", 0, 9);
			if (command == 1) {
				printPendingTasks();
			} else if(command == 2) {
				printCompletedTasks();
			} else if(command == 3) {
				insertToDB();
			} else if (command == 4) {
				printTasksUpdateCompleted();
			} else if (command == 5) {
				printTasksDeleteIndex();
			} else if (command == 6) {
				printTasksUpdateDB();
			} else if(command == 7) {
				printDaysToNext();
			}
		}		
		System.out.println("\nBye!");
	}
	
	private static void displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nCOMMAND MENU\n");
		sb.append("1 - View\t-View pending tasks\n");
		sb.append("2 - History\t-View completed tasks\n");
		sb.append("3 - Add\t\t-Add a task\n");
		sb.append("4 - Complete\t-Complete a task\n");
		sb.append("5 - Delete\t-Delete a task\n");
		sb.append("6 - Update\t-Update pending task\n");
		sb.append("7 - Days\t-Days until next task\n");
		sb.append("8 - Exit\t-Exit program\n");
		System.out.println(sb);
	}
	
	private static void displayPendingTasks(String s) {
		String header = "================================================== Pending Tasks ===================================================\n" +
					    "____Number____________________Task__________________________________________________Complete By_____________________\n";
		System.out.println(header + s);
	}
	
	private static void displayCompletedTasks(String s) {
		String header = "================================================== Pending Tasks ===================================================\n" +
					    "____Number____________________Task__________________________________________________Complete By_____________________\n";
		System.out.println(header + s);
	}
	
	private static void printTasksUpdateDB() {
		List<Task> task = tdb.get(false);
		if(task.size() == 0) {
			Console.println("Add some tasks to edit them.");
		} else {
			//allows user to update pending tasks in the db
			String row = "";
			for(Task t : task) {
				row += t.toString();
			}
			displayPendingTasks(row);
			String choice = Console.getString("Edit task or date? (t/d): ", "t", "d");
			if(choice.equalsIgnoreCase("t")) {
				int index = 0;
				boolean isTrue = true;
				while(isTrue) {
					//again I'm sure this is a terrible workaround but avoids null pointers
					index = Console.getInt("Enter Task Number: ");
					final Integer indexw = new Integer(index);
					if(task.stream().anyMatch(n -> n.getId() == indexw)) {
						isTrue = false;
					} else {
						Console.println("Must enter a task number from the list.");
					}
				}
				
				Task t = tdb.getbyID(index);
				t.setTask(Console.getString("Enter updated task: "));
				tdb.update(t);					
			} else {
				int index = 0;
				boolean isTrue = true;
				while(isTrue) {
					//again I'm sure this is a terrible workaround but avoids null pointers
					index = Console.getInt("Enter Task Number: ");
					final Integer indexw = new Integer(index);
					if(task.stream().anyMatch(n -> n.getId() == indexw)) {
						isTrue = false;
					} else {
						Console.println("Must enter a task number from the list.");
					}
				}
				isTrue = true;
				String dateTime = "";
				LocalDateTime dt = null;
				while(isTrue) {
					//ensures proper format of date entry
					try{
						dateTime = Console.getString("Enter updated Date and Time (YYYY-MM-DD HH:mm:ss): ").replace(" ", "T");
						if(dateTime.matches("\\d+-\\d+-\\d+T\\d+:\\d+:\\d{2}")) {
							dt = LocalDateTime.parse(dateTime);
							isTrue = false;
						} else {
							Console.println("Input DateTime in the correct format please.");
						}
					} catch (DateTimeParseException e) {
						Console.println("Must be of valid date format");
					}
				}
				Task t = tdb.getbyID(index);
				t.setCompleteBy(dt);
				tdb.update(t);
			}	
		}
	}
	
	private static void insertToDB() {
		//allows the user to add entries to the db
		boolean isTrue = true;
		String dateTime = "";
		LocalDateTime dt = null;
		while(isTrue) {
			//ensures proper format of date entry
			try{
				dateTime = Console.getString("Enter updated Date and Time (YYYY-MM-DD HH:mm:ss): ").replace(" ", "T");
				if(dateTime.matches("\\d+-\\d+-\\d+T\\d+:\\d+:\\d{2}")) {
					dt = LocalDateTime.parse(dateTime);
					isTrue = false;
				} else {
					Console.println("Input DateTime in the correct format please.");
				}
			} catch (DateTimeParseException e) {
				Console.println("Must be of valid date format");
			}
		}
		String task = Console.getString("Enter Task: ");
		Task t = new Task(task,dt);				  
		tdb.add(t);
	}
	
	private static void printTasksUpdateCompleted() {
		//allows users to set pending tasks as completed
		List<Task> task = tdb.get(false);
		if(task.size() == 0) {
			Console.println("Complete some tasks to delete them.");
		} else {
			String row = "";
			for(Task t : task) {
				row += t.toString();
			}
			displayPendingTasks(row);
			int index = 0;
			boolean isTrue = true;
			while(isTrue) {
				//I'm sure this is a terrible workaround but avoids null pointers
				index = Console.getInt("Enter Task Number: ");
				final Integer indexw = new Integer(index);
				if(task.stream().anyMatch(n -> n.getId() == indexw)) {
					isTrue = false;
				} else {
					Console.println("Must enter a index number from the list.");
				}
			}
			Task t = tdb.getbyID(index);
			t.setCompleted(true);
			tdb.update(t);			
		}
	}
	
	private static void printTasksDeleteIndex() {
		List<Task> task = tdb.get(true);
		if(task.size() == 0) {
			Console.println("Complete some tasks to delete them.");
		} else {
			//allows users to delete completed records
			String row = "";
			for(Task t : task) {
				//replaces newline at the end of the toString to add the done
				row += t.toString().replaceAll("[\\n]", "") + "(DONE!)\n";
			}
			displayCompletedTasks(row);
			int index = 0;
			boolean isTrue = true;
			while(isTrue) {
				//again I'm sure this is a terrible workaround but avoids null pointers
				index = Console.getInt("Enter Task Number: ");
				final Integer indexw = new Integer(index);
				if(task.stream().anyMatch(n -> n.getId() == indexw)) {
					isTrue = false;
				} else {
					Console.println("Must enter a task number from the list.");
				}
			}
			tdb.delete(tdb.getbyID(index));			
		}
	}
	
	private static void printDaysToNext() {
		//allows user to see the days until next task they have to complete
		List<Task> task = tdb.get(false);
		String s = "";
		if(task.size() == 0) {
			Console.println("Add some tasks.");
		} else {
			OptionalInt dtnt = task.stream().mapToInt(n -> (int) ChronoUnit.DAYS.between(LocalDateTime.now(), n.getCompleteBy())).min();
			if(dtnt.getAsInt() >= 0) {
				s = "\nYou have " + dtnt.getAsInt() + " days until your next task\n";				
			} else {
				s = "\nYou are " + Math.abs(dtnt.getAsInt()) + " days late on completing a task??!?!?!\n";
			}
			Console.println(s);			
		}
	}
	
	private static void printPendingTasks() {
		//allows user to view the pending tasks in the db
		String row = "";
		List<Task> task = tdb.get(false);
		if(task.size() == 0) {
			Console.println("Add some entries to display them.");
		} else {
			for(Task t : task) {
				row += t.toString();
			}
			displayPendingTasks(row);					
		}
	}
	
	private static void printCompletedTasks() {
		//allows users to view completed tasks in the db
		String row = "";
		List<Task> task = tdb.get(true);
		if(task.size() == 0) {
			Console.println("Complete some tasks to display them.");
		} else {
			for(Task t : task) {
				//replaces newline at the end of the toString to add the done
				row += t.toString().replaceAll("[\\n]$", "") + "(DONE!)\n";
			}
			displayCompletedTasks(row);					
		}
	}
}
