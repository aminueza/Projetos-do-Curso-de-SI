package controller;

import java.util.List;

import logic.Entidade;

public interface Controlador {

	public void inserir(Entidade entidade);
	
	public void alterar(Entidade entidade);
	
	public void excluir(Entidade entidade);
	
	public List<Entidade> listar();
	
	public Entidade buscar(Entidade entidade);
	
}
