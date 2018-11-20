package webservice.evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

	public Evento findByTitulo(String titulo);
	
}