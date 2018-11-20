package controller;

import java.util.ArrayList;
import java.util.List;

import logic.Entidade;
import logic.Telefone;
import persistence.dao.Tabela;
import persistence.dao.TelefoneDAO;

public class TelefoneController implements Controlador {

	private TelefoneDAO tabelaDeTelefones;	
	
	public TelefoneController(Tabela tabela) {
		this.tabelaDeTelefones = (TelefoneDAO) tabela;
	}

	public void inserir(Entidade entidade) {
		Telefone telefone = (Telefone) entidade;
		telefone.setId(autoIncrementar(telefone));
		tabelaDeTelefones.getTelefones().add(telefone);
	}

	public void alterar(Entidade entidade) {
		if (tabelaDeTelefones.getTelefones().contains(entidade)) {
			Telefone telefone = (Telefone) buscar(entidade);
			tabelaDeTelefones.getTelefones().add(telefone.getId(), (Telefone) entidade);
			excluir(telefone);
		}		
	}

	public void excluir(Entidade entidade) {
		if (tabelaDeTelefones.getTelefones().contains(entidade)) {
			tabelaDeTelefones.getTelefones().remove(entidade);
		}		
	}

	public List<Entidade> listar() {
		List<Entidade> entidades = new ArrayList<Entidade>();
		entidades.addAll(tabelaDeTelefones.getTelefones());
		return entidades;
	}

	public Entidade buscar(Entidade entidade) {
		Telefone telefone = (Telefone) entidade;
		int index = tabelaDeTelefones.getTelefones().indexOf(telefone);
		return tabelaDeTelefones.getTelefones().get(index);
	}
	
	private Entidade buscarPor(int id) {		
		return tabelaDeTelefones.getTelefones().get(id);
	}
	
	private int autoIncrementar(Telefone telefone) {
		if (!tabelaDeTelefones.getTelefones().isEmpty()) {
			int last = tabelaDeTelefones.getTelefones().size() - 1;
			telefone = (Telefone) buscarPor(last);
		} else {
			telefone.setId(0);
		}
		return telefone.getId() + 1;
	}

}
