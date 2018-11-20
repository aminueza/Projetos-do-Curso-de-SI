package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.TipoTelefone;
import model.Pessoa;
import model.Telefone;
import model.Endereco;
import model.Estado;
import model.Fabricante;
import model.Carro;
import persistence.EntidadeGenericaDAO;

public class HibernateTest {
	
	private EntidadeGenericaDAO entidadeDao;
	
	@Before
	public void instanciar() {
		this.entidadeDao = new EntidadeGenericaDAO();
	}
	
	@Test
	public void testSave() {
	Telefone telefone = new Telefone();
	telefone.setTipo(TipoTelefone.RESIDENCIAL.name());
	telefone.setNumero("8366666666");
	entidadeDao.inserir(telefone);
	
	Endereco endereco = new Endereco();
	endereco.setLogradouro("Rua Joao Jose");
	endereco.setBairro("Zepa");
	endereco.setCidade("Boqueirao");
	endereco.setEstado(Estado.PB.name());
	endereco.setCep("58475000");
	entidadeDao.inserir(endereco);
	
	Pessoa pessoa = new Pessoa();
	pessoa.setNome("Thiago Baesso Procaci");
	pessoa.setEndereco(endereco);
	pessoa.addTelefone(telefone);
	pessoa.setCpf("07800678965");
	pessoa.setHabilitacao("3344234");
	entidadeDao.inserir(pessoa);
	
	Fabricante fabricante = new Fabricante();
	fabricante.setNome("Citroen");
	//fabricante.setCarro(carro);
	entidadeDao.inserir(fabricante);
	
	Carro carro = new Carro();
	carro.setChassi("12345");
	carro.setPlaca("QPL1234");
	carro.setValor(65.000);
	carro.setFabricante(fabricante);
	entidadeDao.inserir(carro);
	
	//Teste para endereco
	assertNotNull(endereco.getId());
	Endereco enderecoT = (Endereco)entidadeDao.buscar(endereco, 4);
	assertEquals("Rua Joao Jose", enderecoT.getLogradouro());
	assertEquals("Zepa", enderecoT.getBairro());
	assertEquals("Boqueirao", enderecoT.getCidade());
	assertEquals(Estado.PB.name(), enderecoT.getEstado());
	assertEquals("58475000", enderecoT.getCep());
	
	//Teste para telefone
	assertNotNull(telefone.getId());
	Telefone telefoneT = (Telefone)entidadeDao.buscar(telefone, 3);
	assertEquals(TipoTelefone.RESIDENCIAL.name(), telefoneT.getTipo());
	assertEquals("8366666666", telefoneT.getNumero());
	
	//Teste para pessoa
	assertNotNull(pessoa.getId());
	Pessoa pessoaT = (Pessoa)entidadeDao.buscar(pessoa, 5);
	assertEquals("Thiago Baesso Procaci",  pessoaT.getNome());
	assertEquals(pessoa.getEndereco().getLogradouro(), pessoaT.getEndereco().getLogradouro());
	assertEquals(pessoa.getTelefones().get(0).getNumero(), pessoaT.getTelefones().get(0).getNumero());
	assertEquals("07800678965", pessoaT.getCpf());
	assertEquals("3344234", pessoaT.getHabilitacao());
	}
	
	@Test
	public void testAlterar() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua Joao Jose");
		endereco.setBairro("Zepa");
		endereco.setCidade("Boqueirao");
		endereco.setEstado(Estado.PB.name());
		endereco.setCep("58475000");
		entidadeDao.inserir(endereco);

		Endereco endereco2 = new Endereco();
		endereco2 = (Endereco)entidadeDao.buscar(endereco, 15);
		endereco2.setLogradouro("Rua Joao Jose");
		entidadeDao.editar(endereco2);
		assertEquals("Rua Joao Jose", ((Endereco)entidadeDao.buscar(endereco2, 15)).getLogradouro());
		//entidadeDao.excluir(endereco2);
	}

}
