package webservice.task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	public Task findByTitulo(String titulo);
	
}