package controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import enumerator.Estado;
import enumerator.Sgbd;
import enumerator.TipoDeTelefone;
import factory.Fabrica;
import logic.Pessoa;
import logic.Telefone;
import logic.Endereco;
import logic.Entidade;
import persistence.Banco;
import persistence.dao.Tabela;

public class PessoaTest {

	private Banco cadastroDePessoas;		
	private Tabela tabelaPessoa;
	private Tabela tabelaEndereco;
	private Tabela tabelaTelefone;
	private PessoaController pessoaController;
	private EnderecoController enderecoController;
	private TelefoneController telefoneController;
	
	@Before
	public void instanciar() {
		this.cadastroDePessoas = Fabrica.estabelecerConexao(Sgbd.Postgres);
		this.tabelaPessoa = cadastroDePessoas.getTabela("pessoa");
		this.pessoaController = new PessoaController(tabelaPessoa);
		this.tabelaEndereco = cadastroDePessoas.getTabela("endereco");
		this.enderecoController = new EnderecoController(tabelaEndereco);
		this.tabelaTelefone = cadastroDePessoas.getTabela("telefone");
		this.telefoneController = new TelefoneController(tabelaTelefone);
	}
	
	@Test
	public void incluir() {
		Pessoa pessoa = new Pessoa();
		pessoaController.inserir(pessoa);
		assertEquals(pessoa, (Pessoa) pessoaController.buscar(pessoa));
	}	
	
	@Test
	public void incrementoAutomatico() {
		Pessoa pessoa = new Pessoa();
		pessoaController.inserir(pessoa);
		pessoaController.inserir(pessoa);
		assertEquals(2, ((Pessoa) pessoaController.buscar(pessoa)).getId());
	}
	
	@Test
	public void alterar() {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Fulano de Thall");
		pessoaController.inserir(pessoa1);
		assertEquals("Fulano de Thall", ((Pessoa) pessoaController.buscar(pessoa1)).getNome());	
		Pessoa pessoa2 = new Pessoa();
		pessoa2 = (Pessoa) pessoaController.buscar(pessoa1);
		pessoa2.setNome("Beltrano Silva");
		pessoaController.alterar(pessoa2);
		assertEquals("Beltrano Silva", ((Pessoa) pessoaController.buscar(pessoa2)).getNome());		
	}
	
	@Test
	public void listar() {
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Fulano de Thall");
		pessoa1.setCpf("111.111.111-11");
		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Rua projetada Sem Nome");
		endereco1.setNumero(387);
		endereco1.setBairro("Centro");
		endereco1.setMunicipio("São João da Serra");
		endereco1.setUf(Estado.PI);
		enderecoController.inserir(endereco1);
		pessoa1.setEndereco((Endereco) enderecoController.buscar(endereco1));
		Telefone telefone1 = new Telefone();
		telefone1.setTipo(TipoDeTelefone.RESIDENCIAL);
		telefone1.setNumero(8366666666l);
		telefoneController.inserir(telefone1);
		pessoa1.setTelefone((Telefone) telefoneController.buscar(telefone1));;
		pessoaController.inserir(pessoa1);
		Pessoa pessoa2 = new Pessoa();		
		pessoa2.setNome("Beltrano Silva ");
		pessoa2.setCpf("000.000.000-00");
		Endereco endereco2 = new Endereco();		
		endereco2.setLogradouro("Avenida das Loucas    ");
		endereco2.setNumero(456);
		endereco2.setBairro("Centro");
		endereco2.setMunicipio("Remígio          ");
		endereco2.setUf(Estado.PB);
		enderecoController.inserir(endereco2);
		pessoa2.setEndereco((Endereco) enderecoController.buscar(endereco2));
		Telefone telefone2 = new Telefone();		
		telefone2.setTipo(TipoDeTelefone.COMERCIAL);
		telefone2.setNumero(8322223333l);
		telefoneController.inserir(telefone2);
		pessoa2.setTelefone((Telefone) telefoneController.buscar(telefone2));
		pessoaController.inserir(pessoa2);
		assertEquals(2, pessoaController.listar().size());
		exibir();
	}
	
	@Test
	public void excluir() {
		Pessoa pessoa = new Pessoa();
		pessoaController.inserir(pessoa);
		assertFalse(pessoaController.listar().isEmpty());
		pessoaController.excluir(pessoa);
		assertTrue(pessoaController.listar().isEmpty());
	}
	
	@After
	public void finalizar() {
		limparTabela();
		this.pessoaController = null;
		this.tabelaPessoa = null;
		this.cadastroDePessoas = null;
	}
	
	private void limparTabela() {
		List<Entidade> entidades = pessoaController.listar();
		for (Entidade entidade : entidades) {
			pessoaController.excluir(entidade);
		}
	}
	
	private void exibir() {
		List<Entidade> entidades = pessoaController.listar();
		Pessoa pessoa = null;
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("| Id | Nome            | CPF            | Logradouro             | Nº  | Bairro | Municipio         | Uf | Tipo de Telefone | Numero |");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		for (Entidade entidade : entidades) {
			pessoa = (Pessoa) entidade;
			System.out.println("|  " +
					pessoa.getId() + " | " +
					pessoa.getNome() + " | " +
					pessoa.getCpf() + " | " +
					pessoa.getEndereco().getLogradouro() + " | " +
					pessoa.getEndereco().getNumero() + " | " +
					pessoa.getEndereco().getBairro() + " | " +
					pessoa.getEndereco().getMunicipio() + " | " +
					pessoa.getEndereco().getUf() + " | " +
					pessoa.getTelefone().getTipo() + " | " +
					pessoa.getTelefone().getNumero() + " |");
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
	}

}
