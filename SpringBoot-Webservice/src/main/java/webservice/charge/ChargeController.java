package webservice.charge;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/charge")
public class ChargeController {
	private final ChargeService chargeService;

	@Autowired
	public ChargeController(final ChargeService chargeService) {
		this.chargeService = chargeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Charge>> listAllCharges() {
		return new ResponseEntity<List<Charge>>(chargeService.listAllCharges(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Charge> getCharge(@PathVariable int id) {

		Charge charge = chargeService.getById(id);

		return charge == null ? new ResponseEntity<Charge>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Charge>(charge, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createCharge(@RequestBody Charge charge) {

		try {
			chargeService.save(charge);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateChargeById(@PathVariable int id, @RequestBody Charge chargeUpdated) {
		try {
			Charge charge = chargeService.getById(id);
			charge = chargeUpdated;
			chargeService.save(charge);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteChargeById(@PathVariable int id) {
		try {
			chargeService.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ChargeService getChargeService() {
		return chargeService;
	}
}
