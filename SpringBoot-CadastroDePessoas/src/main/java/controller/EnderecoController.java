package controller;

import java.util.ArrayList;
import java.util.List;

import logic.Endereco;
import logic.Entidade;
import persistence.dao.EnderecoDAO;
import persistence.dao.Tabela;

public class EnderecoController implements Controlador {

	private EnderecoDAO tabelaDeEnderecos;	
	
	public EnderecoController(Tabela tabela) {
		this.tabelaDeEnderecos = (EnderecoDAO) tabela;
	}

	public void inserir(Entidade entidade) {
		Endereco endereco = (Endereco) entidade;
		endereco.setId(autoIncrementar(endereco));
		tabelaDeEnderecos.getEnderecos().add(endereco);
	}

	public void alterar(Entidade entidade) {
		if (tabelaDeEnderecos.getEnderecos().contains(entidade)) {
			Endereco endereco = (Endereco) buscar(entidade);			
			tabelaDeEnderecos.getEnderecos().add(endereco.getId(), (Endereco) entidade);
			excluir(endereco);
		}
	}

	public void excluir(Entidade entidade) {
		if (tabelaDeEnderecos.getEnderecos().contains(entidade)) {
			tabelaDeEnderecos.getEnderecos().remove(entidade);
		}
	}

	public List<Entidade> listar() {
		List<Entidade> entidades = new ArrayList<Entidade>();
		entidades.addAll(tabelaDeEnderecos.getEnderecos());
		return entidades;
	}

	public Entidade buscar(Entidade entidade) {
		Endereco endereco = (Endereco) entidade;
		int index = tabelaDeEnderecos.getEnderecos().indexOf(endereco);
		return tabelaDeEnderecos.getEnderecos().get(index);
	}
	
	private Entidade buscarPor(int id) {		
		return tabelaDeEnderecos.getEnderecos().get(id);
	}
	
	private int autoIncrementar(Endereco endereco) {
		if (!tabelaDeEnderecos.getEnderecos().isEmpty()) {
			int last = tabelaDeEnderecos.getEnderecos().size() - 1;
			endereco = (Endereco) buscarPor(last);
		} else {
			endereco.setId(0);
		}
		return endereco.getId() + 1;
	}	

}
