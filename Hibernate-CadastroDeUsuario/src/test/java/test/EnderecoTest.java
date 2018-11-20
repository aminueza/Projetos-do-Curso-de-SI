package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Endereco;
import model.Estado;
import persistence.EntidadeGenericaDAO;
import persistence.PersistenciaDAO;

public class EnderecoTest {

	private EntidadeGenericaDAO dao;
	private Endereco endereco;
	
	@Before
	public void instanciar() {
		dao = new EntidadeGenericaDAO();
		endereco = new Endereco();
		endereco.setLogradouro("Rua Joao Jose");
		endereco.setBairro("Zepa");
		endereco.setCidade("Boqueirao");
		endereco.setEstado(Estado.PB.name());
		endereco.setCep("58475000");
	}
	
	@Test
	public void inserirComBuscaTest() {
		//Teste inserir...
		dao.inserir(endereco);
		assertEquals(1, endereco.getId());
		//Teste busca...
		Endereco consulta = (Endereco) dao.buscar(endereco, 1);
		assertEquals("Rua Joao Jose", consulta.getLogradouro());
		assertEquals("Zepa", consulta.getBairro());
		assertEquals("Boqueirao", consulta.getCidade());
		assertEquals(Estado.PB.name(), consulta.getEstado());
		assertEquals("58475000", consulta.getCep());
	}
	
	@Test
	public void editarComBuscaTest() {
		dao.inserir(endereco);
		//Busca entidade para edicao...		
		Endereco consulta = (Endereco) dao.buscar(endereco, 1);
		//Teste editar...
		consulta.setLogradouro("Avenida das loucas");
		dao.editar(consulta);
		//verifica resultado da edicao...
		Endereco consultaEdicao = (Endereco) dao.buscar(endereco, 1);
		assertEquals("Avenida das loucas", consultaEdicao.getLogradouro());		
	}
	
	@Test
	public void excluirComVerificacaoDelistaTest() {
		dao.inserir(endereco);
		// Verificar a quantidade de itens na lista antes da exclusao...
		assertEquals(1, dao.listar(endereco).size());
		// Teste excluir...
		dao.excluir(endereco);
		// Verificar a quantidade de itens na lista depois da exclusao...
		assertEquals(0, dao.listar(endereco).size());
	}
	
	@After
	public void fecharConexao() {
		PersistenciaDAO.getInstance().fecharConexao();
	}

}
