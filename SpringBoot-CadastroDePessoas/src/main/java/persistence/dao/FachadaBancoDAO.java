package persistence.dao;

import java.util.List;

import logic.Entidade;
import persistence.FachadaConexaoDAO;

public interface FachadaBancoDAO extends FachadaConexaoDAO {

	    public List<Entidade> listarEntidade();

	    public Entidade buscarEntidade(Entidade entidade);

	    public void inserirEntidade(Entidade entidade);
	    
	    public void excluirEntidade(Entidade entidade);

}
