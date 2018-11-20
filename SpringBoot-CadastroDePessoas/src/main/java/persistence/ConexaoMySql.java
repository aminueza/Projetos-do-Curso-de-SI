package persistence;

import java.util.HashMap;

import enumerator.Sgbd;
import factory.Fabrica;

public class ConexaoMySql extends Conexao {

	protected static ConexaoMySql instance;
	
	private ConexaoMySql() {
		this.bancosMap = new HashMap<Sgbd, Banco>();
		this.bancosMap.put(Sgbd.MySQL, Fabrica.criarBanco());
	}
	
	public static ConexaoMySql getInstance() {
		if (instance == null) {
			ConexaoMySql.instance = new ConexaoMySql();
		}
		return ConexaoMySql.instance;		
	}

	@Override
	public Banco acessarBanco() {
		return this.bancosMap.get(Sgbd.MySQL);
	}

}
