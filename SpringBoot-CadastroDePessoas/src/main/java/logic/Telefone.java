package logic;

import enumerator.TipoDeTelefone;

public class Telefone implements Entidade {

	private int id;
	private TipoDeTelefone tipo;
	private long numero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoDeTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTelefone tipo) {
		this.tipo = tipo;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

}
