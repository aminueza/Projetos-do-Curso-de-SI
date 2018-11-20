package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import logic.Curso;

public class CursoDAO implements Tabela {

	private List<Curso> cursos;
	
	public CursoDAO () {
		this.cursos = new ArrayList<Curso>();
	}

	public List<Curso> getCursos() {
		return cursos;
	}

}
