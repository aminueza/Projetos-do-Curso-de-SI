package persistence;

public interface FachadaConexaoDAO {

	public void setParametrosConexao(String driver, String url, String usuario, String senha);

	public void abrirFonteDeDados();

	public void fecharFonteDeDados();
	
	public void criarTabela(String sql);
	
	public void removerTabela(String sql);

}