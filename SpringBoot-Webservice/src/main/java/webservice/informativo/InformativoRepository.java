package webservice.informativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformativoRepository extends JpaRepository<Informativo, Integer> {

	public Informativo findByTitulo(String titulo);
	
}