package webservice.evento;
import java.util.List;

public interface EventoService {
	Evento save(Evento evento);

	Evento getById(int id);
	
	List<Evento> listAllEventos();
	
	void deleteById(int id);
}
