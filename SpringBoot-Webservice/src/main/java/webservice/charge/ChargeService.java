package webservice.charge;
import java.util.List;

public interface ChargeService {
	Charge save(Charge charge);

	Charge getById(int id);
	
	List<Charge> listAllCharges();
	
	void deleteById(int id);
}
