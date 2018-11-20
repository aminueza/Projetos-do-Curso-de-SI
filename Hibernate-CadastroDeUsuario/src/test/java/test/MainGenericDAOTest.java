package test;

import java.util.List;

import model.Entidade;
import model.Telefone;
import persistence.EntidadeGenericaDAO;

public class MainGenericDAOTest {

	public static void main(String[] args) {
		
		Telefone t = new Telefone();
		t.setTipo("CELULAR");
		t.setNumero("83987161105");
		
		EntidadeGenericaDAO dao = new EntidadeGenericaDAO();
		dao.inserir(t);
		
		Telefone t2 = (Telefone) dao.buscar(t, 2);
		System.out.println(t2.getNumero());
		
		t2.setNumero("8333372931");
		dao.editar(t2);
		t2 = (Telefone) dao.buscar(t, 2);
		System.out.println(t2.getNumero());
		
		dao.excluir(t2);
		
		List<Entidade> lista = dao.listar(t);
		System.out.println(lista.size());
		
	}

}
