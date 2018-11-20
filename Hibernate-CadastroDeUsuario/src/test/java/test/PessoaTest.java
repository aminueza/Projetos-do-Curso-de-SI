package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Endereco;
import model.Estado;
import model.Pessoa;
import model.Telefone;
import model.TipoTelefone;
import persistence.EntidadeGenericaDAO;
import persistence.PersistenciaDAO;

public class PessoaTest {

	private EntidadeGenericaDAO dao;
	private Endereco endereco;
	private Telefone telefone;
	private Pessoa pessoa;
	
	@Before
	public void instanciar() {
		dao = new EntidadeGenericaDAO();		
		endereco = new Endereco();
		endereco.setLogradouro("Rua Joao Jose");
		endereco.setBairro("Zepa");
		endereco.setCidade("Boqueirao");
		endereco.setEstado(Estado.PB.name());
		endereco.setCep("58475000");
		dao.inserir(endereco);
		telefone = new Telefone();
		telefone.setTipo(TipoTelefone.RESIDENCIAL.name());
		telefone.setNumero("8366666666");
		dao.inserir(telefone);		
		pessoa = new Pessoa();
		pessoa.setNome("Thiago Baesso Procaci");
		pessoa.setEndereco(endereco);
		pessoa.setTelefones(new ArrayList<Telefone>());
		pessoa.addTelefone(telefone);
		pessoa.setCpf("07800678965");
		pessoa.setHabilitacao("3344234");
	}
	
	@Test
	public void inserirComBuscaTest() {
		//Teste inserir...
		dao.inserir(pessoa);
		assertEquals(2, pessoa.getId());
		//Teste busca...
		Pessoa consulta = (Pessoa) dao.buscar(pessoa, 2);
		assertEquals("Thiago Baesso Procaci",  consulta.getNome());
		assertEquals("Rua Joao Jose", consulta.getEndereco().getLogradouro());
		assertEquals("8366666666", consulta.getTelefones().get(0).getNumero());
		assertEquals("07800678965", consulta.getCpf());
		assertEquals("3344234", consulta.getHabilitacao());
	}
	
	@Test
	public void editarComBuscaTest() {
		dao.inserir(pessoa);
		//Busca entidade para edicao...		
		Pessoa consulta = (Pessoa) dao.buscar(pessoa, 2);
		//Teste editar...
		consulta.setNome("Fulano de Tall");
		dao.editar(pessoa);
		//verifica resultado da edicao...
		Pessoa consultaEdicao = (Pessoa) dao.buscar(pessoa, 2);
		assertEquals("Fulano de Tall", consultaEdicao.getNome());		
	}
	
	@Test
	public void excluirComVerificacaoDelistaTest() {
		dao.inserir(pessoa);
		// Verificar a quantidade de itens na lista antes da exclusao...
		assertEquals(1, dao.listar(pessoa).size());
		// Teste excluir...
		dao.excluir(pessoa);
		// Verificar a quantidade de itens na lista depois da exclusao...
		assertEquals(0, dao.listar(pessoa).size());
	}
	
	@After
	public void fecharConexao() {
		PersistenciaDAO.getInstance().fecharConexao();
	}

}
