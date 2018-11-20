package webservice.charge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeRepository extends JpaRepository<Charge, Integer> {

	public Charge findByTitulo(String titulo);
	
}