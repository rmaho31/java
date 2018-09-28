package com.prs;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.prs.business.User;
import com.prs.business.UserDB;
import com.prs.util.Console;

@SpringBootApplication
public class PrsJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrsJpaDemoApplication.class, args);
		Console.println("Welcome to the JPA Demo");
		int command = 0;
		while(command != 9) {
			displayMennu();
			command = Console.getInt("Enter Command: ");
			if(command == 1) {
				List<User> user = UserDB.list();
				for(User u : user) {
					System.out.println(u);
				}
			} else if(command != 9) {
				Console.println("Invalid Command");
			}
		}
		
		
		
		Console.println("Bye");
	}
	
	private static void displayMennu() {
		StringBuilder sb = new StringBuilder("Command Menu: \n");
		sb.append("1. - List Users\n");
		sb.append("9. - Exit \n");
		Console.println(sb+"");
	}
}
