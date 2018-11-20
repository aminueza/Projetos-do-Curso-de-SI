package controller;

import java.util.ArrayList;
import java.util.List;

import logic.Entidade;
import logic.Pessoa;
import persistence.dao.PessoaDAO;
import persistence.dao.Tabela;

public class PessoasController implements Controlador {

	private PessoaDAO tabelaDePessoas;
	
	public PessoasController(Tabela tabela) {
		tabelaDePessoas = (PessoaDAO) tabela;
	}
	
	public void inserir(Entidade entidade) {
		Pessoa pessoa = (Pessoa) entidade;
		pessoa.setId(autoIncrementar(pessoa));
		tabelaDePessoas.getPessoas().add(pessoa);
	}

	public void alterar(Entidade entidade) {
		if (tabelaDePessoas.getPessoas().contains(entidade)) {
			Pessoa pessoa = (Pessoa) buscar(entidade);
			tabelaDePessoas.getPessoas().add(pessoa.getId(), (Pessoa) entidade);
			excluir(pessoa);
		}
	}

	public void excluir(Entidade entidade) {
		if (tabelaDePessoas.getPessoas().contains(entidade)) {
			tabelaDePessoas.getPessoas().remove(entidade);
		}		
	}

	public List<Entidade> listar() {
		List<Entidade> entidades = new ArrayList<Entidade>();
		entidades.addAll(tabelaDePessoas.getPessoas());
		return entidades;
	}

	public Entidade buscar(Entidade entidade) {
		Pessoa pessoa = (Pessoa) entidade;
		int index = tabelaDePessoas.getPessoas().indexOf(pessoa);
		return tabelaDePessoas.getPessoas().get(index);
	}
	
	private Entidade buscarPor(int id) {		
		return tabelaDePessoas.getPessoas().get(id);
	}
	
	private int autoIncrementar(Pessoa pessoa) {
		if (!tabelaDePessoas.getPessoas().isEmpty()) {
			int last = tabelaDePessoas.getPessoas().size() - 1;
			pessoa = (Pessoa) buscarPor(last);
		} else {
			pessoa.setId(0);
		}
		return pessoa.getId() + 1;
	}

}
