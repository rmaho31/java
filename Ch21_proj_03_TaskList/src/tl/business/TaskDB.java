package tl.business;

import java.util.ArrayList;
import java.util.List;
import tl.db.TaskDAO;
import java.sql.*;
import java.time.LocalDateTime;


public class TaskDB implements TaskDAO {

	@Override
	public List<Task> get(boolean isCompleted) {
		List<Task> task = new ArrayList<>();
		int value = isCompleted ? 1 : 0;
		try (Connection connect = getConnection();
			//setup the prepared statement to select completed entries
			PreparedStatement ps = connect.prepareStatement("select * from tasks where isCompleted = ?");) {
			ps.setInt(1, value);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Task t = new Task(rs.getInt(1),
									 rs.getString(2),
									 LocalDateTime.parse(rs.getString(3).replace(" ", "T")));
				task.add(t);
			}
		} catch (SQLException e) {
			System.out.println("Error reading the database.");
		}
		return task;
	}
	
	public Task getbyID(int id) {
		Task task = null;
		try (Connection connect = getConnection();
			//setup the prepared statement to select a row by id
			PreparedStatement ps = connect.prepareStatement("select * from tasks where id = ?");) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				task = new Task(rs.getInt(1),
						 rs.getString(2),
						 LocalDateTime.parse(rs.getString(3).replace(" ", "T")));
			}
		} catch (SQLException e) {
			System.out.println("Error reading the database.");
		}
		return task;
	}

	@Override
	public List<Task> getAll() {
		List<Task> task = new ArrayList<>();
		try (Connection connect = getConnection()) { 
					
			// Sets up the preparedStatement for returning all values from the DB into an arraylist
			PreparedStatement ps = connect.prepareStatement("select * from tasks");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Task t = new Task(rs.getInt(1),
						 rs.getString(2),
						 LocalDateTime.parse(rs.getString(3).replace(" ", "T")));
				task.add(t);
			}

    } catch (SQLException e) {
    	System.out.println("Error reading the database.");
    } 
		return task;
	}

	@Override
	public boolean add(Task t) {
		try (Connection connect = getConnection()) { 

            // Sets up the preparedStatement for inputting the values into the DB from the input Array
            PreparedStatement ps = connect
                    .prepareStatement("insert into tasks (Task, CompleteBy)" + 
                    		 " values (?, ?)");
            ps.setString(1, t.getTask());
            ps.setString(2, t.getCompleteBy().toString().replace("T", " "));
            ps.executeUpdate();

           

        } catch (SQLException e) {
        	System.out.println("Error writing to the database.");
        }
		return false;
	}

	@Override
	public boolean update(Task t) {
		int value = t.isCompleted() ? 1 : 0;
		try (Connection connect = getConnection()) { 

            // Sets up the preparedStatement for updating the values into the DB from the input Array
            PreparedStatement ps = connect
                    .prepareStatement("UPDATE tasks SET task = ?, CompleteBy = ?, isCompleted = ? WHERE id = ?");
            ps.setString(1, t.getTask());
            ps.setString(2, t.getCompleteBy().toString().replace("T", " "));
            ps.setInt(3, value);
            ps.setInt(4, t.getId());
            ps.executeUpdate();

           

        } catch (SQLException e) {
        	System.out.println("Error updating the database.");
        }
		return false;
	}

	@Override
	public boolean delete(Task t) {
		try (Connection connect = getConnection();
				
				//setup the prepared statement to delete a row from the db by id
				PreparedStatement ps = connect.prepareStatement("delete from tasks where id = ?");) {
				ps.setInt(1, t.getId());
				ps.executeUpdate();
			} catch (SQLException | NullPointerException e) {
				System.out.println("Error writing to the database, check name and try again?");
			}
		return false;
	}
	
	public Connection getConnection() throws SQLException{
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskDB?useSSL=false", "taskDB_user", "sesame");
		return connect;
	}
	
	public static void closeConnection(Connection connect) throws SQLException{
		if(connect != null) {
			connect.close();
		}
	}
}
