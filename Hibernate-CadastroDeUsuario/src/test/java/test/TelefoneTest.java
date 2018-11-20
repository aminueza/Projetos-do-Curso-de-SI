package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Telefone;
import model.TipoTelefone;
import persistence.EntidadeGenericaDAO;
import persistence.PersistenciaDAO;

public class TelefoneTest {

	private EntidadeGenericaDAO dao;
	private Telefone telefone;
	
	@Before
	public void instanciar() {
		dao = new EntidadeGenericaDAO();
		telefone = new Telefone();
		telefone.setTipo(TipoTelefone.RESIDENCIAL.name());
		telefone.setNumero("8366666666");
	}
	
	@Test
	public void inserirComBuscaTest() {
		//Teste inserir...
		dao.inserir(telefone);
		assertEquals(1, telefone.getId());
		//Teste busca...
		Telefone consulta = (Telefone) dao.buscar(telefone, 1);
		assertEquals(TipoTelefone.RESIDENCIAL.name(), consulta.getTipo());
		assertEquals("8366666666", consulta.getNumero());
	}
	
	@Test
	public void editarComBuscaTest() {
		dao.inserir(telefone);
		//Busca entidade para edicao...
		Telefone consulta = (Telefone) dao.buscar(telefone, 1);
		//Teste editar...
		consulta.setTipo(TipoTelefone.CELULAR.name());
		consulta.setNumero("8387161105");
		dao.editar(consulta);
		//verifica resultado da edicao...
		Telefone consultaEdicao = (Telefone) dao.buscar(telefone, 1);
		assertEquals(TipoTelefone.CELULAR.name(), consultaEdicao.getTipo());
		assertEquals("8387161105", consultaEdicao.getNumero());
	}
	
	@Test
	public void excluirComVerificacaoDelistaTest() {
		dao.inserir(telefone);
		//Verificar a quantidade de itens na lista antes da exclusao... 
		assertEquals(1, dao.listar(telefone).size());
		//Teste excluir...
		dao.excluir(telefone);
		//Verificar a quantidade de itens na lista depois da exclusao...
		assertEquals(0, dao.listar(telefone).size());
	}

	@After
	public void fecharConexao() {
		PersistenciaDAO.getInstance().fecharConexao();
	}
}
