package test;

import java.util.List;

import controller.EnderecoController;
import enumerator.Estado;
import enumerator.Sgbd;
import factory.Fabrica;
import logic.Endereco;
import logic.Entidade;
import persistence.Banco;
import persistence.dao.Tabela;

public class MainTest {

	public static void main(String[] args) {
		
		//Instanciando Banco e selecionando tabelas...
		Banco cadastroDePessoas = Fabrica.estabelecerConexao(Sgbd.MySQL);		
		Tabela tabelaEndereco = cadastroDePessoas.getTabela("endereco");
		
		//teste inserir endereço...
		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Rua projetada Sem Número");
		endereco1.setNumero(0);
		endereco1.setBairro("Centro");
		endereco1.setMunicipio("São João da Serra");
		endereco1.setUf(Estado.PB);
		EnderecoController enderecoController = new EnderecoController(tabelaEndereco);
		enderecoController.inserir(endereco1);
		
		//teste buscar endereço...
		Endereco endereco = (Endereco) enderecoController.buscar(endereco1);
		System.out.println(endereco.getId());
		System.out.println(endereco.getNumero());
		
		//teste alterar endereço...
		endereco1.setNumero(123);
		enderecoController.alterar(endereco1);
		endereco = (Endereco) enderecoController.buscar(endereco1);
		System.out.println(endereco.getId());
		System.out.println(endereco.getNumero());
		
		//teste listar endereço...
		Endereco endereco2 = new Endereco();		
		endereco2.setLogradouro("Avenida das Loucas");
		endereco2.setNumero(456);
		endereco2.setBairro("Centro");
		endereco2.setMunicipio("Remígio");
		endereco2.setUf(Estado.PB);
		enderecoController.inserir(endereco2);		
		List<Entidade> enderecos = enderecoController.listar();
		for (Entidade entidade : enderecos) {
			endereco = (Endereco) entidade; 
			System.out.println(endereco.getId() 
				+ " " + endereco.getLogradouro()
				+ " " + endereco.getNumero()
				+ " " + endereco.getBairro()
				+ " " + endereco.getMunicipio()
				+ " " + endereco.getUf());
		}		
		//teste excluir endereco...
		endereco = (Endereco) enderecoController.buscar(endereco1);
		enderecoController.excluir(endereco);
		enderecos = enderecoController.listar();
		for (Entidade entidade : enderecos) {
			endereco = (Endereco) entidade; 
			System.out.println(endereco.getId() 
				+ " " + endereco.getLogradouro()
				+ " " + endereco.getNumero()
				+ " " + endereco.getBairro()
				+ " " + endereco.getMunicipio()
				+ " " + endereco.getUf());
		}
				
		/*Telefone telefone1 = new Telefone();
		telefone1.setTipo(TipoDeTelefone.RESIDENCIAL);
		telefone1.setNumero(8366666666l);
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Fulano DeTall");
		pessoa1.setCpf("111.111.111-11");
		pessoa1.setEndereco(endereco1);
		pessoa1.setTelefone(telefone1);*/
		
	}

}
