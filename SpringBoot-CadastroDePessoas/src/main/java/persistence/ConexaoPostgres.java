package persistence;

import java.util.HashMap;

import enumerator.Sgbd;
import factory.Fabrica;

public class ConexaoPostgres extends Conexao {

	static ConexaoPostgres instance;
	
	private ConexaoPostgres() {
		this.bancosMap = new HashMap<Sgbd, Banco>();
		this.bancosMap.put(Sgbd.Postgres, Fabrica.criarBanco());
	}
	
	public static ConexaoPostgres getInstance() {
		if (instance == null) {
			ConexaoPostgres.instance = new ConexaoPostgres();
		}
		return ConexaoPostgres.instance;		
	}

	@Override
	public Banco acessarBanco() {
		return this.bancosMap.get(Sgbd.Postgres);
	}
}
