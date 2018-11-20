package webservice.task;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task implements Serializable {
	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "titulo", nullable = false, length = 100)
	private String titulo;
	@Column(name = "descricao", nullable = true, length = 500)
	private String descricao;
	@Column(name = "deadline", nullable = false)
	private Timestamp deadline;
	@Column(name = "grupotarefa", nullable = false)
	private int grupotarefa;
	@Column(name = "criador", nullable = true)
	private String criador;
	@Column(name = "criacao", nullable = true)
	private Timestamp criacao;
	
	public Task () {}

	public Task(int id, String titulo, String descricao, Timestamp deadline, int grupotarefa, String criador, Timestamp criacao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.deadline = deadline;
		this.grupotarefa = grupotarefa;
		this.criador = criador;
		this.criacao = criacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public int getGrupotarefa() {
		return grupotarefa;
	}

	public void setGrupotarefa(int grupotarefa) {
		this.grupotarefa = grupotarefa;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
	}

	public Timestamp getCriacao() {
		return criacao;
	}

	public void setCriacao(Timestamp criacao) {
		this.criacao = criacao;
	}
}
