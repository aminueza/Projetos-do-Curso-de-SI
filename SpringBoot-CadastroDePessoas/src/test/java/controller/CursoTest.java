package controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import enumerator.Sgbd;
import factory.Fabrica;
import logic.Curso;
import logic.Entidade;
import logic.JogosDigitais;
import logic.SistemasDeInformacao;
import persistence.Banco;
import persistence.dao.Tabela;

public class CursoTest {

	private Banco cadastroDePessoas;		
	private Tabela tabelaCurso;
	private CursoController cursoController;
	
	@Before
	public void instanciar() {
		this.cadastroDePessoas = Fabrica.estabelecerConexao(Sgbd.MySQL);
		this.tabelaCurso = cadastroDePessoas.getTabela("curso");
		this.cursoController = new CursoController(tabelaCurso);
	}
	
	@Test
	public void incluir() {
		Curso curso = new Curso();
		cursoController.inserir(curso);
		assertEquals(curso, (Curso) cursoController.buscar(curso));
	}	
	
	@Test
	public void incrementoAutomatico() {
		Curso curso = new Curso();
		cursoController.inserir(curso);
		cursoController.inserir(curso);
		assertEquals(2, ((Curso) cursoController.buscar(curso)).getId());
	}
	
	@Test
	public void alterar() {
		Curso curso1 = new SistemasDeInformacao();
		cursoController.inserir(curso1);
		assertEquals("Sistemas de Informação", ((Curso) cursoController.buscar(curso1)).getNome());	
		Curso curso2 = new Curso();
		curso2 = (Curso) cursoController.buscar(curso1);
		curso2.setNome("Administração");
		cursoController.alterar(curso2);
		assertEquals("Administração", ((Curso) cursoController.buscar(curso2)).getNome());		
	}
	
	@Test
	public void listar() {
		Curso curso1 = new SistemasDeInformacao();
		cursoController.inserir(curso1);
		Curso curso2 = new JogosDigitais();		
		curso2.setNome("Jogos Digitais        ");
		cursoController.inserir(curso2);
		assertEquals(2, cursoController.listar().size());
		exibir();
	}
	
	@Test
	public void excluir() {
		Curso curso = new Curso();
		cursoController.inserir(curso);
		assertFalse(cursoController.listar().isEmpty());
		cursoController.excluir(curso);
		assertTrue(cursoController.listar().isEmpty());
	}
	
	@After
	public void finalizar() {
		limparTabela();
		this.cursoController = null;
		this.tabelaCurso = null;
		this.cadastroDePessoas = null;
	}
	
	private void limparTabela() {
		List<Entidade> entidades = cursoController.listar();
		for (Entidade entidade : entidades) {
			cursoController.excluir(entidade);
		}
	}
	
	private void exibir() {
		List<Entidade> entidades = cursoController.listar();
		Curso curso = null;
		System.out.println("------------------------------------------------");
		System.out.println("| Id | Nome                   | Área   | Carga |");
		System.out.println("------------------------------------------------");
		for (Entidade entidade : entidades) {
			curso = (Curso) entidade;
			System.out.println("|  " +
					curso.getId() + " | " +
					curso.getNome() + " | " +
					curso.getArea() + " | " +
					curso.getCargaHoraria() + "  |");
		}
		System.out.println("------------------------------------------------");
	}

}
