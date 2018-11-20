package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO implements FachadaConexaoDAO {
	
	private Connection conexao;
	private String driver;
	private String url;
	private String usuario;
	private String senha;
	private Statement comando;

	
	public void setParametrosConexao(String driver, String url, String usuario, String senha) {
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}

	
	public void abrirFonteDeDados() {
		   try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void fecharFonteDeDados() {
		 try {
	            conexao.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}


	public void criarTabela(String sql) {
		 try {
	            comando = null;
	            comando = conexao.createStatement();
	            comando.executeQuery(sql);
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }
	}


	public void removerTabela(String sql) {
        try {
        	comando = null;
			comando = conexao.createStatement();
			comando.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
