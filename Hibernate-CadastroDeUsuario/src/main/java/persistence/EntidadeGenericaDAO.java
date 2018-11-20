package persistence;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import model.Entidade;

public class EntidadeGenericaDAO {
	
	final static String SCRIPT_GENERICO = " WHERE entidade.id=:arg";

	Session session;

	public EntidadeGenericaDAO() {
		this.session = PersistenciaDAO.getInstance().getSession();
	}

	public void inserir(Entidade entidade) {
		session.getTransaction().begin();
		session.save(entidade);
		session.getTransaction().commit();
	}
	
	public void editar(Entidade entidade) {
		session.getTransaction().begin();
		session.update(entidade);
		session.getTransaction().commit();
	}
	
	public void excluir(Entidade entidade) {
		session.getTransaction().begin();
		session.delete(entidade);
		session.getTransaction().commit();
	}

	public Entidade buscar(Entidade entidade, int id) {
		Query query = session.createQuery(entidade.getInstrucao() + SCRIPT_GENERICO);
		query.setParameter("arg", id);
		return (Entidade) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(Entidade entidade) {
		return session.createQuery(entidade.getInstrucao()).list();
	}
	
	public Session getSession() {
		return session;
	}
	
}
