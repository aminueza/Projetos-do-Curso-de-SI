package edu.cesed.tap.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import edu.cesed.tap.domain.Aluno;
import edu.cesed.tap.repository.AlunoRepository;

@Service
@Validated
public class AlunoServiceImpl implements AlunoService {

	private final AlunoRepository repository;

	@Autowired
	public AlunoServiceImpl(final AlunoRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public Aluno save(@NotNull @Valid final Aluno aluno) throws AlunoAlreadyExistsException {
		Aluno recording = null;
		if (isAlreadyExists(aluno)) {
			throw new AlunoAlreadyExistsException(String.format("There already exists a aluno with matricula=%s", aluno.getMatricula()));
		} else {
			recording = repository.save(aluno);
		}
		return recording;
	}

	public Aluno getByMatricula(int matricula) {
		return repository.findOne(matricula);
	}

	public List<Aluno> listAll() {
		return repository.findAll();
	}
	

	public void update(Aluno aluno) {
		if (isAlreadyExists(aluno)) {
			this.repository.save(aluno);
		}		
	}

	@Transactional
	public void delete(Aluno aluno) {
		if (isAlreadyExists(aluno)) {
			this.repository.delete(aluno);
		}		
	}

/*	public AlunoRepository getRepository() {
		return repository;
	}*/
	
	private boolean isAlreadyExists(final Aluno aluno) {
		boolean status = false;
		Aluno existing = repository.findOne(aluno.getMatricula());
		if (existing != null) {
			status = true;
		}
		return status;
	}

}
