package tl.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

import tl.business.Task;
import tl.business.TaskDB;
import tl.utility.Console;

public class TaskListApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Task List App");
		
		
		int command = 0;
		while(command != 8) {
			TaskDB tdb = new TaskDB();
			displayMenu();
			command = Console.getInt("Enter Command: ", 0, 9);
			if (command == 1) {
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
			} else if(command == 2) {
				//allows users to view completed tasks in the db
				String row = "";
				List<Task> task = tdb.get(true);
				if(task.size() == 0) {
					Console.println("Complete some tasks to display them.");
				} else {
					for(Task t : task) {
						row += t.toString().replaceAll("[\\n]", "") + "(DONE!)\n";
					}
					displayCompletedTasks(row);					
				}
			} else if(command == 3) {
				//allows the user to add entries to the db
				boolean isTrue = true;
				String dateTime = "";
				LocalDateTime dt = null;
				while(isTrue) {					
					dateTime = Console.getString("Enter Date and Time to complete by (YYYY-MM-DD HH:mm:ss): ").replace(" ", "T");
					if(dateTime.matches("\\d+-\\d+-\\d+T\\d+:\\d+:\\d{2}")) {
						dt = LocalDateTime.parse(dateTime);
						isTrue = false;
					} else {
						Console.println("Input DateTime in the correct format please.");
					}
				}
				String task = Console.getString("Enter Task: ");
				Task t = new Task(task,dt);
								  
				tdb.add(t);
			} else if (command == 4) {
				//allows users to set pending tasks as completed
				String row = "";
				List<Task> task = tdb.get(false);
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
			} else if (command == 5) {
				//allows users to delete completed records
				String row = "";
				List<Task> task = tdb.get(true);
				for(Task t : task) {
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
			} else if (command == 6) {
				//allows user to update pending tasks
				String row = "";
				List<Task> task = tdb.get(false);
				for(Task t : task) {
					row += t.toString();
				}
				displayPendingTasks(row);
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
			} else if(command == 7) {
				//allows user to see the days until next task they have to complete
				List<Task> task = tdb.get(false);
				OptionalInt dtnt = task.stream().mapToInt(n -> (int) ChronoUnit.DAYS.between(LocalDateTime.now(), n.getCompleteBy())).min();
				String s = "\nYou have " + dtnt.getAsInt() + " days until your next task\n";
				Console.println(s);
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

}
