package webservice.task;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
	private final TaskService taskService;

	@Autowired
	public TaskController(final TaskService taskService) {
		this.taskService = taskService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Task>> listAllTasks() {
		return new ResponseEntity<List<Task>>(taskService.listAllTasks(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Task> getTask(@PathVariable int id) {

		Task task = taskService.getById(id);

		return task == null ? new ResponseEntity<Task>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Task>(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createTask(@RequestBody Task task) {

		try {
			taskService.save(task);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateTaskById(@PathVariable int id, @RequestBody Task taskUpdated) {
		try {
			Task task = taskService.getById(id);
			task = taskUpdated;
			taskService.save(task);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTaskById(@PathVariable int id) {
		try {
			taskService.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public TaskService getTaskService() {
		return taskService;
	}
}
