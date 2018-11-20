package persistence;

import java.util.List;

import logic.Entidade;

public interface BancoDAO {
	
	public List<Entidade> listarEntidade();

    public Entidade buscarEntidade(Entidade entidade);

    public void inserirEntidade(Entidade entidade);
    
    public void excluirEntidade(Entidade entidade);
}
