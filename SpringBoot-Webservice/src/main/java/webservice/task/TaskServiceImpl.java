package webservice.task;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TaskServiceImpl implements TaskService {

	private final TaskRepository repository;

	@Autowired
	public TaskServiceImpl(final TaskRepository repository) {
		this.repository = repository;
	}

	public Task getById(int id) {
		return repository.findOne(id);
	}

	public List<Task> listAllTasks() {
		return repository.findAll();
	}

	@Transactional
	public Task save(@NotNull @Valid final Task task) {

		Task existing = repository.findOne(task.getId());

		if (existing == null)
			return null;

		return repository.save(task);
	}

	public TaskRepository getRepository() {
		return repository;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		repository.delete(id);
	}
}
