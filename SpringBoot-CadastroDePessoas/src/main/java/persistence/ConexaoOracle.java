package persistence;

import java.util.HashMap;

import enumerator.Sgbd;
import factory.Fabrica;

public class ConexaoOracle extends Conexao {
	
	static ConexaoOracle instance;
	
	private ConexaoOracle() {
		this.bancosMap = new HashMap<Sgbd, Banco>();
		this.bancosMap.put(Sgbd.Oracle, Fabrica.criarBanco());
	}
	
	public static ConexaoOracle getInstance() {
		if (instance == null) {
			ConexaoOracle.instance = new ConexaoOracle();
		}
		return ConexaoOracle.instance;		
	}

	@Override
	public Banco acessarBanco() {
		return this.bancosMap.get(Sgbd.Oracle);
	}
}
