package webservice.evento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento implements Serializable {
	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "titulo", nullable = false, length = 100)
	private String titulo;
	@Column(name = "descricao", nullable = true, length = 500)
	private String descricao;
	@Column(name = "local", nullable = false)
	private String local;
	@Column(name = "imagem", nullable = true)
	private String imagem;
	
	public Evento () {}

	public Evento(int id, String titulo, String descricao, String local, String imagem) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.local = local;
		this.imagem = imagem;
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
