package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Carro;
import model.Fabricante;
import persistence.EntidadeGenericaDAO;
import persistence.PersistenciaDAO;

public class FabricanteTest {

	private EntidadeGenericaDAO dao;
	private Carro carro;
	private Fabricante fabricante;
	
	@Before
	public void instanciar() {
		dao = new EntidadeGenericaDAO();		
		carro = new Carro();
		carro.setChassi("12345");
		carro.setPlaca("QPL1234");
		carro.setValor(61.000);
		carro.setFabricante(null);
		dao.inserir(carro);
		fabricante = new Fabricante();
		fabricante.setNome("Citroen");
		fabricante.setCarros(new ArrayList<Carro>());
		fabricante.addCarro(carro);
	}
	
	@Test
	public void inserirComBuscaTest() {
		//Teste inserir...
		dao.inserir(fabricante);
		assertEquals(2, fabricante.getId());
		//Teste busca...
		Fabricante consulta = (Fabricante) dao.buscar(fabricante, 2);
		assertEquals("Citroen", consulta.getNome());
		assertEquals("QPL1234", consulta.getCarros().get(0).getPlaca());
	}
	
	@Test
	public void editarComBuscaTest() {
		dao.inserir(fabricante);
		//Busca entidade para edicao...		
		Fabricante consulta = (Fabricante) dao.buscar(fabricante, 2);
		//Teste editar...
		consulta.setNome("Peugeot");
		dao.editar(consulta);
		//verifica resultado da edicao...
		Fabricante consultaEdicao = (Fabricante) dao.buscar(fabricante, 2);
		assertEquals("Peugeot", consultaEdicao.getNome());		
	}
	
	@Test
	public void excluirComVerificacaoDelistaTest() {
		dao.inserir(fabricante);
		// Verificar a quantidade de itens na lista antes da exclusao...
		assertEquals(1, dao.listar(fabricante).size());
		// Teste excluir...
		dao.excluir(fabricante);
		// Verificar a quantidade de itens na lista depois da exclusao...
		assertEquals(0, dao.listar(fabricante).size());
	}
	
	@After
	public void fecharConexao() {
		PersistenciaDAO.getInstance().fecharConexao();
	}

}
