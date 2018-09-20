package fc.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import fc.business.User;

public class FileCleanerIO{
	private List<User> users;
	private Path usersPath;
	private File usersFile;
	private File newFile;
	private final String FIELD_SEP = ",";
	
	public FileCleanerIO() {
		usersPath = Paths.get("prospects.csv");
        usersFile = usersPath.toFile();
        newFile = Paths.get("newprospects.csv").toFile();
        users = this.getAll();
	}

	public List<User> getAll() {
		// if the users file has already been read, don't read it again
        if (users != null) {
            return users;
        }

        users = new ArrayList<>();
        if (Files.exists(usersPath)) {
            try (BufferedReader in = new BufferedReader(
                                     new FileReader(usersFile))) {

                // read users from file into array list
                String line = in.readLine();
                while (line != null) {
                    String[] fields = line.split(FIELD_SEP);
                    String first = fields[0];
                    String last = fields[1];
                    String email = fields[2];

                    User p = new User(first, last, email);
                    users.add(p);

                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        } else {
            System.out.println(
                    usersPath.toAbsolutePath() + " doesn't exist.");
            return null;            
        }
        return users;
	}
	
	public boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(newFile)))) {

            // write all products in the array list
            for (User u : users) {
                out.print(u.getFirst() + FIELD_SEP);
                out.print(u.getLast() + FIELD_SEP);
                out.println(u.getEmail());
            }
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }
	
	public void cleanCSV() {
		for (User u : users) {
			u.setFirst(cleanName(u.getFirst()));
			u.setLast(cleanName(u.getLast()));
			u.setEmail(cleanEmail(u.getEmail()));
		}
	}
	
	public String cleanName(String s) {
		s = s.trim().toLowerCase();
		String fl = s.substring(0,1);
		s = s.substring(1);
		fl = fl.toUpperCase();
		fl += s;
		return fl;
	}
	
	public String cleanEmail(String s) {
		s = s.trim().toLowerCase();
		return s;
	}
	
	public boolean cleanSave() {
    	cleanCSV();
		return saveAll();
	}	

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Path getUsersPath() {
		return usersPath;
	}
	public void setUsersPath(Path usersPath) {
		this.usersPath = usersPath;
	}
	public File getUsersFile() {
		return usersFile;
	}
	public void setUsersFile(File usersFile) {
		this.usersFile = usersFile;
	}
	public File getNewFile() {
		return newFile;
	}
	public void setNewFile(File newFile) {
		this.newFile = newFile;
	}
	public String getFIELD_SEP() {
		return FIELD_SEP;
	}
}
