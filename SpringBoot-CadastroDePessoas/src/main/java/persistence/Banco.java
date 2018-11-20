package persistence;

import java.util.HashMap;
import java.util.Map;

import persistence.dao.Tabela;

public class Banco {
	
	private String nome;
	private Map<String, Tabela> tabelas;
	
	public Banco(String nome) {
		this.nome = nome;
		tabelas = new HashMap<String, Tabela>();
	}

	public void putTabela(String campo, Tabela tabela) {
		this.tabelas.put(campo, tabela);
	}	
	
	public Tabela getTabela(String campo) {
		return tabelas.get(campo);
	}
	
	public String getNome() {
		return nome;
	}
	
}
