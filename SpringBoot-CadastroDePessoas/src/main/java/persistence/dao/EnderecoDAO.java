package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import logic.Endereco;

public class EnderecoDAO implements Tabela {

	private List<Endereco> enderecos;

	public EnderecoDAO() {
		this.enderecos = new ArrayList<Endereco>();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

}
