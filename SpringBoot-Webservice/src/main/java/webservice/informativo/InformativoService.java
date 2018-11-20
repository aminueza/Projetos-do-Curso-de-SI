package webservice.informativo;
import java.util.List;

public interface InformativoService {
	Informativo save(Informativo informativo);

	Informativo getById(int id);
	
	List<Informativo> listAllInformativos();
	
	void deleteById(int id);
}
