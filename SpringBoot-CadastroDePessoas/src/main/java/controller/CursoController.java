package controller;

import java.util.ArrayList;
import java.util.List;

import logic.Curso;
import logic.Entidade;
import persistence.dao.CursoDAO;
import persistence.dao.Tabela;

public class CursoController implements Controlador {
	
	private CursoDAO tabelaDeCursos;
	
	public CursoController(Tabela tabela) {
		tabelaDeCursos = (CursoDAO) tabela;
	}

	public void inserir(Entidade entidade) {
		Curso curso = (Curso) entidade;
		curso.setId(autoIncrementar(curso));
		tabelaDeCursos.getCursos().add(curso);
		
	}

	public void alterar(Entidade entidade) {
		if (tabelaDeCursos.getCursos().contains(entidade)) {
			Curso curso = (Curso) buscar(entidade);
			tabelaDeCursos.getCursos().add(curso.getId(), (Curso) entidade);
			excluir(curso);
		}		
	}

	public void excluir(Entidade entidade) {
		if (tabelaDeCursos.getCursos().contains(entidade)) {
			tabelaDeCursos.getCursos().remove(entidade);
		}				
	}

	public List<Entidade> listar() {		
		List<Entidade> entidades = new ArrayList<Entidade>();
		entidades.addAll(tabelaDeCursos.getCursos());
		return entidades;
	}
	
	public Entidade buscar(Entidade entidade) {
		Curso curso = (Curso) entidade;
		int index = tabelaDeCursos.getCursos().indexOf(curso);
		return tabelaDeCursos.getCursos().get(index);
	}
	
	private Entidade buscarPor(int id) {		
		return tabelaDeCursos.getCursos().get(id);
	}
	
	private int autoIncrementar(Curso curso) {
		if (!tabelaDeCursos.getCursos().isEmpty()) {
			int last = tabelaDeCursos.getCursos().size() - 1;
			curso = (Curso) buscarPor(last);
		} else {
			curso.setId(0);
		}
		return curso.getId() + 1;
	}
	
}
