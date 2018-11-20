package br.edu.cesed.facisa.si.tap.logic;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
@ApiModel(value = "Entidade Paciente", description = "Informacoes dos pacientes")
public class Paciente implements Serializable {

	private static final long serialVersionUID = -6577168591299349632L;

	@Id
	@ApiModelProperty(value = "Id do Paciente", required = true)
	private int id;
	
	@ApiModelProperty(value = "Nome do Paciente", required = true)
	private String nome;
	
	@ApiModelProperty(value = "Cartao do Sus do Paciente", required = true)
	private long cartaoSus;
	
	public Paciente() {}

	public Paciente(int id, String nome, long cartaoSus) {
		this.id = id;
		this.nome = nome;
		this.cartaoSus = cartaoSus;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(long cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", cartaoSus=" + cartaoSus + "]";
	}

}
