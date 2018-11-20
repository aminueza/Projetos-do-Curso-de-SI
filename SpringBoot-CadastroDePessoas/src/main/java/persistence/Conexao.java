package persistence;

import java.util.Map;

import enumerator.Sgbd;

public abstract class Conexao {

	protected Map<Sgbd, Banco> bancosMap;
	
	public abstract Banco acessarBanco();
	
}
