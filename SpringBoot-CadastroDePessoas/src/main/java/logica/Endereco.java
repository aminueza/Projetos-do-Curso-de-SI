package logica;

import enumLogica.Estado;

public class Endereco {
	
	private String rua;
	private long numero;
	private String bairro;
	private String cidade;
	private Estado estado;
	
	public Endereco(String rua, long numero, String bairro, String cidade, Estado estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getRua() {
		return rua;
	}

	public long getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public Estado getEstado() {
		return estado;
	}
}
