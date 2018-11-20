package webservice.task;
import java.util.List;

public interface TaskService {
	Task save(Task task);

	Task getById(int id);
	
	List<Task> listAllTasks();
	
	void deleteById(int id);
}
