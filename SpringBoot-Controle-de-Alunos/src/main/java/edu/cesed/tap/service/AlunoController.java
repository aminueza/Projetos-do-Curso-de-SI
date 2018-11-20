package edu.cesed.tap.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.cesed.tap.controller.AlunoService;
import edu.cesed.tap.domain.Aluno;

@RestController
public class AlunoController {

	private final AlunoService alunoService;

	@Autowired
	public AlunoController(final AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@RequestMapping(value = "/Aluno", method = RequestMethod.POST)
	public ResponseEntity<String> createAluno(@RequestBody Aluno aluno) {
		try {
			this.alunoService.save(aluno);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/Aluno/{matricula}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> getAluno(@PathVariable int matricula) {
		Aluno aluno = this.alunoService.getByMatricula(matricula);
		return aluno == null ? new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}

	@RequestMapping(value = "/Aluno", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listAllAlunos() {
		return new ResponseEntity<List<Aluno>>(alunoService.listAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> updateAluno(@RequestBody Aluno aluno, HttpServletResponse resposta) {
		try {
			this.alunoService.update(aluno);
			resposta.sendError(HttpStatus.OK.value());
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAluno(@RequestBody Aluno aluno, HttpServletResponse resposta) {		
		try {
			this.alunoService.delete(aluno);			
			resposta.sendError(HttpStatus.OK.value());
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public AlunoService getAlunoService() {
		return alunoService;
	}
	
}
