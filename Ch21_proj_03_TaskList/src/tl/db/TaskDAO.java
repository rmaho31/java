package tl.db;

import java.util.List;
import tl.business.Task;

public interface TaskDAO {
    List<Task> get(boolean isCompleted);
    List<Task> getAll();
    boolean add(Task t);
    boolean update(Task t);
    boolean delete(Task t);
}