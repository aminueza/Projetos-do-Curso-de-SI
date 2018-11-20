package controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import enumerator.Sgbd;
import enumerator.TipoDeTelefone;
import factory.Fabrica;
import logic.Telefone;
import logic.Entidade;
import persistence.Banco;
import persistence.dao.Tabela;

public class TelefoneTest {

	private Banco cadastroDePessoas;		
	private Tabela tabelaTelefone;
	private TelefoneController telefoneController;
	
	@Before
	public void instanciar() {
		this.cadastroDePessoas = Fabrica.estabelecerConexao(Sgbd.Oracle);
		this.tabelaTelefone = cadastroDePessoas.getTabela("telefone");
		this.telefoneController = new TelefoneController(tabelaTelefone);
	}
	
	@Test
	public void incluir() {
		Telefone telefone = new Telefone();
		telefoneController.inserir(telefone);
		assertEquals(telefone, (Telefone) telefoneController.buscar(telefone));
	}	
	
	@Test
	public void incrementoAutomatico() {
		Telefone telefone = new Telefone();
		telefoneController.inserir(telefone);
		telefoneController.inserir(telefone);
		assertEquals(2, ((Telefone) telefoneController.buscar(telefone)).getId());
	}
	
	@Test
	public void alterar() {
		Telefone telefone1 = new Telefone();
		telefone1.setTipo(TipoDeTelefone.RESIDENCIAL);
		telefoneController.inserir(telefone1);
		assertEquals(TipoDeTelefone.RESIDENCIAL, ((Telefone) telefoneController.buscar(telefone1)).getTipo());	
		Telefone telefone2 = new Telefone();
		telefone2 = (Telefone) telefoneController.buscar(telefone1);
		telefone2.setTipo(TipoDeTelefone.COMERCIAL);
		telefoneController.alterar(telefone2);
		assertEquals(TipoDeTelefone.COMERCIAL, ((Telefone) telefoneController.buscar(telefone2)).getTipo());		
	}
	
	@Test
	public void listar() {
		Telefone telefone1 = new Telefone();
		telefone1.setTipo(TipoDeTelefone.RESIDENCIAL);
		telefone1.setNumero(8366666666l);
		telefoneController.inserir(telefone1);
		Telefone telefone2 = new Telefone();		
		telefone2.setTipo(TipoDeTelefone.COMERCIAL);
		telefone2.setNumero(8322223333l);
		telefoneController.inserir(telefone2);
		assertEquals(2, telefoneController.listar().size());
		exibir();
	}
	
	@Test
	public void excluir() {
		Telefone telefone = new Telefone();
		telefoneController.inserir(telefone);
		assertFalse(telefoneController.listar().isEmpty());
		telefoneController.excluir(telefone);
		assertTrue(telefoneController.listar().isEmpty());
	}
	
	@After
	public void finalizar() {
		limparTabela();
		this.telefoneController = null;
		this.tabelaTelefone = null;
		this.cadastroDePessoas = null;
	}
	
	private void limparTabela() {
		List<Entidade> entidades = telefoneController.listar();
		for (Entidade entidade : entidades) {
			telefoneController.excluir(entidade);
		}
	}
	
	private void exibir() {
		List<Entidade> entidades = telefoneController.listar();
		Telefone telefone = null;
		System.out.println("----------------------------------");
		System.out.println("| Id | Tipo de Telefone | Numero |");
		System.out.println("----------------------------------");
		for (Entidade entidade : entidades) {
			telefone = (Telefone) entidade;
			System.out.println("|  " +
					telefone.getId() + " | " +
					telefone.getTipo() + " | " +
					telefone.getNumero() + " |");
		}
		System.out.println("----------------------------------");
	}

}
