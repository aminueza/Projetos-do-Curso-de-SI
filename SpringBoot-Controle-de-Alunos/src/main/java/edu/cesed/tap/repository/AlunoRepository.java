package edu.cesed.tap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cesed.tap.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	public Aluno findByMatricula(int matricula);

}
