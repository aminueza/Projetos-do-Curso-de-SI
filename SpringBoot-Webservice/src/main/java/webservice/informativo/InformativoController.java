package webservice.informativo;
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
@RequestMapping(value = "/informativo")
public class InformativoController {
	private final InformativoService informativoService;

	@Autowired
	public InformativoController(final InformativoService informativoService) {
		this.informativoService = informativoService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Informativo>> listAllInformativos() {
		return new ResponseEntity<List<Informativo>>(informativoService.listAllInformativos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Informativo> getInformativo(@PathVariable int id) {

		Informativo informativo = informativoService.getById(id);

		return informativo == null ? new ResponseEntity<Informativo>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Informativo>(informativo, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createInformativo(@RequestBody Informativo informativo) {

		try {
			informativoService.save(informativo);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateInformativoById(@PathVariable int id, @RequestBody Informativo informativoUpdated) {
		try {
			Informativo informativo = informativoService.getById(id);
			informativo = informativoUpdated;
			informativoService.save(informativo);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteInformativoById(@PathVariable int id) {
		try {
			informativoService.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public InformativoService getInformativoService() {
		return informativoService;
	}
}
