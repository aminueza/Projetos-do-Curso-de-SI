package edu.cesed.tap.controller;

import java.util.List;

import edu.cesed.tap.domain.Aluno;

public interface AlunoService {
	
	public Aluno save(Aluno aluno) throws AlunoAlreadyExistsException;

	public Aluno getByMatricula(int matricula);
	
	public List<Aluno> listAll();
	
	public void update(Aluno aluno);
	
	public void delete(Aluno aluno);

}
