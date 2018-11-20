package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import logic.Telefone;

public class TelefoneDAO implements Tabela {

	private List<Telefone> telefones;

	public TelefoneDAO() {
		this.telefones = new ArrayList<Telefone>();
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}
	
}
