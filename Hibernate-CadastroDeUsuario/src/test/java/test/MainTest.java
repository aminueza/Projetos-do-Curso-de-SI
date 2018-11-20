package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Endereco;


public class MainTest {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Endereco e = new Endereco();
		e.setLogradouro("Avenida das Loucas");
		e.setBairro("Zepa");
		e.setCidade("Campina Grande");
		e.setEstado("PB");
		e.setCep("58400000");
		
		Session session = sf.openSession();
		session.beginTransaction().begin();
		session.saveOrUpdate(e);
		session.beginTransaction().commit();
		
		//Endereco e2 = session.load(Endereco.class, 1);
		//System.out.println(e2.getLogradouro());
		
		//session.beginTransaction().begin();
		//session.delete(e2);
		//session.beginTransaction().commit();
		
		session.close();
		sf.close();		
		
	}

}
