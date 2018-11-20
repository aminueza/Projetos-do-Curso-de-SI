package br.edu.facisa.cwf.example5.controller;

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

import br.edu.facisa.cwf.example5.domain.Conta;
import br.edu.facisa.cwf.example5.service.ContaService;


@RestController
@RequestMapping(value="/conta")
public class ContaController {
	
	private final ContaService contaService;
	
	public ContaService getContaService() {
		return contaService;
	}

	@Autowired
	public ContaController(ContaService contaService) {
		this.contaService = contaService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Conta>> listAllContas() {
		return new ResponseEntity<List<Conta>>(contaService.listAllContas(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "{/id}", method = RequestMethod.GET)
	public ResponseEntity<Conta> getConta(@PathVariable int id) {
		Conta conta = contaService.getById(id);

		return conta == null ? new ResponseEntity<Conta>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Conta> getConta(@PathVariable String nome) {
		Conta conta = contaService.getByName(nome);

		return conta == null ? new ResponseEntity<Conta>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Conta>(conta, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createConta(@RequestBody Conta conta){
		
		try {
			contaService.save(conta);
			return new ResponseEntity<String>(HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateContaById(@PathVariable int id, @RequestBody Conta contaUpdated) {
		try {
			Conta conta = contaService.getById(id);
			conta = contaUpdated;
			contaService.save(conta);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{nome}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateContaByName(@PathVariable String nome, @RequestBody Conta contaUpdated) {
		try {
			Conta conta = contaService.getByName(nome);
			conta = contaUpdated;
			contaService.save(conta);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteContaById(@PathVariable int id) {
		try {
			contaService.deleteById(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
