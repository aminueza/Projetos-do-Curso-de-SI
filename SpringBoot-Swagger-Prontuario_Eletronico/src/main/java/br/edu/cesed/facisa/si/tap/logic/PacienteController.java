package br.edu.cesed.facisa.si.tap.logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/paciente")
@Api(value = "pacientes", description = "Pacientes API")
public class PacienteController {

	private List<Paciente> listaPacientesFake;
	
	 private static final int RESPONSE_CODE_OK = 200;
	    private static final int RESPONSE_CODE_CREATED = 201;
	    private static final int RESPONSE_CODE_INTERNAL_SERVER_ERROR = 500;
	    private static final int RESPONSE_CODE_NOTFOUND = 404;
	
	
	
	public PacienteController() {
		listaPacientesFake = new ArrayList<Paciente>();
		listaPacientesFake.add(new Paciente(1, "Fulano DeTall", 123456789));
		listaPacientesFake.add(new Paciente(2, "Beltrano Silva", 987654321));
		listaPacientesFake.add(new Paciente(3, "Ciclano Brasil", 666666666));
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Obtem os dados dos pacientes", response = List.class, notes = "Retorna todos os pacientes do sistema")
	@ApiResponses({
		@ApiResponse(code = RESPONSE_CODE_OK, message = "Existem todos os pacientes")
	})
	public ResponseEntity<List<Paciente>> listAllPacientes() {
				
		return new ResponseEntity<List<Paciente>>(listaPacientesFake, HttpStatus.OK);		
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtem os dados de um paciente especifico",response = Paciente.class, notes = "Para obter o paciente, e requerido o seu id")
	@ApiResponses({
		@ApiResponse(code = RESPONSE_CODE_OK, message = "Existe o paciente"),
		@ApiResponse(code = RESPONSE_CODE_NOTFOUND, message = "Nao existe o paciente")
	})
	public ResponseEntity<Paciente> getPaciente(@PathVariable int id) {
		Paciente paciente = null;
		for (Paciente p : listaPacientesFake) {
			if (p.getId() == id) {
				paciente = p;
			} 
				 
		}
		
		return paciente == null ?
				new ResponseEntity<Paciente>(HttpStatus.NOT_FOUND) :
					new ResponseEntity<Paciente>(paciente, HttpStatus.OK);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Insere um paciente na base de dados", notes = "Para inserir um paciente, dados como id, nome e cartao sus sao necessarios")
	@ApiResponses({
		@ApiResponse(code = RESPONSE_CODE_CREATED, message = "Paciente criado com sucesso"),
		@ApiResponse(code = RESPONSE_CODE_INTERNAL_SERVER_ERROR, message = "Paciente nao inserido na base de dados")
	})
	public ResponseEntity<String> createPaciente(@RequestBody Paciente paciente, HttpServletResponse resposta) {
		try {
			listaPacientesFake.add(paciente);
			resposta.sendError(HttpStatus.CREATED.value());
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
