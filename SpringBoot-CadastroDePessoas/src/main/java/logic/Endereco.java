package logic;

import enumerator.Estado;

public class Endereco implements Entidade {
	
	private int id;
	private String logradouro;
	private int numero;
	private String bairro;
	private String municipio;
	private Estado uf;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public Estado getUf() {
		return uf;
	}
	
	public void setUf(Estado uf) {
		this.uf = uf;
	}	

}
