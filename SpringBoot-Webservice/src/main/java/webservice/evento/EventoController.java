package webservice.evento;
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
@RequestMapping(value = "/evento")
public class EventoController {
	private final EventoService eventoService;

	@Autowired
	public EventoController(final EventoService eventoService) {
		this.eventoService = eventoService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Evento>> listAllEventos() {
		return new ResponseEntity<List<Evento>>(eventoService.listAllEventos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Evento> getEvento(@PathVariable int id) {

		Evento evento = eventoService.getById(id);

		return evento == null ? new ResponseEntity<Evento>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Evento>(evento, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createEvento(@RequestBody Evento evento) {

		try {
			eventoService.save(evento);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateEventoById(@PathVariable int id, @RequestBody Evento eventoUpdated) {
		try {
			Evento evento = eventoService.getById(id);
			evento = eventoUpdated;
			eventoService.save(evento);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteEventoById(@PathVariable int id) {
		try {
			eventoService.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public EventoService getEventoService() {
		return eventoService;
	}
}
