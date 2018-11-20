package controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import enumerator.Estado;
import enumerator.Sgbd;
import factory.Fabrica;
import logic.Endereco;
import logic.Entidade;
import persistence.Banco;
import persistence.dao.Tabela;

public class EnderecoTest {

	private Banco cadastroDePessoas;		
	private Tabela tabelaEndereco;
	private EnderecoController enderecoController;
	
	@Before
	public void instanciar() {
		this.cadastroDePessoas = Fabrica.estabelecerConexao(Sgbd.MySQL);
		this.tabelaEndereco = cadastroDePessoas.getTabela("endereco");
		this.enderecoController = new EnderecoController(tabelaEndereco);
	}
	
	@Test
	public void incluir() {
		Endereco endereco = new Endereco();
		enderecoController.inserir(endereco);
		assertEquals(endereco, (Endereco) enderecoController.buscar(endereco));
	}	
	
	@Test
	public void incrementoAutomatico() {
		Endereco endereco = new Endereco();
		enderecoController.inserir(endereco);
		enderecoController.inserir(endereco);
		assertEquals(2, ((Endereco) enderecoController.buscar(endereco)).getId());
	}
	
	@Test
	public void alterar() {
		Endereco endereco1 = new Endereco();
		endereco1.setUf(Estado.SP);
		enderecoController.inserir(endereco1);
		assertEquals(Estado.SP, ((Endereco) enderecoController.buscar(endereco1)).getUf());	
		Endereco endereco2 = new Endereco();
		endereco2 = (Endereco) enderecoController.buscar(endereco1);
		endereco2.setUf(Estado.PB);
		enderecoController.alterar(endereco2);
		assertEquals(Estado.PB, ((Endereco) enderecoController.buscar(endereco2)).getUf());		
	}
	
	@Test
	public void listar() {
		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Rua projetada Sem Nome");
		endereco1.setNumero(387);
		endereco1.setBairro("Centro");
		endereco1.setMunicipio("São João da Serra");
		endereco1.setUf(Estado.PI);
		enderecoController.inserir(endereco1);
		Endereco endereco2 = new Endereco();		
		endereco2.setLogradouro("Avenida das Loucas    ");
		endereco2.setNumero(456);
		endereco2.setBairro("Centro");
		endereco2.setMunicipio("Remígio          ");
		endereco2.setUf(Estado.PB);
		enderecoController.inserir(endereco2);
		assertEquals(2, enderecoController.listar().size());
		exibir();
	}
	
	@Test
	public void excluir() {
		Endereco endereco = new Endereco();
		enderecoController.inserir(endereco);
		assertFalse(enderecoController.listar().isEmpty());
		enderecoController.excluir(endereco);
		assertTrue(enderecoController.listar().isEmpty());
	}
	
	@After
	public void finalizar() {
		limparTabela();
		this.enderecoController = null;
		this.tabelaEndereco = null;
		this.cadastroDePessoas = null;
	}
	
	private void limparTabela() {
		List<Entidade> entidades = enderecoController.listar();
		for (Entidade entidade : entidades) {
			enderecoController.excluir(entidade);
		}
	}
	
	private void exibir() {
		List<Entidade> entidades = enderecoController.listar();
		Endereco endereco = null;
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("| Id | Logradouro             | Nº  | Bairro | Municipio         | Uf |");
		System.out.println("-----------------------------------------------------------------------");
		for (Entidade entidade : entidades) {
			endereco = (Endereco) entidade;
			System.out.println("|  " +
					endereco.getId() + " | " +
					endereco.getLogradouro() + " | " +
					endereco.getNumero() + " | " +
					endereco.getBairro() + " | " +
					endereco.getMunicipio() + " | " +
					endereco.getUf().toString() + " |");
		}
		System.out.println("-----------------------------------------------------------------------");
	}

}
