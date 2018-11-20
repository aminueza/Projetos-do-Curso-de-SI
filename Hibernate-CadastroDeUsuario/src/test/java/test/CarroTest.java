package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Carro;
import persistence.EntidadeGenericaDAO;
import persistence.PersistenciaDAO;

public class CarroTest {

	private EntidadeGenericaDAO dao;
	private Carro carro;
	
	@Before
	public void instanciar() {
		dao = new EntidadeGenericaDAO();		
		carro = new Carro();
		carro.setChassi("12345");
		carro.setPlaca("QPL1234");
		carro.setValor(61.000);
		carro.setFabricante(null);		
	}
	
	@Test
	public void inserirComBuscaTest() {
		//Teste inserir...
		dao.inserir(carro);
		assertEquals(1, carro.getId());
		//Teste busca...
		Carro consulta = (Carro) dao.buscar(carro, 1);
		assertEquals("12345", consulta.getChassi());
		assertEquals("QPL1234", consulta.getPlaca());
		assertEquals(61.000, consulta.getValor(), 0);
		assertEquals(null, consulta.getFabricante());
	}
	
	@Test
	public void editarComBuscaTest() {
		dao.inserir(carro);
		//Busca entidade para edicao...		
		Carro consulta = (Carro) dao.buscar(carro, 1);
		//Teste editar...
		consulta.setChassi("1234567890");
		dao.editar(consulta);
		//verifica resultado da edicao...
		Carro consultaEdicao = (Carro) dao.buscar(carro, 1);
		assertEquals("1234567890", consultaEdicao.getChassi());		
	}
	
	@Test
	public void excluirComVerificacaoDelistaTest() {
		dao.inserir(carro);
		// Verificar a quantidade de itens na lista antes da exclusao...
		assertEquals(1, dao.listar(carro).size());
		// Teste excluir...
		dao.excluir(carro);
		// Verificar a quantidade de itens na lista depois da exclusao...
		assertEquals(0, dao.listar(carro).size());
	}
	
	@After
	public void fecharConexao() {
		PersistenciaDAO.getInstance().fecharConexao();
	}

}
