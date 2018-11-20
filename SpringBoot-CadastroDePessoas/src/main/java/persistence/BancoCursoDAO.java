package persistence;

import java.util.List;

import logic.Entidade;

public class BancoCursoDAO implements BancoDAO {
	
	private static String CREATE = "CREATE TABLE IF NOT EXITS curso("
										+ "idCurso Serial NOT NULL PRIMARY KEY,"
										+ "nome VARCHAR (20), "
										+ "area VARCHAR(20))";
	
	private static String INSERT = "INSERT INTO curso(nome, area) VALUES (?,?)";
	
	private static String UPDATE = "UPDATE curso SET idCurso = ?,"
										+ "descricaoProduto = ?, "
										+ "precoProduto = ?, "
										+ "unidadeProduto = ?, "
										+ "qtdProduto = ? "
										+ "WHERE codigoDeBarras = ? ";
	
	private static String SELECT = "SELECT * FROM curso WHERE idCurso = ?";

	@Override
	public List<Entidade> listarEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entidade buscarEntidade(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirEntidade(Entidade entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirEntidade(Entidade entidade) {
		// TODO Auto-generated method stub
		
	}

}
