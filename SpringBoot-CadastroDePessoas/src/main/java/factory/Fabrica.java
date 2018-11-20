package factory;

import enumerator.Sgbd;
import persistence.Banco;
import persistence.ConexaoMySql;
import persistence.ConexaoOracle;
import persistence.ConexaoPostgres;
import persistence.dao.CursoDAO;
import persistence.dao.EnderecoDAO;
import persistence.dao.PessoaDAO;
import persistence.dao.TelefoneDAO;

public class Fabrica {

	public static Banco criarBanco() {
		Banco banco = new Banco("CadastroDeClientes");
		PessoaDAO tabelaPessoa = new PessoaDAO();
		EnderecoDAO tabelaEndereco = new EnderecoDAO();
		TelefoneDAO tabelaTelefone = new TelefoneDAO();
		CursoDAO tabelaCurso = new CursoDAO();
		banco.putTabela("pessoa", tabelaPessoa);
		banco.putTabela("endereco", tabelaEndereco);
		banco.putTabela("telefone", tabelaTelefone);
		banco.putTabela("curso", tabelaCurso);
		return banco;		
	}
	
	public static Banco estabelecerConexao(Sgbd sgbd) {
		Banco banco = null;
		switch (sgbd) {
		case MySQL:
			banco = ConexaoMySql.getInstance().acessarBanco();
			break;
		case Oracle:
			banco = ConexaoOracle.getInstance().acessarBanco();
			break;
		case Postgres:
			banco = ConexaoPostgres.getInstance().acessarBanco();
			break;
		}
		return banco;
	}
}
