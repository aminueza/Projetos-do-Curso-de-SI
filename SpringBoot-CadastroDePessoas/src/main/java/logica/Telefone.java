package logica;

import enumLogica.TipoDeTelefone;

public class Telefone {
	
	private TipoDeTelefone numero;

	public Telefone(TipoDeTelefone numero) {
		this.numero = numero;
	}

	public TipoDeTelefone getNumero() {
		return numero;
	}

}
