package br.edu.facisa.cwf.example5.service;

import java.util.List;

import br.edu.facisa.cwf.example5.domain.Conta;

public interface ContaService {
	
	public Conta save(Conta conta);
	
	public Conta getById(int id);
	
	public Conta getByName(String name);
	
	public List<Conta> listAllContas();
	
	public void deleteById(int id);
	

}
