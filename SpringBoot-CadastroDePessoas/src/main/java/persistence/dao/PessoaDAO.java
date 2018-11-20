package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import logic.Pessoa;

public class PessoaDAO implements Tabela {

	//private String campo = "pessoa";
	private List<Pessoa> pessoas;

	public PessoaDAO() {
		this.pessoas = new ArrayList<Pessoa>();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	/*public Tabela getCampo(String arg) {
		return campo.equals(arg)? this: null;
	}*/

}
