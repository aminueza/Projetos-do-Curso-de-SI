package persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersistenciaDAO {

	private SessionFactory persistencia;
	private Session session;
	
	private static PersistenciaDAO instance;
	
	private PersistenciaDAO() {
		persistencia = new Configuration().configure().buildSessionFactory();
		session = persistencia.openSession();
	}
	
	public static PersistenciaDAO getInstance() {
		if (instance == null) {
			instance = new PersistenciaDAO();
		}
		return instance;
	}
	
	public Session getSession() {
		return session;
	}
	
	public void fecharConexao() {
		session.close();
		persistencia.close();
		instance = null;
	}
	
}
